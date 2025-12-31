package services;

import java.util.ArrayList;
import java.util.List;
import models.Car;
import models.GasCar;
import models.Transmission;


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
    public List<Car> listAvailableCarsByType(Class<? extends Car> type) {
        List<Car> result = new ArrayList<>();
        for (Car car : cars) {
            if (car.isAvailable() && type.isInstance(car)) {
                result.add(car);
            }
        }
        return result;
    }
    public List<GasCar> listAvailableGasCarsByTransmission(Transmission transmission) {
        List<GasCar> result = new ArrayList<>();

        for (Car car : cars) {
            if (car.isAvailable() && car instanceof GasCar) {
                GasCar gasCar = (GasCar) car;
                if (gasCar.getTransmission() == transmission) {
                    result.add(gasCar);
                }
            }
        }
        return result;
    }


}
