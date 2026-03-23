package service;

import enums.SlotType;
import model.slot.ParkingSlot;
import model.ticket.ParkingTicket;
import model.vehicle.Vehicle;

import java.util.Map;

public class ParkingLot {

    private static ParkingLot instance;

    private SlotManager slotManager;
    private BillingService billingService;
    private TicketService ticketService;

    private ParkingLot(SlotManager sm, BillingService bs, TicketService ts) {
        this.slotManager = sm;
        this.billingService = bs;
        this.ticketService = ts;
    }

    public static ParkingLot getInstance(SlotManager sm, BillingService bs, TicketService ts) {
        if (instance == null) {
            instance = new ParkingLot(sm, bs, ts);
        }
        return instance;
    }

    public ParkingTicket park(Vehicle v, long entryTime, SlotType requested, int gateId) {

        ParkingSlot slot = slotManager.findSlot(v, gateId, requested);

        if (slot == null) {
            throw new RuntimeException("No slot available");
        }

        slot.park();

        return ticketService.createTicket(v, slot, entryTime, gateId);
    }

    public double exit(ParkingTicket ticket, long exitTime) {
        ticket.slot.free();
        return billingService.calculateBill(ticket, exitTime);
    }

    public Map<SlotType, Long> status() {
        return slotManager.getAvailability();
    }
}