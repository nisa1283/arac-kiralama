package models;

import interfaces.Rentable;

public abstract class Car extends Vehicle implements Rentable {

    protected boolean available = true;

    public Car(String brand, String model, double dailyPrice) {
        super(brand, model, dailyPrice);
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

    // Her araç türü kendi ücret hesabını yapacak
    public abstract double calculateRentalFee(int days);

    @Override
    public String toString() {
        return brand + " " + model + " - Günlük: " + dailyPrice + " TL";
    }
}
