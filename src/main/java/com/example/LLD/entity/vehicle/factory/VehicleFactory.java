package com.example.LLD.entity.vehicle.factory;

import com.example.LLD.entity.vehicle.enums.VehicleType;
import com.example.LLD.entity.vehicle.impl.*;
import org.springframework.stereotype.Component;

@Component
public class VehicleFactory {
    public static Vehicle getVehicle(long licenseNumber, VehicleType vehicleType){
        switch(vehicleType){
            case CAR:
                return new Car(licenseNumber);
            case VAN:
                return new Van(licenseNumber);
            case TRUCK:
                return new Truck(licenseNumber);
            case MOTOR_BIKE:
                return new MotorBike(licenseNumber);
            case LONG_VEHICLE:
                return new LongVehicle(licenseNumber);
            case ELECTRIC_VEHICLE:
                return new ElectricVehicle(licenseNumber);
            default:
                return null;
        }
    }
}
