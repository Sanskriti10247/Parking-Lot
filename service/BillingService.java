package service;

import enums.SlotType;
import model.ticket.ParkingTicket;

import java.util.Map;

public class BillingService {

    private Map<SlotType, Integer> rates = Map.of(
            SlotType.SMALL, 10,
            SlotType.MEDIUM, 20,
            SlotType.LARGE, 30
    );

    public double calculateBill(ParkingTicket ticket, long exitTime) {

        long duration = exitTime - ticket.entryTime;
        int hours = (int)Math.ceil(duration / 3600000.0);

        return hours * rates.get(ticket.slot.getType());
    }
}