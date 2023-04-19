package com.example.LLD.exception.parking;

import com.example.LLD.entity.parking.slot.impl.ParkingSlot;

public class InvalidParkingSlotException extends Exception{
    public InvalidParkingSlotException(ParkingSlot parkingSlot){
        super("Invalid Parking Slot : " + parkingSlot.getParkingSlotId() + " does not exists for " + parkingSlot.getParkingSlotType().toString());
    }
}
