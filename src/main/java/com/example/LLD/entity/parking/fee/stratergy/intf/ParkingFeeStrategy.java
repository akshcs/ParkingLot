package com.example.LLD.entity.parking.fee.stratergy.intf;

import com.example.LLD.entity.parking.ParkingTicket;

public interface ParkingFeeStrategy {
    double getParkingFee(ParkingTicket parkingTicket);
}
