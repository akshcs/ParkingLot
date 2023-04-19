package com.example.LLD.service.panel.impl;

import com.example.LLD.entity.panel.ExitPanel;
import com.example.LLD.entity.parking.ParkingTicket;
import com.example.LLD.exception.parking.InvalidParkingTicketException;
import com.example.LLD.service.panel.intf.ExitPanelService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ExitPanelServiceImpl implements ExitPanelService {
    @Autowired
    private ExitPanel exitPanel;
    @Override
    public ParkingTicket scanTicket(long id) throws InvalidParkingTicketException {
        return exitPanel.scanTicket(id);
    }

    @Override
    public ParkingTicket takePayment(long id) throws InvalidParkingTicketException {
        return exitPanel.takePayment(id);
    }
}
