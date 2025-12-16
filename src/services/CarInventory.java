package services;

import java.util.ArrayList;
import java.util.List;
import models.Car;

public class CarInventory {

    private List<Car> cars;

    public CarInventory() {
        this.cars = new ArrayList<>();
    }

    public void addCar(Car car) {
        cars.add(car);
    }

    public void removeCar(String carId) {
        cars.removeIf(car -> car.getId().equals(carId));
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

    public List<Car> getAllCars() {
        return cars;
    }
}
