package com.example.LLD.entity.account.user;

import com.example.LLD.entity.parking.slot.impl.ParkingSlot;
import com.example.LLD.entity.parking.startegy.intf.ParkingStrategy;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;

import java.util.ArrayList;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public abstract class ParkingSlotManager {
    @Autowired
    @Qualifier("DefaultParkingStrategy")
    private ParkingStrategy defaultParkingStrategy;
    private List<ParkingSlot> parkingSlots = new ArrayList<>();
    private ParkingStrategy parkingStrategy = defaultParkingStrategy;
    public void addParkingSlot(ParkingSlot parkingSlot){
        parkingSlots.add(parkingSlot);
    }
    public void removeParkingSlot(ParkingSlot parkingSlot){
        parkingSlots.remove(parkingSlot);
    }

    public boolean isParkingSlotPresent(ParkingSlot parkingSlot){
        return parkingSlots.stream().anyMatch(slot -> slot.getParkingSlotId() == parkingSlot.getParkingSlotId());
    }
    public ParkingSlot findParkingSlot(){
        parkingStrategy = defaultParkingStrategy;
        return parkingStrategy.findParkingSlot(parkingSlots);
    }
}
