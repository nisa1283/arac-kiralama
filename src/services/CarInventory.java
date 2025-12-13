package services;

import java.util.ArrayList;
import java.util.List;
import models.Car;

public class CarInventory {

    private List<Car> cars = new ArrayList<>();

    public void addCar(Car car) {
        cars.add(car);
    }

    public List<Car> listAvailableCars() {
        List<Car> availableCars = new ArrayList<>();
        for (Car car : cars) {
            if (car.isAvailable()) {
                availableCars.add(car);
            }
        }
        return availableCars;
    }
}
