package com.example.LLD.entity.parking.slot.impl;

import com.example.LLD.entity.parking.enums.ParkingSlotStatus;
import com.example.LLD.entity.parking.enums.ParkingSlotType;
import lombok.Builder;
import lombok.Data;

@Data
public class HandicappedParkingSlot extends ParkingSlot{
    public HandicappedParkingSlot(long parkingSlotId) {
        super(ParkingSlotStatus.FREE, parkingSlotId, ParkingSlotType.HANDICAPPED_SLOT);
    }

    @Override
    public double getPerMinuteCharge() {
        return 0.0;
    }

    @Override
    public double getFirstHourCharge() {
        return 0.0;
    }

    @Override
    public double getPerHourCharge() {
        return 0.0;
    }
}
