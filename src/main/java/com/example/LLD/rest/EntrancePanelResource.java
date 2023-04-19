package com.example.LLD.rest;

import com.example.LLD.entity.dto.parking.ParkingTicketRequestDTO;
import com.example.LLD.entity.parking.ParkingTicket;
import com.example.LLD.exception.parking.ParkingSlotFullException;
import com.example.LLD.exception.vehicle.InvalidVehicleException;
import com.example.LLD.service.panel.intf.EntrancePanelService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/entrancePanel")
public class EntrancePanelResource {
    @Autowired
    private EntrancePanelService entrancePanelService;

    @PostMapping("/createTicket")
    public ResponseEntity<?> createTicket(@RequestBody ParkingTicketRequestDTO parkingTicketRequestDTO){
        try {
            ParkingTicket parkingTicket = entrancePanelService.generateParkingTicket(parkingTicketRequestDTO);
            return new ResponseEntity<>(parkingTicket, HttpStatus.CREATED);
        } catch ( ParkingSlotFullException e){
            return ResponseEntity.status(HttpStatus.CONFLICT).body(e.getMessage());
        } catch (InvalidVehicleException e){
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(e.getMessage());
        }
    }
}
