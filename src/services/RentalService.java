package services;

import java.util.ArrayList;
import java.util.List;

import models.Car;
import models.RentalRecord;

public class RentalService {

    private List<RentalRecord> rentalHistory = new ArrayList<>();

    public void rentCar(Car car) {
        if (car.isAvailable()) {
            car.rent();
        } else {
            System.out.println("Araç müsait değil.");
        }
    }

    public void rentCar(Car car, String customerName, int days) {
        if (car.isAvailable()) {
            car.rent();
            rentalHistory.add(new RentalRecord(car, customerName, days));
        } else {
            System.out.println("Araç müsait değil.");
        }
    }

    public void returnCar(Car car) {
        car.returnVehicle();
    }

    public List<RentalRecord> getRentalHistory() {
        return rentalHistory;
    }
}
