package model.vehicle;

import enums.VehicleType;

public class Bus extends Vehicle {
    public Bus(String number) {
        super(number, VehicleType.BUS);
    }
}