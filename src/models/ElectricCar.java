package models;

/**
 * Elektrikli araçları temsil eden sınıftır.
 * Car sınıfından türetilmiştir ve kiralama ücretini
 * gün sayısına göre hesaplar.
 */

public class ElectricCar extends Car {

	/**
	 * Elektrikli araçları temsil eden sınıftır.
	 * Car sınıfından türetilmiştir ve kiralama ücretini
	 * gün sayısına göre hesaplar.
	 */
	
    public ElectricCar(String id, String brand, String model, int year,double dailyPrice) {
        super(id, brand, model, year,dailyPrice);
    }
    
    /**
     * Elektrikli araç için toplam kiralama ücretini hesaplar.
     *
     * @param days kiralama süresi
     * @return toplam ücret
     */

    @Override
    public double calculateRentalFee(int days) {
    	return dailyPrice * days;
    }

	
}
