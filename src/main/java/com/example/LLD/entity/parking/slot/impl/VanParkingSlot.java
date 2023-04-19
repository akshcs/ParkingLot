package com.example.LLD.entity.parking.slot.impl;

import com.example.LLD.entity.parking.enums.ParkingSlotStatus;
import com.example.LLD.entity.parking.enums.ParkingSlotType;
import lombok.Data;

@Data
public class VanParkingSlot extends ParkingSlot{
    public VanParkingSlot(long parkingSlotId) {
        super(ParkingSlotStatus.FREE, parkingSlotId, ParkingSlotType.COMPACT_SLOT);
    }

    @Override
    public double getPerMinuteCharge() {
        return 0.05;
    }

    @Override
    public double getFirstHourCharge() {
        return 3.0;
    }

    @Override
    public double getPerHourCharge() {
        return 2.0;
    }
}
