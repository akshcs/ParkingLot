package com.example.LLD.entity.account.user;

import com.example.LLD.entity.parking.ParkingTicket;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Data
@Component
public class ParkingTicketManager {
    private List<ParkingTicket> parkingTickets = new ArrayList<>();

    public void addParkingTicket(ParkingTicket parkingTicket){
        parkingTickets.add(parkingTicket);
    }

    public ParkingTicket getParkingTicketById(long id){
        return parkingTickets.stream().filter(entry-> entry.getTicketId() == id).findFirst().get();
    }
}
