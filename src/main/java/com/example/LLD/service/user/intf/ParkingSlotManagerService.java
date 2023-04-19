package com.example.LLD.service.user.intf;

import com.example.LLD.entity.parking.slot.impl.ParkingSlot;
import com.example.LLD.exception.parking.DuplicateParkingSlotException;
import com.example.LLD.exception.parking.InvalidParkingSlotException;

public interface ParkingSlotManagerService {
    public boolean addParkingSlot(ParkingSlot parkingSlot) throws DuplicateParkingSlotException;
    public boolean removeParkingSlot(ParkingSlot parkingSlot) throws InvalidParkingSlotException;
}
