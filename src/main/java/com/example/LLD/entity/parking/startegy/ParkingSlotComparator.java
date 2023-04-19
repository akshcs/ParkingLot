package com.example.LLD.entity.parking.startegy;

import com.example.LLD.entity.parking.slot.impl.ParkingSlot;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

import java.util.Comparator;


@Component
@Qualifier("ParkingSlotComparator")
public class ParkingSlotComparator implements Comparator<ParkingSlot> {
    @Override
    public int compare(ParkingSlot p1, ParkingSlot p2) {
        return (int) (p1.getParkingSlotId()- p2.getParkingSlotId());
    }
}
