package service;

import enums.SlotType;
import model.slot.ParkingSlot;
import model.vehicle.Vehicle;
import strategy.SlotAllocationStrategy;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class SlotManager {

    private List<ParkingSlot> slots;
    private SlotAllocationStrategy strategy;

    public SlotManager(List<ParkingSlot> slots, SlotAllocationStrategy strategy) {
        this.slots = slots;
        this.strategy = strategy;
    }

    public ParkingSlot findSlot(Vehicle v, int gateId, SlotType requested) {
        return strategy.allocateSlot(v, gateId, slots, requested);
    }

    public Map<SlotType, Long> getAvailability() {
        return slots.stream()
                .filter(ParkingSlot::isAvailable)
                .collect(Collectors.groupingBy(
                        ParkingSlot::getType,
                        Collectors.counting()
                ));
    }
}