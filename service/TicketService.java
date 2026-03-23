package service;

import model.slot.ParkingSlot;
import model.ticket.ParkingTicket;
import model.vehicle.Vehicle;

import java.util.UUID;

public class TicketService {

    public ParkingTicket createTicket(Vehicle v, ParkingSlot slot, long time, int gateId) {
        return new ParkingTicket(
                UUID.randomUUID().toString(),
                v,
                slot,
                time,
                gateId
        );
    }
}