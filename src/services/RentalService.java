package services;

import models.Car;

public class RentalService {

    public void rentCar(Car car) {
        if (car.isAvailable()) {
            car.rent();
            System.out.println("Araç kiralandı: " + car);
        } else {
            System.out.println("Araç zaten kiralanmış: " + car);
        }
    }

    public void returnCar(Car car) {
        car.returnVehicle();
        System.out.println("Araç iade edildi: " + car);
    }
}
