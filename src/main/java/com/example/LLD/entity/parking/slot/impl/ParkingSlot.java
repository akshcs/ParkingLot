package com.example.LLD.entity.parking.slot.impl;

import com.example.LLD.entity.parking.enums.ParkingSlotStatus;
import com.example.LLD.entity.parking.enums.ParkingSlotType;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public abstract class ParkingSlot {
    private ParkingSlotStatus parkingSlotStatus = ParkingSlotStatus.FREE;
    private long parkingSlotId;
    private ParkingSlotType parkingSlotType;

    public boolean isFree() {
        return (parkingSlotStatus==ParkingSlotStatus.FREE);
    }

    public void addVehicle(){
        parkingSlotStatus = ParkingSlotStatus.OCCUPIED;
    }

    public void removeVehicle(){
        parkingSlotStatus = ParkingSlotStatus.FREE;
    }

    public abstract double getPerMinuteCharge();

    public abstract double getFirstHourCharge();

    public abstract double getPerHourCharge();
}
