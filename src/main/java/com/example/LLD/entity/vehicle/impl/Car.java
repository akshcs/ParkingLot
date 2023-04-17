package com.example.LLD.entity.vehicle.impl;

import com.example.LLD.entity.parking.enums.ParkingSlotType;
import com.example.LLD.entity.vehicle.enums.VehicleType;

public class Car extends AbstractVehicle {
    public Car(long licenceNumber) {
        super(licenceNumber, VehicleType.CAR);
    }
    @Override
    public ParkingSlotType getParkingSlotType() {
        return ParkingSlotType.COMPACT_SLOT;
    }
}
