package com.example.LLD.entity.parking;

import com.example.LLD.entity.parking.enums.ParkingSlotStatus;
import com.example.LLD.entity.parking.enums.ParkingSlotType;
import com.example.LLD.entity.vehicle.intf.Vehicle;

import static com.example.LLD.entity.parking.enums.ParkingSlotStatus.FREE;
import static com.example.LLD.entity.parking.enums.ParkingSlotStatus.OCCUPIED;

public class ParkingSlot {
    private final String slotNumber;
    private Vehicle vehicle;
    private ParkingSlotType parkingSlotType;
    private ParkingSlotStatus parkingSlotStatus;


    public ParkingSlot(String slotNumber, ParkingSlotType parkingSlotType) {
        this.slotNumber = slotNumber;
        this.parkingSlotType = parkingSlotType;
        this.parkingSlotStatus = FREE;
    }

    public void removeVehicle() {
        vehicle = null;
        parkingSlotStatus = FREE;
    }

    public void addVehicle(Vehicle vehicle) {
        this.vehicle = vehicle;
        parkingSlotStatus = OCCUPIED;
    }

    public boolean isFree() {
        return (parkingSlotStatus==FREE);
    }

    public Vehicle getVehicle() {
        return vehicle;
    }

    public String getSlotNumber() {
        return slotNumber;
    }

    public ParkingSlotType getParkingSlotType() {
        return parkingSlotType;
    }

    public void setParkingSlotType(ParkingSlotType parkingSlotType) {
        this.parkingSlotType = parkingSlotType;
    }

    public ParkingSlotStatus getParkingSlotStatus() {
        return parkingSlotStatus;
    }

    public void setParkingSlotStatus(ParkingSlotStatus parkingSlotStatus) {
        this.parkingSlotStatus = parkingSlotStatus;
    }
}
