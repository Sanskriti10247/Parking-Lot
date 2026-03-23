package strategy;

import enums.SlotType;
import model.slot.ParkingSlot;
import model.vehicle.Vehicle;

import java.util.Comparator;
import java.util.List;

public class NearestSlotStrategy implements SlotAllocationStrategy {

    public ParkingSlot allocateSlot(Vehicle v, int gateId, List<ParkingSlot> slots, SlotType requestedType) {

        return slots.stream()
                .filter(s -> s.isAvailable())
                .filter(s -> s.canFitVehicle(v))
                .filter(s -> requestedType == null || s.getType().ordinal() >= requestedType.ordinal())
                .min(Comparator.comparingInt(s -> s.getDistance(gateId)))
                .orElse(null);
    }
}