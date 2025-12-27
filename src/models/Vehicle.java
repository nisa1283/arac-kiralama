package models;

public abstract class Vehicle {

    protected String id;
    protected String brand;
    protected String model;
    protected double dailyPrice;

    public Vehicle(String id, String brand, String model, double dailyPrice) {
        this.id = id;
        this.brand = brand;
        this.model = model;
        this.dailyPrice = dailyPrice;
    }

    public String getId() {
        return id;
    }

    public String getBrand() {
        return brand;
    }

    public String getModel() {
        return model;
    }

    public double getDailyPrice() {
        return dailyPrice;
    }

    public double calculatePrice(int days) {
        return dailyPrice * days;
    }
}
