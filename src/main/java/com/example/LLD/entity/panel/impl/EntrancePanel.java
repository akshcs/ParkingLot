package com.example.LLD.entity.panel.impl;

import com.example.LLD.entity.parking.ParkingLot;
import com.example.LLD.entity.parking.ParkingTicket;
import com.example.LLD.entity.vehicle.enums.VehicleType;

public class EntrancePanel extends AbstractPanel{
    private final ParkingLot parkingLot;
    public EntrancePanel(int entrancePanelNumber) {
        super(entrancePanelNumber);
        parkingLot = new ParkingLot("Some random address");
    }

    public void printTicket(ParkingTicket parkingTicket){
        System.out.println("Printing Ticket : " + parkingTicket.getTicketId());
    }

    public ParkingTicket getParkingTicket(long licenseNumber, VehicleType vehicleType){
        return parkingLot.getParkingTicket(licenseNumber, vehicleType);
    }
}
