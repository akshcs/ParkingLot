package com.example.LLD.entity.parking.slot.impl;

import com.example.LLD.entity.parking.enums.ParkingSlotStatus;
import com.example.LLD.entity.parking.enums.ParkingSlotType;
import lombok.Builder;
import lombok.Data;

@Data
public class MotorBikeParkingSlot extends ParkingSlot{
    public MotorBikeParkingSlot(long parkingSlotId) {
        super(ParkingSlotStatus.FREE, parkingSlotId, ParkingSlotType.MOTORBIKE_SLOT);
    }

    @Override
    public double getPerMinuteCharge() {
        return 0.03;
    }

    @Override
    public double getFirstHourCharge() {
        return 2.0;
    }

    @Override
    public double getPerHourCharge() {
        return 1.0;
    }
}
