package com.example.LLD.entity.vehicle.impl;

import com.example.LLD.entity.parking.enums.ParkingSlotType;
import com.example.LLD.entity.vehicle.enums.VehicleType;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public abstract class Vehicle {
    private long licenceNumber;
    private VehicleType vehicleType;
    private ParkingSlotType parkingSlotType;
}
