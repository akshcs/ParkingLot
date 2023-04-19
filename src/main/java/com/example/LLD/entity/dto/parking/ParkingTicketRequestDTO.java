package com.example.LLD.entity.dto.parking;

import com.example.LLD.entity.vehicle.enums.VehicleType;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ParkingTicketRequestDTO {
    private long licenseNumber;
    private VehicleType vehicleType;
    private boolean isHandicapped = false;
    private boolean isParkingFeeStrategyMinute = false;
}
