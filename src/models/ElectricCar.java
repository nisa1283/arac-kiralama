package models;

public class ElectricCar extends Car {


    public ElectricCar(String id, String brand, String model, int year,double dailyPrice) {
        super(id, brand, model, year,dailyPrice);
    }

    @Override
    public double calculateRentalFee(int days) {
        return days * 250;
    }

	
}
