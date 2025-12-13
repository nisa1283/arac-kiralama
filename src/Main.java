import models.*;
import services.*;

public class Main {
    public static void main(String[] args) {

        CarInventory inventory = new CarInventory();
        RentalService rentalService = new RentalService();

        Car car1 = new ElectricCar("E1", "Tesla", "Model 3", 2022, 75);
        Car car2 = new GasCar("G1", "Toyota", "Corolla", 2020, 50);

        inventory.addCar(car1);
        inventory.addCar(car2);

        System.out.println("Müsait araçlar:");
        for (Car car : inventory.listAvailableCars()) {
            System.out.println(car);
        }

        rentalService.rentCar(car1);

        System.out.println("\nKiralama sonrası müsait araçlar:");
        for (Car car : inventory.listAvailableCars()) {
            System.out.println(car);
        }
    }
}
