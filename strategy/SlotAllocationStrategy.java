package strategy;

import enums.SlotType;
import model.slot.ParkingSlot;
import model.vehicle.Vehicle;

import java.util.List;

public interface SlotAllocationStrategy {
    ParkingSlot allocateSlot(Vehicle v, int gateId, List<ParkingSlot> slots, SlotType requestedType);
}