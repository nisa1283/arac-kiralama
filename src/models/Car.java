package models;

import interfaces.Rentable;

/**
 * Tüm araç tipleri için ortak özellikleri içeren soyut sınıftır.
 */ 

public abstract class Car extends Vehicle implements Rentable {

    protected boolean available = true;

    public Car(String id, String brand, String model, int year, double dailyPrice) {
        super(id, brand, model,year, dailyPrice);
    }
    
    /**
     * Aracın müsait olup olmadığını döner.
     *
     * @return true ise araç müsaittir
     */

    public boolean isAvailable() {
        return available;
    }
    
    /**
     * Aracı kiralanmış olarak işaretler.
     */

    @Override
    public void rent() {
        if (available) {
            available = false;
        } else {
            System.out.println("Araç zaten kiralanmış.");
        }
    }
    
    /**
     * Aracı iade edilmiş olarak işaretler.
     */

    @Override
    public void returnVehicle() {
        available = true;
    }
    
    /**
     * Kiralama ücretini hesaplar.
     *
     * @param days Gün sayısı
     * @return Toplam ücret
     */

    public abstract double calculateRentalFee(int days);

    @Override
    public String toString() {
        return brand + " " + model + " - ID: " + id + " | Model: " + year;
    }
}
