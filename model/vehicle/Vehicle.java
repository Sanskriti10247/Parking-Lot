package model.vehicle;

import enums.VehicleType;

public abstract class Vehicle {
    protected String number;
    protected VehicleType type;

    public Vehicle(String number, VehicleType type) {
        this.number = number;
        this.type = type;
    }

    public VehicleType getType() {
        return type;
    }

    public String getNumber() {
        return number;
    }
}