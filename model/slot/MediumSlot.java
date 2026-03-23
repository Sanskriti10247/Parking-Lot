package model.slot;

import enums.SlotType;
import enums.VehicleType;
import model.vehicle.Vehicle;

public class MediumSlot extends ParkingSlot {

    public MediumSlot(int id) {
        super(id, SlotType.MEDIUM);
    }

    public boolean canFitVehicle(Vehicle v) {
        return v.getType() == VehicleType.BIKE ||
               v.getType() == VehicleType.CAR;
    }
}