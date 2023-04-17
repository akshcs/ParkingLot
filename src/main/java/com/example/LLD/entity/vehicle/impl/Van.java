package com.example.LLD.entity.vehicle.impl;

import com.example.LLD.entity.parking.enums.ParkingSlotType;
import com.example.LLD.entity.vehicle.enums.VehicleType;

public class Van extends AbstractVehicle{
    public Van(long licenceNumber) {
        super(licenceNumber, VehicleType.VAN);
    }

    @Override
    public ParkingSlotType getParkingSlotType() {
        return ParkingSlotType.COMPACT_SLOT;
    }
}
