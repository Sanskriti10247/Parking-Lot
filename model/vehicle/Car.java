package model.vehicle;

import enums.VehicleType;

public class Car extends Vehicle {
    public Car(String number) {
        super(number, VehicleType.CAR);
    }
}