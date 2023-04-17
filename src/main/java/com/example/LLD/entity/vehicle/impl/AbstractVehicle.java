package com.example.LLD.entity.vehicle.impl;

import com.example.LLD.entity.parking.ParkingTicket;
import com.example.LLD.entity.vehicle.intf.Vehicle;
import com.example.LLD.entity.vehicle.enums.VehicleType;

public abstract class AbstractVehicle implements Vehicle {
    private final long licenceNumber;
    private final VehicleType vehicleType;
    private ParkingTicket parkingTicket;

    private static final double firstHourFee = 4;
    private static final double SecondAndThirdHourFee = 3.5;
    private static final double additionalHourFee = 2.5;

    protected AbstractVehicle(long licenceNumber, VehicleType vehicleType) {
        this.licenceNumber = licenceNumber;
        this.vehicleType = vehicleType;
    }
    @Override
    public double getFirstHourFee(){
        return firstHourFee;
    }
    @Override
    public double getSecondAndThirdHourFee(){
        return SecondAndThirdHourFee;
    }
    @Override
    public double getAdditionalHourFee(){
        return additionalHourFee;
    }

    @Override
    public ParkingTicket getParkingTicket(){
        return this.parkingTicket;
    }

    @Override
    public void setParkingTicket(ParkingTicket parkingTicket){
        this.parkingTicket = parkingTicket;
    }
}
