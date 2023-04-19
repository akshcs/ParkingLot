package com.example.LLD.entity.account.user.factory;

import com.example.LLD.entity.account.user.ParkingSlotManager;
import com.example.LLD.entity.parking.enums.ParkingSlotType;
import com.example.LLD.entity.vehicle.impl.Vehicle;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Component
public class ParkingSlotManagerFactory {
    @Autowired
    @Qualifier("CompactParkingSlotManager")
    private ParkingSlotManager compactParkingSlotManager;
    @Autowired
    @Qualifier("ElectricVehicleParkingSlotManager")
    private ParkingSlotManager electricVehicleParkingSlotManager;
    @Autowired
    @Qualifier("LongVehicleParkingSlotManager")
    private ParkingSlotManager longVehicleParkingSlotManager;
    @Autowired
    @Qualifier("MotorBikeParkingSlotManager")
    private ParkingSlotManager motorBikeParkingSlotManager;
    @Autowired
    @Qualifier("HandicappedParkingSlotManager")
    private ParkingSlotManager handicappedParkingSlotManager;

    public ParkingSlotManager getParkingSlotManager(ParkingSlotType parkingSlotType){
        switch(parkingSlotType){
            case COMPACT_SLOT:
                return compactParkingSlotManager;
            case ELECTRIC_SLOT:
                return electricVehicleParkingSlotManager;
            case LARGE_SLOT:
                return longVehicleParkingSlotManager;
            case MOTORBIKE_SLOT:
                return motorBikeParkingSlotManager;
            case HANDICAPPED_SLOT:
                return handicappedParkingSlotManager;
            default:
                return null;
        }
    }
}
