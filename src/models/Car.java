package models;

public abstract class Car {
	    private String id;
	    private String brand;
	    private String model;
	    private int year;
	    private boolean available = true; // araç başlangıçta müsait

	    public Car(String id, String brand, String model, int year) {
	        this.id = id;
	        this.brand = brand;
	        this.model = model;
	        this.year = year;
	    }

	    // Getter & Setter (Encapsulation)

	    public String getId() {
	        return id;
	    }

	    public String getBrand() {
	        return brand;
	    }

	    public String getModel() {
	        return model;
	    }

	    public int getYear() {
	        return year;
	    }

	    public boolean isAvailable() {
	        return available;
	    }

	    public void setAvailable(boolean available) {
	        this.available = available;
	    }

	    // Polimorfik metod
	    public abstract double calculateRentalFee(int days);

	    @Override
	    public String toString() {
	        return brand + " " + model + " (" + year + ") - ID: " + id;
	    }


}
