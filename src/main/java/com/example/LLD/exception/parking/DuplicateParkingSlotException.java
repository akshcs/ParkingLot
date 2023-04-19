package com.example.LLD.exception.parking;

import com.example.LLD.entity.parking.slot.impl.ParkingSlot;

public class DuplicateParkingSlotException extends Exception{
    public DuplicateParkingSlotException(ParkingSlot parkingSlot){
        super("Duplicate Parking Slot : " + parkingSlot.getParkingSlotId() + " already exists for " + parkingSlot.getParkingSlotType().toString());
    }
}
