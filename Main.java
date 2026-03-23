import enums.*;
import factory.SlotFactory;
import model.slot.*;
import model.vehicle.*;
import service.*;
import strategy.*;

import java.util.*;

public class Main {

    public static void main(String[] args) {

        List<ParkingSlot> slots = new ArrayList<>();

        for (int i = 1; i <= 5; i++) {
            ParkingSlot s = SlotFactory.createSlot(SlotType.SMALL, i);
            s.setDistance(1, i);
            slots.add(s);
        }

        for (int i = 6; i <= 10; i++) {
            ParkingSlot s = SlotFactory.createSlot(SlotType.MEDIUM, i);
            s.setDistance(1, i);
            slots.add(s);
        }

        for (int i = 11; i <= 15; i++) {
            ParkingSlot s = SlotFactory.createSlot(SlotType.LARGE, i);
            s.setDistance(1, i);
            slots.add(s);
        }

        SlotManager manager = new SlotManager(slots, new NearestSlotStrategy());
        BillingService billing = new BillingService();
        TicketService ticketService = new TicketService();

        ParkingLot lot = ParkingLot.getInstance(manager, billing, ticketService);

        Vehicle bike = new Bike("KA01-1234");

        var ticket = lot.park(bike, System.currentTimeMillis(), null, 1);

        System.out.println("Ticket Generated: " + ticket.ticketId);

        double bill = lot.exit(ticket, System.currentTimeMillis() + 7200000);

        System.out.println("Bill: " + bill);

        System.out.println("Status: " + lot.status());
    }
}