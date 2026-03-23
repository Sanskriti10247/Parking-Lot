package model.floor;

import model.slot.ParkingSlot;
import java.util.List;

public class Floor {
    private int floorId;
    private List<ParkingSlot> slots;

    public Floor(int id, List<ParkingSlot> slots) {
        this.floorId = id;
        this.slots = slots;
    }

    public int getFloorId() {
        return floorId;
    }

    public List<ParkingSlot> getSlots() {
        return slots;
    }
}