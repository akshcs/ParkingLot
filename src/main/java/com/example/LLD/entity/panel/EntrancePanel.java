package com.example.LLD.entity.panel;

import com.example.LLD.entity.account.user.ParkingTicketManager;
import com.example.LLD.entity.account.user.factory.ParkingSlotManagerFactory;
import com.example.LLD.entity.dto.parking.ParkingTicketRequestDTO;
import com.example.LLD.entity.parking.ParkingTicket;
import com.example.LLD.entity.parking.enums.ParkingSlotType;
import com.example.LLD.entity.parking.fee.stratergy.intf.ParkingFeeStrategy;
import com.example.LLD.entity.parking.slot.impl.ParkingSlot;
import com.example.LLD.entity.vehicle.enums.VehicleType;
import com.example.LLD.entity.vehicle.impl.Vehicle;
import com.example.LLD.entity.vehicle.factory.VehicleFactory;
import com.example.LLD.exception.parking.InvalidParkingTicketException;
import com.example.LLD.exception.parking.ParkingSlotFullException;
import com.example.LLD.exception.vehicle.InvalidVehicleException;
import com.example.LLD.validation.ParkingValidation;
import com.example.LLD.validation.VehicleValidation;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Component
public class EntrancePanel {
    private int panelNumber;
    @Autowired
    @Qualifier("MinuteParkingFeeStrategy")
    private ParkingFeeStrategy minuteParkingFeeStrategy;

    @Autowired
    private ParkingSlotManagerFactory parkingSlotManagerFactory;

    @Autowired
    private ParkingValidation parkingValidation;

    @Autowired
    private VehicleValidation vehicleValidation;

    @Autowired
    private ParkingTicketManager parkingTicketManager;

    public ParkingSlot findParkingSlot(Vehicle vehicle, boolean isHandicapped) throws InvalidVehicleException, ParkingSlotFullException {
        vehicleValidation.validateVehicle(vehicle);
        vehicle = checkHandicapped(vehicle, isHandicapped);
        ParkingSlot parkingSlot = parkingSlotManagerFactory.getParkingSlotManager(vehicle.getParkingSlotType()).findParkingSlot();
        parkingValidation.validateParkingSlot(parkingSlot);
        return parkingSlot;
    }

    public ParkingTicket generateParkingTicket(ParkingTicketRequestDTO parkingTicketRequestDTO) throws ParkingSlotFullException, InvalidVehicleException {
        Vehicle vehicle = getVehicle(parkingTicketRequestDTO.getLicenseNumber(), parkingTicketRequestDTO.getVehicleType(),parkingTicketRequestDTO.isHandicapped());
        ParkingSlot parkingSlot = findParkingSlot(vehicle, parkingTicketRequestDTO.isHandicapped());
        return getParkingTicket(vehicle, parkingSlot, parkingTicketRequestDTO.isParkingFeeStrategyMinute());
    }

    public void printTicket(long id) throws InvalidParkingTicketException {
        ParkingTicket parkingTicket = parkingValidation.validateAndGetParkingTicket(id);
        System.out.println("Printing Ticket : " + parkingTicket.getTicketId());
    }

    private Vehicle getVehicle(long licenseNumber, VehicleType vehicleType, boolean isHandicapped){
        Vehicle vehicle = VehicleFactory.getVehicle(licenseNumber, vehicleType);
        return checkHandicapped(vehicle, isHandicapped);
    }

    private Vehicle checkHandicapped(Vehicle vehicle, boolean isHandicapped){
        if(isHandicapped){
            vehicle.setParkingSlotType(ParkingSlotType.HANDICAPPED_SLOT);
        }
        return vehicle;
    }

    private ParkingTicket getParkingTicket(Vehicle vehicle, ParkingSlot parkingSlot, boolean isParkingFeeStrategyMinute){
        parkingSlot.addVehicle();
        ParkingTicket parkingTicket = new ParkingTicket(vehicle, parkingSlot);
        if ((isParkingFeeStrategyMinute)){
            parkingTicket.setParkingFeeStrategy(minuteParkingFeeStrategy);
        }
        parkingTicketManager.addParkingTicket(parkingTicket);
        return parkingTicket;
    }
}
