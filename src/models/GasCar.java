package models;

public class GasCar extends Car {


    public GasCar(String id, String brand, String model, int year,double dailyPrice) {
        super(id, brand, model, year, dailyPrice);
    }

    @Override
    public double calculateRentalFee(int days) {
        return days * 200;
    }

	
}
