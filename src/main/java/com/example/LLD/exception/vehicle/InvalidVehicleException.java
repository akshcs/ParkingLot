package com.example.LLD.exception.vehicle;

import com.example.LLD.entity.vehicle.impl.Vehicle;

public class InvalidVehicleException extends Exception{
    public InvalidVehicleException(Vehicle vehicle){
        super("Invalid Vehicle : Please provide correct vehicle information -- " + vehicle.toString());
    }
}
