package model.ticket;

import model.slot.ParkingSlot;
import model.vehicle.Vehicle;

public class ParkingTicket {

    public String ticketId;
    public Vehicle vehicle;
    public ParkingSlot slot;
    public long entryTime;
    public int entryGateId;

    public ParkingTicket(String id, Vehicle v, ParkingSlot s, long time, int gateId) {
        this.ticketId = id;
        this.vehicle = v;
        this.slot = s;
        this.entryTime = time;
        this.entryGateId = gateId;
    }
}