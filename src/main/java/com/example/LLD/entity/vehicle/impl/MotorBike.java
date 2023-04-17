package com.example.LLD.entity.vehicle.impl;

import com.example.LLD.entity.parking.enums.ParkingSlotType;
import com.example.LLD.entity.vehicle.enums.VehicleType;

public class MotorBike extends AbstractVehicle{
    public MotorBike(long licenceNumber) {
        super(licenceNumber, VehicleType.MOTOR_BIKE);
    }

    @Override
    public double getFirstHourFee(){
        return 2.0;
    }
    @Override
    public double getSecondAndThirdHourFee(){
        return 1.5;
    }
    @Override
    public double getAdditionalHourFee(){
        return 1.0;
    }
    @Override
    public ParkingSlotType getParkingSlotType() {
        return ParkingSlotType.MOTORBIKE_SLOT;
    }
}
