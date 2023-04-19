package com.example.LLD.validation;

import com.example.LLD.entity.account.user.ParkingTicketManager;
import com.example.LLD.entity.parking.ParkingTicket;
import com.example.LLD.entity.parking.slot.impl.ParkingSlot;
import com.example.LLD.exception.parking.InvalidParkingTicketException;
import com.example.LLD.exception.parking.ParkingSlotFullException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Objects;

@Component
public class ParkingValidation {

    @Autowired
    private ParkingTicketManager parkingTicketManager;

    public boolean validateParkingSlot(ParkingSlot parkingSlot) throws ParkingSlotFullException {
        if(Objects.isNull(parkingSlot)){
            throw new ParkingSlotFullException();
        }
        return true;
    }

    public ParkingTicket validateAndGetParkingTicket(long id) throws InvalidParkingTicketException {
        ParkingTicket parkingTicket = parkingTicketManager.getParkingTicketById(id);
        if(Objects.isNull(parkingTicket)){
            throw new InvalidParkingTicketException(parkingTicket);
        }
        return parkingTicket;
    }
}
