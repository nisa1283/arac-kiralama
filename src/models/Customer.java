package models;
/**
 * Sistemi kullanan müşterileri temsil eden sınıftır.
 * Bir müşteri, araç kiralama işlemleri sırasında
 * kiralama kaydı (RentalRecord) ile ilişkilendirilir.
 */
public class Customer {

    private String name;
    private String phone;

    /**
     * Customer nesnesi oluşturur.
     *
     * @param name müşterinin adı
     * @param phone müşterinin telefon numarası
     */
    public Customer(String name, String phone) {
        this.name = name;
        this.phone = phone;
    }

    /**
     * Müşteri adını döner.
     *
     * @return müşteri adı
     */
    public String getName() {
        return name;
    }

    /**
     * Müşteri telefon numarasını döner.
     *
     * @return telefon numarası
     */
    public String getPhone() {
        return phone;
    }

    /**
     * Müşteri bilgisini yazı formatında döner.
     *
     * @return müşteri bilgisi
     */
    @Override
    public String toString() {
        return name + " (" + phone + ")";
    }
}
