package com.example.LLD.entity.panel.impl;

import com.example.LLD.entity.parking.ParkingTicket;
import com.example.LLD.entity.parking.enums.ParkingTicketStatus;
import com.example.LLD.service.ParkingFeeCalculatorService;

import java.time.LocalDateTime;

public class ExitPanel extends AbstractPanel{
    private final ParkingFeeCalculatorService parkingFeeCalculatorService;
    public ExitPanel(int exitPanelNumber) {
        super(exitPanelNumber);
        parkingFeeCalculatorService = new ParkingFeeCalculatorService();
    }

    public void scanTicket(ParkingTicket parkingTicket){
        parkingTicket.setPayTime(LocalDateTime.now());
        double fee = parkingFeeCalculatorService.getParkingFee(parkingTicket);
        parkingTicket.setParkingFee(fee);
    }

    public void takePayment(ParkingTicket parkingTicket){
        double fee = parkingTicket.getParkingFee();
        if(paymentDone(fee)) {
            parkingTicket.setParkingTicketStatus(ParkingTicketStatus.PAID);
            parkingTicket.getParkingFloor().removeVehicle(parkingTicket.getParkingSlot());
        }
    }

    private boolean paymentDone(double fee){
        return true;
    }
}
