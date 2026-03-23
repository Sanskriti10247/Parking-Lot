package model.slot;

import enums.SlotType;
import enums.VehicleType;
import model.vehicle.Vehicle;

public class SmallSlot extends ParkingSlot {

    public SmallSlot(int id) {
        super(id, SlotType.SMALL);
    }

    public boolean canFitVehicle(Vehicle v) {
        return v.getType() == VehicleType.BIKE;
    }
}