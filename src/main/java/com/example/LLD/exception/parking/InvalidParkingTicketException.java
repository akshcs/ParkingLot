package com.example.LLD.exception.parking;

import com.example.LLD.entity.parking.ParkingTicket;

public class InvalidParkingTicketException extends Exception{
    public InvalidParkingTicketException(ParkingTicket parkingTicket){
        super("Invalid Parking Ticket : " + parkingTicket.toString() + " Please provide a valid Parking Ticket");
    }
}
