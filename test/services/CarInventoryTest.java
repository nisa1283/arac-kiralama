package services;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import models.Car;
import models.ElectricCar;
import models.GasCar;
import models.Transmission;

import java.util.List;

public class CarInventoryTest {

    private CarInventory inventory;

    @BeforeEach
    void setUp() {
        inventory = new CarInventory();

        Car electricCar = new ElectricCar("E1", "Tesla", "Model 3", 2022, 250);
        Car electricCar2 =new ElectricCar("E2", "BMW", "i4", 2023, 300);
        Car gasCarAuto = new GasCar("G1", "Toyota", "Corolla", 2020, 200, Transmission.AUTOMATIC);
        Car gasCarManual = new GasCar("G2", "Fiat", "Egea", 2021, 180, Transmission.MANUAL);

        inventory.addCar(electricCar);
        inventory.addCar(electricCar2);
        inventory.addCar(gasCarAuto);
        inventory.addCar(gasCarManual);
    }

    @Test
    void testListAvailableCars() {
        List<Car> availableCars = inventory.listAvailableCars();
        assertEquals(4, availableCars.size());
    }

    @Test
    void testListAvailableCarsByType() {
        List<Car> electricCars = inventory.listAvailableCarsByType(ElectricCar.class);
        assertEquals(2, electricCars.size());
    }

    @Test
    void testListAvailableGasCarsByTransmission() {
        List<GasCar> automaticCars =
                inventory.listAvailableGasCarsByTransmission(Transmission.AUTOMATIC);

        assertEquals(1, automaticCars.size());
        assertEquals("G1", automaticCars.get(0).getId());
    }
}
