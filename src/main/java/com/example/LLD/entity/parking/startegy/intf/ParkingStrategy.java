package com.example.LLD.entity.parking.startegy.intf;

import com.example.LLD.entity.parking.slot.impl.ParkingSlot;

import java.util.List;

public interface ParkingStrategy {
    ParkingSlot findParkingSlot(List<ParkingSlot> parkingSlots);
}
