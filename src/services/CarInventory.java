package services;

import java.util.ArrayList;
import java.util.List;
import models.Car;
import models.GasCar;
import models.Transmission;

/**
 * Sistemde bulunan tüm araçların yönetildiği sınıftır.
 * Araç ekleme, çıkarma ve filtreleme işlemlerini yapar.
 */

public class CarInventory {

    private List<Car> cars;
    
    /**
     * CarInventory nesnesi oluşturur.
     */

    public CarInventory() {
        this.cars = new ArrayList<>();
    }
    
    /**
     * Envantere araç ekler.
     */

    public void addCar(Car car) {
        cars.add(car);
    }
    
    /**
     * Araç kimliğine göre araç siler.
     */

    public void removeCar(String carId) {
        cars.removeIf(car -> car.getId().equals(carId));
    }
    
    /**
     * Müsait araçları listeler.
     */

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
    
    /**
     * Araç türüne göre listeler.
     */
    
    public List<Car> listAvailableCarsByType(Class<? extends Car> type) {
        List<Car> result = new ArrayList<>();
        for (Car car : cars) {
            if (car.isAvailable() && type.isInstance(car)) {
                result.add(car);
            }
        }
        return result;
    }
    
    /**
     * Gazlı araçları vites türüne göre listeler.
     */
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
