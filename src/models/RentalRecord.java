package models;

import java.time.LocalDate;

public class RentalRecord {

    private Car car;
    private String customerName;
    private int rentalDays;
    private LocalDate rentalDate;
    private double totalFee;

    public RentalRecord(Car car, String customerName, int rentalDays) {
        this.car = car;
        this.customerName = customerName;
        this.rentalDays = rentalDays;
        this.rentalDate = LocalDate.now();

        this.totalFee = car.calculateRentalFee(rentalDays);
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

    public double getTotalFee() {
        return totalFee;
    }

    @Override
    public String toString() {
        return "Araç: " + car +
               "\nMüşteri: " + customerName +
               "\nKiralama tarihi: " + rentalDate +
               "\nSüre: " + rentalDays + " gün" +
               "\nToplam ücret: " + totalFee + " TL\n";
    }
}
