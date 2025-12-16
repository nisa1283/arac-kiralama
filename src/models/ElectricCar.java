package models;

public class ElectricCar extends Car {

    private int batteryCapacity; // kWh

    public ElectricCar(String id, String brand, String model, int year, int batteryCapacity) {
        super(id, brand, model, year);
        this.batteryCapacity = batteryCapacity;
    }

    public int getBatteryCapacity() {
        return batteryCapacity;
    }

    public void setBatteryCapacity(int batteryCapacity) {
        this.batteryCapacity = batteryCapacity;
    }

    @Override
    public double calculateRentalFee(int days) {
        return days * 250;
    }

	
}
