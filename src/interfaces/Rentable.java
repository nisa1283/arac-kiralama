package interfaces;

/**
 * Kiralanabilir nesneler için tanımlanmış arayüzdür.
 */
public interface Rentable {

    /**
     * Nesneyi kiralar.
     */
    void rent();

    /**
     * Nesneyi iade eder.
     */
    void returnVehicle();
}

