package models;

public class GasCar extends Car {

    private double fuelCapacity; // Litre

    public GasCar(String id, String brand, String model, int year, double fuelCapacity) {
        super(id, brand, model, year);
        this.fuelCapacity = fuelCapacity;
    }

    public double getFuelCapacity() {
        return fuelCapacity;
    }

    public void setFuelCapacity(double fuelCapacity) {
        this.fuelCapacity = fuelCapacity;
    }

    @Override
    public double calculateRentalFee(int days) {
        return days * 200;
    }

	
}
