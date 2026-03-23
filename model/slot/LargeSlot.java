package model.slot;

import enums.SlotType;
import model.vehicle.Vehicle;

public class LargeSlot extends ParkingSlot {

    public LargeSlot(int id) {
        super(id, SlotType.LARGE);
    }

    public boolean canFitVehicle(Vehicle v) {
        return true;
    }
}