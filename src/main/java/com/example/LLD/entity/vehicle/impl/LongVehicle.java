package com.example.LLD.entity.vehicle.impl;

import com.example.LLD.entity.parking.enums.ParkingSlotType;
import com.example.LLD.entity.vehicle.enums.VehicleType;
import lombok.Data;

@Data
public class LongVehicle extends Vehicle {
    public LongVehicle(long licenceNumber) {
        super(licenceNumber, VehicleType.LONG_VEHICLE, ParkingSlotType.LARGE_SLOT);
    }
}
