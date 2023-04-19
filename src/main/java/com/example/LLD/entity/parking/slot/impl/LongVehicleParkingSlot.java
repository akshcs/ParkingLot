package com.example.LLD.entity.parking.slot.impl;

import com.example.LLD.entity.parking.enums.ParkingSlotStatus;
import com.example.LLD.entity.parking.enums.ParkingSlotType;
import lombok.Builder;
import lombok.Data;

@Data
public class LongVehicleParkingSlot extends ParkingSlot{
    public LongVehicleParkingSlot(long parkingSlotId) {
        super(ParkingSlotStatus.FREE, parkingSlotId, ParkingSlotType.LARGE_SLOT);
    }

    @Override
    public double getPerMinuteCharge() {
        return 0.1;
    }

    @Override
    public double getFirstHourCharge() {
        return 6.0;
    }

    @Override
    public double getPerHourCharge() {
        return 4.0;
    }
}
