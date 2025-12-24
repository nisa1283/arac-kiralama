package models;

import java.time.LocalDate;

public class RentalRecord {

    private Car car;
    private String customerName;
    private int rentalDays;
    private LocalDate rentalDate;

    public RentalRecord(Car car, String customerName, int rentalDays) {
        this.car = car;
        this.customerName = customerName;
        this.rentalDays = rentalDays;
        this.rentalDate = LocalDate.now();
    }

    public Car getCar() {
        return car;
    }

    public String getCustomerName() {
        return customerName;
    }

    public int getRentalDays() {
        return rentalDays;
    }

    public LocalDate getRentalDate() {
        return rentalDate;
    }

	public String getTotalFee() {
		// TODO Auto-generated method stub
		return null;
	}
}
