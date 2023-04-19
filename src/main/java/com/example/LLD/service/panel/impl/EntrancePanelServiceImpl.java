package com.example.LLD.service.panel.impl;

import com.example.LLD.entity.dto.parking.ParkingTicketRequestDTO;
import com.example.LLD.entity.panel.EntrancePanel;
import com.example.LLD.entity.parking.ParkingTicket;
import com.example.LLD.entity.parking.slot.impl.ParkingSlot;
import com.example.LLD.entity.vehicle.impl.Vehicle;
import com.example.LLD.exception.parking.InvalidParkingTicketException;
import com.example.LLD.exception.parking.ParkingSlotFullException;
import com.example.LLD.exception.vehicle.InvalidVehicleException;
import com.example.LLD.service.panel.intf.EntrancePanelService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class EntrancePanelServiceImpl implements EntrancePanelService {
    @Autowired
    private EntrancePanel entrancePanel;

    @Override
    public ParkingSlot findParkingSlot(Vehicle vehicle, boolean isHandicapped) throws InvalidVehicleException, ParkingSlotFullException {
        return entrancePanel.findParkingSlot(vehicle, isHandicapped);
    }

    @Override
    public ParkingTicket generateParkingTicket(ParkingTicketRequestDTO parkingTicketRequestDTO)
            throws ParkingSlotFullException, InvalidVehicleException {
        return entrancePanel.generateParkingTicket(parkingTicketRequestDTO);
    }

    @Override
    public void printTicket(long id) throws InvalidParkingTicketException {
        entrancePanel.printTicket(id);
    }
}
