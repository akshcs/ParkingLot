package com.example.LLD.service;

import com.example.LLD.entity.parking.ParkingTicket;
import com.example.LLD.entity.vehicle.intf.Vehicle;

import java.time.temporal.ChronoUnit;

public class ParkingFeeCalculatorService {
    public double getParkingFee(ParkingTicket parkingTicket){
        double totalTime = ChronoUnit.HOURS.between(parkingTicket.getIssueTime(), parkingTicket.getPayTime());
        return parkingFeeCalculator(parkingTicket.getVehicle(), totalTime);
    }

    private double parkingFeeCalculator(Vehicle vehicle, double totalTime){
        double fee = vehicle.getFirstHourFee();
        totalTime--;
        int hour = 2;
        while(totalTime > 0 && hour<=3){
            totalTime--;
            fee+= vehicle.getSecondAndThirdHourFee();
            hour++;
        }
        fee+=(((int)(Math.ceil(totalTime))) * vehicle.getAdditionalHourFee());
        return fee;
    }
}
