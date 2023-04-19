package com.example.LLD.entity.vehicle.impl;

import com.example.LLD.entity.parking.enums.ParkingSlotType;
import com.example.LLD.entity.vehicle.enums.VehicleType;
import lombok.Data;

@Data
public class Car extends Vehicle {
    public Car(long licenceNumber) {
        super(licenceNumber, VehicleType.CAR, ParkingSlotType.COMPACT_SLOT);
    }
}
