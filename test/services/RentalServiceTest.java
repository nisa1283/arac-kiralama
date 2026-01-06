package services;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import models.*;

public class RentalServiceTest {

    private RentalService rentalService;
    private Car testCar;
    private Customer customer;

    @BeforeEach
    void setUp() {
        rentalService = new RentalService();
        testCar = new ElectricCar("E1", "Tesla", "Model 3", 2022, 100);
        customer = new Customer("Test User", "5551234567");
    }

    @Test
    void testRentCarChangesAvailability() {
        rentalService.rentCar(testCar, customer, 3, null);
        assertFalse(testCar.isAvailable(), "Araç kiralandıktan sonra müsait olmamalı");
    }

    @Test
    void testRentalHistoryIsUpdated() {
        rentalService.rentCar(testCar, customer, 2, null);

        assertEquals(1, rentalService.getRentalHistory().size());
        RentalRecord record = rentalService.getRentalHistory().get(0);

        assertEquals(testCar, record.getCar());
        assertEquals(customer, record.getCustomer());
        assertEquals(2, record.getDays());
        assertFalse(record.isReturned());
    }

    @Test
    void testReturnCarUpdatesRecord() {
        rentalService.rentCar(testCar, customer, 1, null);
        rentalService.returnCar(testCar);

        RentalRecord record = rentalService.getRentalHistory().get(0);
        assertTrue(record.isReturned(), "Araç iade edildi olarak işaretlenmeli");
        assertTrue(testCar.isAvailable(), "Araç iade edilince müsait olmalı");
    }

    @Test
    void testRentCarWithPayment() {
        Payment payment = new Payment(300, PaymentMethod.CASH);
        rentalService.rentCar(testCar, customer, 3, payment);

        RentalRecord record = rentalService.getRentalHistory().get(0);
        assertNotNull(record);
        assertEquals(300, record.getTotalFee());
    }
}
