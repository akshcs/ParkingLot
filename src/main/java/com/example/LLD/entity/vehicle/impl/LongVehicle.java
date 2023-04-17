package com.example.LLD.entity.vehicle.impl;

import com.example.LLD.entity.parking.enums.ParkingSlotType;
import com.example.LLD.entity.vehicle.enums.VehicleType;

public class LongVehicle extends AbstractVehicle{
    public LongVehicle(long licenceNumber) {
        super(licenceNumber, VehicleType.LONG_VEHICLE);
    }

    @Override
    public double getFirstHourFee(){
        return 6.0;
    }
    @Override
    public double getSecondAndThirdHourFee(){
        return 4.5;
    }
    @Override
    public double getAdditionalHourFee(){
        return 3.5;
    }

    @Override
    public ParkingSlotType getParkingSlotType() {
        return ParkingSlotType.LARGE_SLOT;
    }
}
