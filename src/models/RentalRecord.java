package models;

import java.time.LocalDate;

/**
 * Bir kiralama işleminin tüm detaylarını tutan sınıftır.
 * Araç, müşteri, süre, ücret, ödeme ve iade durumu bilgilerini içerir.
 */

public class RentalRecord {

    private Car car;
    private Customer customer;
    private int days;
    private LocalDate rentalDate;
    private double totalFee;
    private boolean returned;
    private Payment payment;
    
    /**
     * Yeni bir kiralama kaydı oluşturur.
     *
     * @param car Kiralanan araç
     * @param customer Müşteri bilgisi
     * @param days Kiralama süresi
     * @param payment Ödeme bilgisi
     */
    
    public RentalRecord(Car car, Customer customer, int days, Payment payment) {
        this.car = car;
        this.customer = customer;
        this.days = days;
        this.payment = payment;
        this.rentalDate = LocalDate.now();
        this.totalFee = car.calculateRentalFee(days);
        this.returned = false;
    }

    public Car getCar() {
        return car;
    }

    public Customer getCustomer() {
        return customer;
    }

    public int getDays() {
        return days;
    }

    public LocalDate getRentalDate() {
        return rentalDate;
    }

    public double getTotalFee() {
        return totalFee;
    }

    public boolean isReturned() {
        return returned;
    }

    public void setReturned(boolean returned) {
        this.returned = returned;
    }

    @Override
    public String toString() {
        return
            "Araç: " + car + "\n" +
            "Müşteri: " + customer + "\n" +
            "Kiralama tarihi: " + rentalDate + "\n" +
            "Süre: " + days + " gün\n" +
            "Toplam ücret: " + totalFee + " TL\n" +
            "Durum: " + (returned ? "İade Edildi" : "Devam Ediyor") +
            (payment != null ? "\nÖdeme: " + payment : "");
    }
}
