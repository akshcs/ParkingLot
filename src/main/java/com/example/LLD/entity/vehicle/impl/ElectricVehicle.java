package com.example.LLD.entity.vehicle.impl;

import com.example.LLD.entity.parking.enums.ParkingSlotType;
import com.example.LLD.entity.vehicle.enums.VehicleType;
import lombok.Data;

@Data
public class ElectricVehicle extends Vehicle {
    public ElectricVehicle(long licenceNumber) {
        super(licenceNumber, VehicleType.ELECTRIC_VEHICLE, ParkingSlotType.ELECTRIC_SLOT);
    }
}
