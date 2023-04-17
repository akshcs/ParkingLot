package com.example.LLD.entity.vehicle.intf;

import com.example.LLD.entity.parking.enums.ParkingSlotType;
import com.example.LLD.entity.parking.ParkingTicket;

public interface Vehicle {
    double getFirstHourFee();

    double getSecondAndThirdHourFee();

    double getAdditionalHourFee();

    ParkingTicket getParkingTicket();

    void setParkingTicket(ParkingTicket parkingTicket);

    ParkingSlotType getParkingSlotType();
}
