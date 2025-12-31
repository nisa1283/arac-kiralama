package models;

public class GasCar extends Car {


    public GasCar(String id, String brand, String model, int year,double dailyPrice, Transmission transmission) {
        super(id, brand, model, year, dailyPrice);
        this.transmission = transmission;
    }

	@Override
	public double calculateRentalFee(int days) {
		// TODO Auto-generated method stub
		return 0;
	}

    private Transmission transmission;
    
    public Transmission getTransmission() {
        return transmission;
    }


	
}
