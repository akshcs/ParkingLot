package com.example.LLD.entity.vehicle.impl;

import com.example.LLD.entity.parking.enums.ParkingSlotType;
import com.example.LLD.entity.vehicle.enums.VehicleType;

public class Truck extends AbstractVehicle{
    public Truck(long licenceNumber) {
        super(licenceNumber, VehicleType.TRUCK);
    }

    @Override
    public double getFirstHourFee(){
        return 5.0;
    }
    @Override
    public double getSecondAndThirdHourFee(){
        return 4.0;
    }
    @Override
    public double getAdditionalHourFee(){
        return 3.0;
    }

    @Override
    public ParkingSlotType getParkingSlotType() {
        return ParkingSlotType.LARGE_SLOT;
    }
}
