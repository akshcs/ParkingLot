package com.example.LLD.entity.parking.slot.factory;

import com.example.LLD.entity.parking.slot.impl.*;

public class ParkingSlotFactory {
    public static CarParkingSlot createCarParkingSlot(long id){
        return new CarParkingSlot(id);
    }

    public static ElectricVehicleParkingSlot createElectricVehicleParkingSlot(long id){
        return new ElectricVehicleParkingSlot(id);
    }

    public static VanParkingSlot createVanParkingSlot(long id){
        return new VanParkingSlot(id);
    }

    public static TruckParkingSlot createTruckParkingSlot(long id){
        return new TruckParkingSlot(id);
    }

    public static MotorBikeParkingSlot createMotorBikeParkingSlot(long id){
        return new MotorBikeParkingSlot(id);
    }

    public static LongVehicleParkingSlot createLongVehicleParkingSlot(long id){
        return new LongVehicleParkingSlot(id);
    }

    public static HandicappedParkingSlot createHandicappedParkingSlot(long id){
        return new HandicappedParkingSlot(id);
    }
}
