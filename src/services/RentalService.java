package services;

import java.util.ArrayList;
import java.util.List;

import models.Car;
import models.RentalRecord;


public class RentalService {

    private List<RentalRecord> rentalHistory = new ArrayList<>();

    public void rentCar(Car car) {
        if (car.isAvailable()) {
            car.rent();
            System.out.println("Araç kiralandı: " + car);
        } else {
            System.out.println("Araç müsait değil.");
        }
    }


    public void rentCar(Car car, String customerName, int days) {
        if (car.isAvailable()) {
            car.rent();
            RentalRecord record = new RentalRecord(car, customerName, days);
            rentalHistory.add(record);

            System.out.println("Araç kiralandı: " + car);
            System.out.println("Müşteri: " + customerName);
            System.out.println("Süre: " + days + " gün");
            System.out.println("Toplam ücret: " + record.getTotalFee() + " TL");
        } else {
            System.out.println("Araç müsait değil.");
        }
    }

   
    public void returnCar(Car car) {
        car.returnVehicle();
        System.out.println("Araç iade edildi: " + car);
    }

    
    public List<RentalRecord> getRentalHistory() {
        return rentalHistory;
    }
}
