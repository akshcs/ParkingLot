package com.example.LLD.entity.parking.slot.impl;

import com.example.LLD.entity.parking.enums.ParkingSlotStatus;
import com.example.LLD.entity.parking.enums.ParkingSlotType;
import lombok.Data;

@Data
public class ElectricVehicleParkingSlot extends ParkingSlot{
    public ElectricVehicleParkingSlot(long parkingSlotId) {
        super(ParkingSlotStatus.FREE,parkingSlotId, ParkingSlotType.ELECTRIC_SLOT);
    }

    @Override
    public double getPerMinuteCharge() {
        return 0.08;
    }

    @Override
    public double getFirstHourCharge() {
        return 5.0;
    }

    @Override
    public double getPerHourCharge() {
        return 3.0;
    }
}
