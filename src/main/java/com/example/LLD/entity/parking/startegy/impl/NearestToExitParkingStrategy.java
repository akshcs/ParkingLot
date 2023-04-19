package com.example.LLD.entity.parking.startegy.impl;

import com.example.LLD.entity.parking.slot.impl.ParkingSlot;
import com.example.LLD.entity.parking.startegy.ParkingSlotComparatorReverse;
import com.example.LLD.entity.parking.slot.impl.ParkingSlot;
import com.example.LLD.entity.parking.startegy.intf.ParkingStrategy;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Optional;

@Component
@Qualifier("NearestToExitParkingStrategy")
public class NearestToExitParkingStrategy implements ParkingStrategy {
    @Autowired
    @Qualifier("ParkingSlotComparatorReverse")
    private Comparator<ParkingSlot> comparator;
    @Override
    public ParkingSlot findParkingSlot(List<ParkingSlot> parkingSlots) {
        Collections.sort(parkingSlots, comparator);
        Optional<ParkingSlot> parkingSlot = parkingSlots.stream().filter(entry -> entry.isFree()).findFirst();
        return parkingSlot.isPresent() ? parkingSlot.get() : null;
    }
}
