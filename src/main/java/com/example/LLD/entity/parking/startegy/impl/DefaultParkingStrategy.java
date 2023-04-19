package com.example.LLD.entity.parking.startegy.impl;

import com.example.LLD.entity.parking.slot.impl.ParkingSlot;
import com.example.LLD.entity.parking.startegy.intf.ParkingStrategy;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;

@Component
@Qualifier("DefaultParkingStrategy")
public class DefaultParkingStrategy implements ParkingStrategy {
    @Override
    public ParkingSlot findParkingSlot(List<ParkingSlot> parkingSlots) {
        Optional<ParkingSlot> parkingSlot = parkingSlots.stream().filter(entry -> entry.isFree()).findFirst();
        return parkingSlot.isPresent() ? parkingSlot.get() : null;
    }
}
