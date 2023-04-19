package com.example.LLD.entity.parking.startegy;

import com.example.LLD.entity.parking.slot.impl.ParkingSlot;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

import java.util.Comparator;

@Component
@Qualifier("ParkingSlotComparatorReverse")
public class ParkingSlotComparatorReverse implements Comparator<ParkingSlot> {
    @Override
    public int compare(ParkingSlot p1, ParkingSlot p2) {
        return (int) (p2.getParkingSlotId() - p1.getParkingSlotId());
    }
}
