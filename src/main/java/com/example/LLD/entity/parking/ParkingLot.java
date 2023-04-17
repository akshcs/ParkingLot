package com.example.LLD.entity.parking;

import com.example.LLD.entity.panel.impl.EntrancePanel;
import com.example.LLD.entity.panel.impl.ExitPanel;
import com.example.LLD.entity.vehicle.intf.Vehicle;
import com.example.LLD.entity.vehicle.enums.VehicleType;
import com.example.LLD.factory.VehicleFactory;
import org.apache.commons.math3.util.Pair;

import java.util.*;

public class ParkingLot {

    private final String parkingLotId;
    private String address;
    private SortedMap<Integer, ParkingFloor> parkingFloors;
    private Map<Integer, EntrancePanel> entrancePanels;
    private Map<Integer, ExitPanel> exitPanels;

    public ParkingLot(String address){
        this.parkingLotId = UUID.randomUUID().toString();
        this.address = address;
        parkingFloors = new TreeMap<>();
        entrancePanels = new HashMap<>();
        exitPanels = new HashMap<>();
    }

    public boolean addParkingFloor(ParkingFloor parkingFloor) {
        if(!parkingFloors.containsKey(parkingFloor.getFloorNumber())) {
            parkingFloors.put(parkingFloor.getFloorNumber(), parkingFloor);
            return true;
        }
        return false;
    }

    public boolean removeParkingFloor(int parkingFloorNumber) {
        if(parkingFloors.containsKey(parkingFloorNumber)) {
            parkingFloors.remove(parkingFloorNumber);
            return true;
        }
        return false;
    }
    public Map<Integer, ParkingFloor> getParkingFloors() {
        return parkingFloors;
    }

    public boolean addEntrancePanels(EntrancePanel entrancePanel) {
        if(!entrancePanels.containsKey(entrancePanel.getPanelNumber())) {
            entrancePanels.put(entrancePanel.getPanelNumber(), entrancePanel);
            return true;
        }
        return false;
    }

    public boolean removeEntrancePanels(int entrancePanelNumber) {
        if(entrancePanels.containsKey(entrancePanelNumber)) {
            entrancePanels.remove(entrancePanelNumber);
            return true;
        }
        return false;
    }

    public Map<Integer, EntrancePanel> getEntrancePanels() {
        return entrancePanels;
    }

    public boolean addExitPanels(ExitPanel exitPanel) {
        if(!exitPanels.containsKey(exitPanel.getPanelNumber())) {
            exitPanels.put(exitPanel.getPanelNumber(), exitPanel);
            return true;
        }
        return false;
    }

    public boolean removeExitPanels(int exitPanelNumber) {
        if(exitPanels.containsKey(exitPanelNumber)) {
            exitPanels.remove(exitPanelNumber);
            return true;
        }
        return false;
    }

    public Map<Integer, ExitPanel> getExitPanels() {
        return exitPanels;
    }

    public ParkingTicket getParkingTicket(long licenseNumber, VehicleType vehicleType){
        Vehicle vehicle = VehicleFactory.getVehicle(licenseNumber, vehicleType);
        Pair<ParkingFloor, ParkingSlot> parkingSlotInfo = getParkingSlot(vehicle);
        if(Objects.nonNull(parkingSlotInfo)){
            ParkingTicket parkingTicket = new ParkingTicket(vehicle, parkingSlotInfo.getSecond(), parkingSlotInfo.getFirst());
            vehicle.setParkingTicket(parkingTicket);
            return parkingTicket;
        }
        return null;
    }

    private Pair<ParkingFloor, ParkingSlot> getParkingSlot(Vehicle vehicle){
        for(Map.Entry<Integer, ParkingFloor> entry: parkingFloors.entrySet()){
            ParkingSlot parkingSlot = entry.getValue().addVehicle(vehicle);
            if(Objects.nonNull(parkingSlot)){
                return (Pair<ParkingFloor, ParkingSlot>) Collections.singletonMap(entry.getValue(), parkingSlot);
            }
        }
        return null;
    }

    public boolean isFull(){
        for(Map.Entry<Integer, ParkingFloor> entry: parkingFloors.entrySet()){
            if(!entry.getValue().isFull()){
                return false;
            }
        }
        return true;
    }
}
