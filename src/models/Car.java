package models;

import interfaces.Rentable;

public abstract class Car extends Vehicle implements Rentable {

    protected boolean available = true;

    public Car(String id, String brand, String model, double dailyPrice) {
        super(id, brand, model, dailyPrice);
    }

    public boolean isAvailable() {
        return available;
    }

    @Override
    public void rent() {
        if (available) {
            available = false;
        } else {
            System.out.println("Araç zaten kiralanmış.");
        }
    }

    @Override
    public void returnVehicle() {
        available = true;
    }

    public abstract double calculateRentalFee(int days);

    @Override
    public String toString() {
        return brand + " " + model + " - ID: " + id + " | Günlük: " + dailyPrice + " TL";
    }
}
