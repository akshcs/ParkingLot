package com.example.LLD.entity.parking.fee.stratergy.impl;

import com.example.LLD.entity.parking.ParkingTicket;
import com.example.LLD.entity.parking.fee.stratergy.intf.ParkingFeeStrategy;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

import java.time.temporal.ChronoUnit;

@Component
@Qualifier("MinuteParkingFeeStrategy")
public class MinuteParkingFeeStrategy implements ParkingFeeStrategy {
    @Override
    public double getParkingFee(ParkingTicket parkingTicket) {
        double totalTime = ChronoUnit.MINUTES.between(parkingTicket.getIssueTime(), parkingTicket.getPayTime());
        return totalTime*parkingTicket.getParkingSlot().getPerMinuteCharge();
    }
}
