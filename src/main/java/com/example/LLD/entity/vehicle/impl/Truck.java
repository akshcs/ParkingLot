package com.example.LLD.entity.vehicle.impl;

import com.example.LLD.entity.parking.enums.ParkingSlotType;
import com.example.LLD.entity.vehicle.enums.VehicleType;
import lombok.Data;

@Data
public class Truck extends Vehicle {
    public Truck(long licenceNumber) {
        super(licenceNumber, VehicleType.TRUCK, ParkingSlotType.LARGE_SLOT);
    }
}
