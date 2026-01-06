package models;

/**
 * Ödeme bilgilerini ve yöntemlerini yöneten sınıftır.
 */

public class Payment {

    private double amount;
    private PaymentMethod method;
    private boolean paid;
    private String iban; // sadece havale için
    private String cardHolder;
    private String cardNumber;
    private String expiryDate;
    private String cvv;

    /**
     * Yeni bir ödeme oluşturur.
     *
     * @param amount Ödenecek tutar
     * @param method Ödeme yöntemi
     */

    public Payment(double amount, PaymentMethod method) {
        this.amount = amount;
        this.method = method;
        this.paid = true;

        if (method == PaymentMethod.BANK_TRANSFER) {
            this.iban = "TR12 0006 1005 1978 6457 8413 26";
        }
    }

    public double getAmount() {
        return amount;
    }

    public PaymentMethod getMethod() {
        return method;
    }

    public boolean isPaid() {
        return paid;
    }

    public String getIban() {
        return iban;
    }
    
    @Override
    public String toString() {
        if (method == PaymentMethod.BANK_TRANSFER) {
            return "Ödeme yöntemi: Havale\nIBAN: " + iban +
                   "\nTutar: " + amount + " TL";
        }
        return "Ödeme yöntemi: " + method +
               "\nTutar: " + amount + " TL";
    }
    
    /**
     * Kredi kartı bilgilerini ayarlar.
     *
     * @param cardHolder Kart sahibi
     * @param cardNumber Kart numarası
     * @param expiry Son kullanma tarihi
     * @param cvv Güvenlik kodu
     */
    
    public void setCardInfo(String cardHolder, String cardNumber, String expiry, String cvv) {
        this.setCardHolder(cardHolder);
        this.setCardNumber(cardNumber);
        this.setExpiryDate(expiry);
        this.setCvv(cvv);
    }

	public String getCardHolder() {
		return cardHolder;
	}

	public void setCardHolder(String cardHolder) {
		this.cardHolder = cardHolder;
	}

	public String getCardNumber() {
		return cardNumber;
	}

	public void setCardNumber(String cardNumber) {
		this.cardNumber = cardNumber;
	}

	public String getExpiryDate() {
		return expiryDate;
	}

	public void setExpiryDate(String expiryDate) {
		this.expiryDate = expiryDate;
	}

	public String getCvv() {
		return cvv;
	}

	public void setCvv(String cvv) {
		this.cvv = cvv;
	}

}
