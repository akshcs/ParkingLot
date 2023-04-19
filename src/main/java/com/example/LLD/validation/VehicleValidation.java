package com.example.LLD.validation;

import com.example.LLD.entity.vehicle.impl.Vehicle;
import com.example.LLD.exception.vehicle.InvalidVehicleException;
import org.springframework.stereotype.Component;

import java.util.Objects;

@Component
public class VehicleValidation {
    public boolean validateVehicle(Vehicle vehicle) throws InvalidVehicleException {
        if(Objects.isNull(vehicle)){
            throw new InvalidVehicleException(null);
        }
        return true;
    }
}
