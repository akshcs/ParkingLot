package com.example.LLD.entity.vehicle.impl;

import com.example.LLD.entity.parking.enums.ParkingSlotType;
import com.example.LLD.entity.vehicle.enums.VehicleType;
import lombok.Data;

@Data
public class MotorBike extends Vehicle {
    public MotorBike(long licenceNumber) {
        super(licenceNumber, VehicleType.MOTOR_BIKE, ParkingSlotType.MOTORBIKE_SLOT);
    }
}
