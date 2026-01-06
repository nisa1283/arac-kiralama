package services;

import java.util.ArrayList;
import java.util.List;

import models.Car;
import models.Customer;
import models.Payment;
import models.RentalRecord;

/**
 * Araç kiralama ve iade işlemlerini yöneten servis sınıfıdır.
 * Kiralama geçmişini RentalRecord nesneleri ile tutar.
 */

public class RentalService {
	/**
     * Belirtilen aracı, müşteri adına ve verilen gün sayısı boyunca kiralar.
     *
     * @param car Kiralanacak araç
     * @param customer Kiralamayı yapan müşteri
     * @param days Kiralama süresi (gün)
     * @param payment Ödeme bilgisi
     */

    private List<RentalRecord> rentalHistory = new ArrayList<>();

    public void rentCar(Car car, Customer customer, int days) {
        rentCar(car, customer, days, null);
    }

    public void rentCar(Car car, Customer customer, int days, Payment payment) {

        if (car == null || customer == null) {
            System.out.println("Geçersiz kiralama bilgisi.");
            return;
        }

        if (!car.isAvailable()) {
            System.out.println("Araç müsait değil.");
            return;
        }

        car.rent();

        RentalRecord record = new RentalRecord(car, customer, days, payment);
        rentalHistory.add(record);

        System.out.println("Araç başarıyla kiralandı:");
        System.out.println(record);
    }
    /**
     * Belirtilen aracın iade edilmesini sağlar.
     *
     * @param car İade edilecek araç
     */

    public void returnCar(Car car) {

        if (car == null) {
            System.out.println("Araç bulunamadı.");
            return;
        }

        car.returnVehicle();

        for (RentalRecord record : rentalHistory) {
            if (record.getCar().equals(car) && !record.isReturned()) {
                record.setReturned(true);
                break;
            }
        }

        System.out.println("Araç iade edildi: " + car);
    }
    /**
     * Tüm kiralama geçmişini döner.
     *
     * @return Kiralama kayıtları listesi
     */

    public List<RentalRecord> getRentalHistory() {
        return rentalHistory;
    }
}
