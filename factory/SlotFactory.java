package factory;

import enums.SlotType;
import model.slot.*;

public class SlotFactory {

    public static ParkingSlot createSlot(SlotType type, int id) {

        switch (type) {
            case SMALL: return new SmallSlot(id);
            case MEDIUM: return new MediumSlot(id);
            case LARGE: return new LargeSlot(id);
        }
        return null;
    }
}