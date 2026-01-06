package models;
/**
 * Benzinli / gazlı araçları temsil eden sınıftır.
 * Vites türü (manuel / otomatik) bilgisi içerir.
 */
public class GasCar extends Car {

    private Transmission transmission;

    /**
     * Gazlı araç nesnesi oluşturur.
     *
     * @param id araç kimliği
     * @param brand marka
     * @param model model
     * @param year üretim yılı
     * @param dailyPrice günlük ücret
     * @param transmission vites türü
     */
    public GasCar(String id, String brand, String model,
                  int year, double dailyPrice,
                  Transmission transmission) {
        super(id, brand, model, year, dailyPrice);
        this.transmission = transmission;
    }

    /**
     * Gazlı araç için toplam kiralama ücretini hesaplar.
     *
     * @param days kiralama süresi
     * @return toplam ücret
     */
    @Override
    public double calculateRentalFee(int days) {
        return dailyPrice * days;
    }

    /**
     * Aracın vites türünü döner.
     *
     * @return vites türü
     */
    public Transmission getTransmission() {
        return transmission;
    }
}

