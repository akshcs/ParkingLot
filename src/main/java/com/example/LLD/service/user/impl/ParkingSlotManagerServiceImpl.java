package com.example.LLD.service.user.impl;

import com.example.LLD.entity.account.user.ParkingSlotManager;
import com.example.LLD.entity.account.user.factory.ParkingSlotManagerFactory;
import com.example.LLD.entity.parking.slot.impl.ParkingSlot;
import com.example.LLD.exception.parking.DuplicateParkingSlotException;
import com.example.LLD.exception.parking.InvalidParkingSlotException;
import com.example.LLD.service.user.intf.ParkingSlotManagerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ParkingSlotManagerServiceImpl implements ParkingSlotManagerService {
    @Autowired
    private ParkingSlotManagerFactory parkingSlotManagerFactory;
    @Override
    public boolean addParkingSlot(ParkingSlot parkingSlot) throws DuplicateParkingSlotException {
        ParkingSlotManager parkingSlotManager = parkingSlotManagerFactory.getParkingSlotManager(parkingSlot.getParkingSlotType());
        if(parkingSlotManager.isParkingSlotPresent(parkingSlot)){
            throw new DuplicateParkingSlotException(parkingSlot);
        }
        parkingSlotManager.addParkingSlot(parkingSlot);
        return true;
    }

    @Override
    public boolean removeParkingSlot(ParkingSlot parkingSlot) throws InvalidParkingSlotException {
        ParkingSlotManager parkingSlotManager = parkingSlotManagerFactory.getParkingSlotManager(parkingSlot.getParkingSlotType());
        if(!parkingSlotManager.isParkingSlotPresent(parkingSlot)){
            throw new InvalidParkingSlotException(parkingSlot);
        }
        parkingSlotManager.removeParkingSlot(parkingSlot);
        return true;
    }
}
