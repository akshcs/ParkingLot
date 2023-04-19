package com.example.LLD.entity.vehicle.impl;

import com.example.LLD.entity.parking.enums.ParkingSlotType;
import com.example.LLD.entity.vehicle.enums.VehicleType;
import lombok.Data;

@Data
public class Van extends Vehicle {
    public Van(long licenceNumber) {
        super(licenceNumber, VehicleType.VAN,ParkingSlotType.COMPACT_SLOT);
    }
}
