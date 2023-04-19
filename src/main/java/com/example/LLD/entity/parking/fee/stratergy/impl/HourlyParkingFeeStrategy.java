package com.example.LLD.entity.parking.fee.stratergy.impl;

import com.example.LLD.entity.parking.ParkingTicket;
import com.example.LLD.entity.parking.fee.stratergy.intf.ParkingFeeStrategy;
import com.example.LLD.entity.parking.slot.impl.ParkingSlot;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

import java.time.temporal.ChronoUnit;

@Component
@Qualifier("HourlyParkingFeeStrategy")
public class HourlyParkingFeeStrategy implements ParkingFeeStrategy {
    @Override
    public double getParkingFee(ParkingTicket parkingTicket){
        double totalTime = ChronoUnit.HOURS.between(parkingTicket.getIssueTime(), parkingTicket.getPayTime());
        return parkingFeeCalculator(parkingTicket.getParkingSlot(), totalTime);
    }

    private double parkingFeeCalculator(ParkingSlot parkingSlot, double totalTime){
        double fee = parkingSlot.getFirstHourCharge();
        totalTime--;
        fee+=(((int)(Math.ceil(totalTime))) * parkingSlot.getPerHourCharge());
        return fee;
    }
}
