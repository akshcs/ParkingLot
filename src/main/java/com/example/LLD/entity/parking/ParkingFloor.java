package com.example.LLD.entity.parking;

import com.example.LLD.entity.parking.enums.ParkingSlotType;
import com.example.LLD.entity.vehicle.intf.Vehicle;

import java.util.*;
import java.util.stream.Collectors;

public class ParkingFloor {
    private int floorNumber;
    private Map<ParkingSlotType, SortedMap<String, ParkingSlot>> parkingSlots;

    public ParkingFloor(int floorNumber){
        this.floorNumber = floorNumber;
        for(ParkingSlotType parkingSlotType : ParkingSlotType.values()){
            SortedMap<String, ParkingSlot> parkingSlotSortedMap = new TreeMap<>();
            parkingSlots.put(parkingSlotType, parkingSlotSortedMap);
        }
    }

    public void addParkingSlot(ParkingSlot parkingSlot){
        parkingSlots.get(parkingSlot.getParkingSlotType()).put(parkingSlot.getSlotNumber(), parkingSlot);
    }

    public void removeParkingSlot(ParkingSlot parkingSlot){
        parkingSlots.get(parkingSlot.getParkingSlotType()).remove(parkingSlot.getSlotNumber());
    }

    public ParkingSlot addVehicle(Vehicle vehicle){
        ParkingSlot parkingSlot = getFreeParkingSlotForType(vehicle.getParkingSlotType());
        if(Objects.nonNull(parkingSlot)){
            parkingSlot.addVehicle(vehicle);
        }
        return parkingSlot;
    }

    public void removeVehicle(ParkingSlot parkingSlot){
        parkingSlot.removeVehicle();
    }

    public Map<ParkingSlotType, SortedMap<String, ParkingSlot>> getAllParkingSlots(){
        return parkingSlots;
    }

    public Map<ParkingSlotType, SortedMap<String, ParkingSlot>> getAllFreeParkingSlots(){
        Map<ParkingSlotType, SortedMap<String, ParkingSlot>> freeParkingSlots = new HashMap<>();
        for(Map.Entry<ParkingSlotType, SortedMap<String, ParkingSlot>> parkingSlotsByType : parkingSlots.entrySet()){
            SortedMap<String, ParkingSlot> freeParkingSlotsByType = parkingSlotsByType.getValue().entrySet().stream().
                    filter(entry -> entry.getValue().isFree()).
                    collect(Collectors.toMap(SortedMap.Entry::getKey, SortedMap.Entry::getValue, (v1, v2) -> v1, TreeMap::new));
            freeParkingSlots.put(parkingSlotsByType.getKey(), freeParkingSlotsByType);
        }
        return freeParkingSlots;
    }

    public Map<ParkingSlotType, SortedMap<String, ParkingSlot>> getAllOccupiedParkingSlots(){
        Map<ParkingSlotType, SortedMap<String, ParkingSlot>> occupiedParkingSlots = new HashMap<>();
        for(Map.Entry<ParkingSlotType, SortedMap<String, ParkingSlot>> parkingSlotsByType : parkingSlots.entrySet()){
            SortedMap<String, ParkingSlot> occupiedParkingSlotsByType = parkingSlotsByType.getValue().entrySet().stream().
                    filter(entry -> !entry.getValue().isFree()).
                    collect(Collectors.toMap(SortedMap.Entry::getKey, SortedMap.Entry::getValue, (v1, v2) -> v1, TreeMap::new));
            occupiedParkingSlots.put(parkingSlotsByType.getKey(), occupiedParkingSlotsByType);
        }
        return occupiedParkingSlots;
    }

    private ParkingSlot getFreeParkingSlotForType(ParkingSlotType parkingSlotType){
        return parkingSlots.get(parkingSlotType).entrySet().stream()
                .filter(entry -> entry.getValue().isFree())
                .map(Map.Entry::getValue)
                .findFirst()
                .orElse(null);
    }

    private int getParkingSlotCount(Map<ParkingSlotType, SortedMap<String, ParkingSlot>> parkingSlots){
        return parkingSlots.values().stream().mapToInt(Map::size).sum();
    }

    public int getFreeSlotsCount(){
        return getParkingSlotCount(getAllFreeParkingSlots());
    }

    public int getOccupiedSlotsCount(){
        return getParkingSlotCount(getAllOccupiedParkingSlots());
    }

    public int getFloorNumber(){
        return floorNumber;
    }

    public boolean isFull(){
        return (getParkingSlotCount(parkingSlots) == getOccupiedSlotsCount());
    }
}
