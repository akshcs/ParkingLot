package com.example.LLD.exception.parking;

public class ParkingSlotFullException extends Exception{
    public ParkingSlotFullException(){
        super("Parking is Full");
    }
}
