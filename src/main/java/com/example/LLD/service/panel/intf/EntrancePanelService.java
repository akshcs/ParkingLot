package com.example.LLD.service.panel.intf;

import com.example.LLD.entity.dto.parking.ParkingTicketRequestDTO;
import com.example.LLD.entity.parking.ParkingTicket;
import com.example.LLD.entity.parking.slot.impl.ParkingSlot;
import com.example.LLD.entity.vehicle.impl.Vehicle;
import com.example.LLD.exception.parking.InvalidParkingTicketException;
import com.example.LLD.exception.parking.ParkingSlotFullException;
import com.example.LLD.exception.vehicle.InvalidVehicleException;

public interface EntrancePanelService {
    ParkingSlot findParkingSlot(Vehicle vehicle, boolean isHandicapped) throws InvalidVehicleException, ParkingSlotFullException;

    ParkingTicket generateParkingTicket(ParkingTicketRequestDTO parkingTicketRequestDTO)
            throws ParkingSlotFullException, InvalidVehicleException;

    public void printTicket(long id) throws InvalidParkingTicketException;
}
