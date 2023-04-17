package com.example.LLD.entity.vehicle.impl;

import com.example.LLD.entity.parking.enums.ParkingSlotType;
import com.example.LLD.entity.vehicle.enums.VehicleType;
import com.example.LLD.entity.vehicle.impl.AbstractVehicle;

public class ElectricVehicle extends AbstractVehicle {
    public ElectricVehicle(long licenceNumber) {
        super(licenceNumber, VehicleType.ELECTRIC_VEHICLE);
    }
    @Override
    public ParkingSlotType getParkingSlotType() {
        return ParkingSlotType.ELECTRIC_SLOT;
    }
}
