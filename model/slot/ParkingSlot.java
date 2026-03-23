package model.slot;

import enums.SlotType;
import model.vehicle.Vehicle;

import java.util.HashMap;
import java.util.Map;

public abstract class ParkingSlot {

    protected int slotId;
    protected SlotType type;
    protected boolean isOccupied;
    protected Map<Integer, Integer> distanceMap;

    public ParkingSlot(int id, SlotType type) {
        this.slotId = id;
        this.type = type;
        this.isOccupied = false;
        this.distanceMap = new HashMap<>();
    }

    public abstract boolean canFitVehicle(Vehicle v);

    public boolean isAvailable() {
        return !isOccupied;
    }

    public void park() {
        isOccupied = true;
    }

    public void free() {
        isOccupied = false;
    }

    public int getDistance(int gateId) {
        return distanceMap.getOrDefault(gateId, Integer.MAX_VALUE);
    }

    public SlotType getType() {
        return type;
    }

    public int getSlotId() {
        return slotId;
    }

    public void setDistance(int gateId, int distance) {
        distanceMap.put(gateId, distance);
    }
}