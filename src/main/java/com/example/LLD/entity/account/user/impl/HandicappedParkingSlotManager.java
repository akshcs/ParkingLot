package com.example.LLD.entity.account.user.impl;

import com.example.LLD.entity.account.user.ParkingSlotManager;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Data
@Builder
@NoArgsConstructor
@Component
@Qualifier("HandicappedParkingSlotManager")
public class HandicappedParkingSlotManager extends ParkingSlotManager {
}
