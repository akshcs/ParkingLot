package com.example.LLD.entity.parking;

import com.example.LLD.entity.parking.enums.ParkingTicketStatus;
import com.example.LLD.entity.vehicle.intf.Vehicle;

import java.time.LocalDateTime;

public class ParkingTicket {
    private LocalDateTime payTime;
    private final long ticketId;
    private double parkingFee;
    private final Vehicle vehicle;
    private final ParkingFloor parkingFloor;
    private final ParkingSlot parkingSlot;
    private ParkingTicketStatus parkingTicketStatus;
    private final LocalDateTime issueTime;
    private long ticketCounter = 1;

    public ParkingTicket(Vehicle vehicle, ParkingSlot parkingSlot, ParkingFloor parkingFloor) {
        this.ticketId = ticketCounter++;
        this.parkingTicketStatus = ParkingTicketStatus.ACTIVE;
        this.issueTime = LocalDateTime.now();
        this.vehicle = vehicle;
        this.parkingSlot = parkingSlot;
        this.parkingFloor = parkingFloor;
        parkingFee = 0.0;
    }

    public long getTicketCounter() {
        return ticketCounter;
    }

    public void setTicketCounter(long ticketCounter) {
        this.ticketCounter = ticketCounter;
    }

    public ParkingTicketStatus getParkingTicketStatus() {
        return parkingTicketStatus;
    }

    public void setParkingTicketStatus(ParkingTicketStatus parkingTicketStatus) {
        this.parkingTicketStatus = parkingTicketStatus;
    }

    public LocalDateTime getIssueTime() {
        return issueTime;
    }

    public LocalDateTime getPayTime() {
        return payTime;
    }

    public void setPayTime(LocalDateTime payTime) {
        this.payTime = payTime;
    }

    public long getTicketId() {
        return ticketId;
    }

    public double getParkingFee() {
        return parkingFee;
    }

    public void setParkingFee(double parkingFee) {
        this.parkingFee = parkingFee;
    }

    public Vehicle getVehicle() {
        return vehicle;
    }

    public ParkingSlot getParkingSlot() {
        return parkingSlot;
    }

    public ParkingFloor getParkingFloor() {
        return parkingFloor;
    }
}
