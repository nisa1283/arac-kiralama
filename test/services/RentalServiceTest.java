package services;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import models.Car;
import models.ElectricCar;

public class RentalServiceTest {

    private RentalService rentalService;
    private Car testCar;

    @BeforeEach
    void setUp() {
        rentalService = new RentalService();
        testCar = new ElectricCar("E1", "Tesla", "Model 3", 2022, 75);
    }

    @Test
    void testRentCar() {
        rentalService.rentCar(testCar);
        assertFalse(testCar.isAvailable());
    }

    @Test
    void testReturnCar() {
        rentalService.rentCar(testCar);
        rentalService.returnCar(testCar);
        assertTrue(testCar.isAvailable());
    }
}
