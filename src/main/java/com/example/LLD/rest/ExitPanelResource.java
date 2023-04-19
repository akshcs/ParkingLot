package com.example.LLD.rest;

import com.example.LLD.entity.dto.parking.ParkingTicketRequestDTO;
import com.example.LLD.entity.parking.ParkingTicket;
import com.example.LLD.exception.parking.InvalidParkingTicketException;
import com.example.LLD.exception.parking.ParkingSlotFullException;
import com.example.LLD.exception.vehicle.InvalidVehicleException;
import com.example.LLD.service.panel.intf.EntrancePanelService;
import com.example.LLD.service.panel.intf.ExitPanelService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/exitPanel")
public class ExitPanelResource {
    @Autowired
    private ExitPanelService exitPanelService;


    @PostMapping("/scanTicket/{id}")
    public ResponseEntity<?> scanAndUpdateTicket(@PathVariable Long id) {
        try {
            ParkingTicket parkingTicket = exitPanelService.scanTicket(id);
            return new ResponseEntity<>(parkingTicket, HttpStatus.ACCEPTED);
        } catch ( InvalidParkingTicketException e){
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(e.getMessage());
        }
    }

    @PostMapping("/takePayment/{id}")
    public ResponseEntity<?> takePayment(@PathVariable Long id) {
        try {
            ParkingTicket parkingTicket = exitPanelService.takePayment(id);
            return new ResponseEntity<>(parkingTicket, HttpStatus.IM_USED);
        } catch ( InvalidParkingTicketException e){
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(e.getMessage());
        }
    }
}
