package services;

import models.Car;

public class RentalService {

    public void rentCar(Car car) {
        if (car.isAvailable()) {
            car.setAvailable(false);
        }
    }

    public void returnCar(Car car) {
        car.setAvailable(true);
    }
}
