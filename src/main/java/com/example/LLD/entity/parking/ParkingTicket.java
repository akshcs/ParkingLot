package com.example.LLD.entity.parking;

import com.example.LLD.entity.parking.enums.ParkingTicketStatus;
import com.example.LLD.entity.parking.fee.stratergy.intf.ParkingFeeStrategy;
import com.example.LLD.entity.parking.slot.impl.ParkingSlot;
import com.example.LLD.entity.vehicle.impl.Vehicle;
import lombok.Builder;
import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;

import java.time.LocalDateTime;

;

@Data
public class ParkingTicket {
    private LocalDateTime payTime;
    private long ticketId;
    private double parkingFee;
    private Vehicle vehicle;
    private ParkingSlot parkingSlot;
    private ParkingTicketStatus parkingTicketStatus;
    private ParkingFeeStrategy parkingFeeStrategy;
    private LocalDateTime issueTime;
    private static long ticketCounter = 1;

    @Autowired
    @Qualifier("HourlyParkingFeeStrategy")
    private ParkingFeeStrategy hourlyparkingFeeStrategy;

    public ParkingTicket(Vehicle vehicle, ParkingSlot parkingSlot) {
        this.ticketId = ticketCounter++;
        this.parkingTicketStatus = ParkingTicketStatus.ACTIVE;
        this.issueTime = LocalDateTime.now();
        this.vehicle = vehicle;
        this.parkingSlot = parkingSlot;
        this.parkingFeeStrategy = hourlyparkingFeeStrategy;
        parkingFee = 0.0;
    }
}
