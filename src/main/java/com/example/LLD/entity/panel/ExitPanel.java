package com.example.LLD.entity.panel;

import com.example.LLD.entity.parking.ParkingTicket;
import com.example.LLD.entity.parking.enums.ParkingTicketStatus;
import com.example.LLD.exception.parking.InvalidParkingTicketException;
import com.example.LLD.validation.ParkingValidation;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Component
public class ExitPanel {
    private int panelNumber;

    @Autowired
    private ParkingValidation parkingValidation;
    public ParkingTicket scanTicket(long id) throws InvalidParkingTicketException {
        ParkingTicket parkingTicket = parkingValidation.validateAndGetParkingTicket(id);
        parkingTicket.setPayTime(LocalDateTime.now());
        double fee = parkingTicket.getParkingFeeStrategy().getParkingFee(parkingTicket);
        parkingTicket.setParkingFee(fee);
        return parkingTicket;
    }

    public ParkingTicket takePayment(long id) throws InvalidParkingTicketException {
        ParkingTicket parkingTicket = parkingValidation.validateAndGetParkingTicket(id);
        double fee = parkingTicket.getParkingFee();
        if(paymentDone(fee)) {
            parkingTicket.setParkingTicketStatus(ParkingTicketStatus.PAID);
            parkingTicket.getParkingSlot().removeVehicle();
        }
        return parkingTicket;
    }

    private boolean paymentDone(double fee){
        return true;
    }
}
