package com.example.LLD.rest;

import com.example.LLD.entity.parking.slot.factory.ParkingSlotFactory;
import com.example.LLD.entity.parking.slot.impl.*;
import com.example.LLD.exception.parking.DuplicateParkingSlotException;
import com.example.LLD.exception.parking.InvalidParkingSlotException;
import com.example.LLD.service.user.intf.ParkingSlotManagerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/parkingSlot")
public class ParkingSlotResource {

    @Autowired
    private ParkingSlotManagerService parkingSlotManagerService;

    @PostMapping("/add/car/{id}")
    public ResponseEntity<?> addCarParkingSlot(@PathVariable Long id) {
        return addParkingSlot(ParkingSlotFactory.createCarParkingSlot(id));
    }

    @PostMapping("/add/van/{id}")
    public ResponseEntity<?> addVanParkingSlot(@PathVariable Long id) {
        return addParkingSlot(ParkingSlotFactory.createVanParkingSlot(id));
    }

    @PostMapping("/add/truck/{id}")
    public ResponseEntity<?> addTruckParkingSlot(@PathVariable Long id) {
        return addParkingSlot(ParkingSlotFactory.createTruckParkingSlot(id));
    }

    @PostMapping("/add/ev/{id}")
    public ResponseEntity<?> addEVParkingSlot(@PathVariable Long id) {
        return addParkingSlot(ParkingSlotFactory.createElectricVehicleParkingSlot(id));
    }

    @PostMapping("/add/motorBike/{id}")
    public ResponseEntity<?> addMotorBikeParkingSlot(@PathVariable Long id) {
        return addParkingSlot(ParkingSlotFactory.createMotorBikeParkingSlot(id));
    }

    @DeleteMapping("/remove/car/{id}")
    public ResponseEntity<?> removeCarParkingSlot(@PathVariable Long id) {
        return removeParkingSlot(ParkingSlotFactory.createCarParkingSlot(id));
    }

    @DeleteMapping("/remove/van/{id}")
    public ResponseEntity<?> removeVanParkingSlot(@PathVariable Long id) {
        return removeParkingSlot(ParkingSlotFactory.createVanParkingSlot(id));
    }

    @DeleteMapping("/remove/truck/{id}")
    public ResponseEntity<?> removeTruckParkingSlot(@PathVariable Long id) {
        return removeParkingSlot(ParkingSlotFactory.createTruckParkingSlot(id));
    }

    @DeleteMapping("/remove/ev/{id}")
    public ResponseEntity<?> removeEVParkingSlot(@PathVariable Long id) {
        return removeParkingSlot(ParkingSlotFactory.createElectricVehicleParkingSlot(id));
    }

    @DeleteMapping("/remove/motorBike/{id}")
    public ResponseEntity<?> removeMotorBikeParkingSlot(@PathVariable Long id) {
        return removeParkingSlot(ParkingSlotFactory.createMotorBikeParkingSlot(id));
    }

    private ResponseEntity<?> addParkingSlot(ParkingSlot parkingSlot){
        try {
            parkingSlotManagerService.addParkingSlot(parkingSlot);
            return new ResponseEntity<>(parkingSlot, HttpStatus.CREATED);
        } catch (DuplicateParkingSlotException e){
            return ResponseEntity.status(HttpStatus.CONFLICT).body(e.getMessage());
        }
    }

    private ResponseEntity<?> removeParkingSlot(ParkingSlot parkingSlot){
        try {
            parkingSlotManagerService.removeParkingSlot(parkingSlot);
            return new ResponseEntity<>(parkingSlot, HttpStatus.NO_CONTENT);
        } catch (InvalidParkingSlotException e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(e.getMessage());
        }
    }
}
