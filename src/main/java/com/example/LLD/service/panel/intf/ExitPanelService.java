package com.example.LLD.service.panel.intf;

import com.example.LLD.entity.parking.ParkingTicket;
import com.example.LLD.exception.parking.InvalidParkingTicketException;

public interface ExitPanelService {
    public ParkingTicket scanTicket(long id) throws InvalidParkingTicketException;
    public ParkingTicket takePayment(long id) throws InvalidParkingTicketException;
}
