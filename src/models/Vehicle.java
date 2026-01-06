package models;
/**
 * Sistemdeki tüm araçların ortak özelliklerini tutan
 * soyut (abstract) üst sınıftır.
 */
public abstract class Vehicle {

    protected String id;
    protected String brand;
    protected String model;
    protected int year;
    protected double dailyPrice;

    /**
     * Vehicle nesnesi oluşturur.
     */
    public Vehicle(String id, String brand, String model,
                   int year, double dailyPrice) {
        this.id = id;
        this.brand = brand;
        this.model = model;
        this.year = year;
        this.dailyPrice = dailyPrice;
    }

    /** @return araç kimliği */
    public String getId() {
        return id;
    }

    /** @return marka */
    public String getBrand() {
        return brand;
    }

    /** @return model */
    public String getModel() {
        return model;
    }

    /** @return üretim yılı */
    public int getYear() {
        return year;
    }

    /** @return günlük ücret */
    public double getDailyPrice() {
        return dailyPrice;
    }
}

