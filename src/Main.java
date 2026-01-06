import java.util.Scanner;
import models.*;
import services.*;

/**
 * Araç Kiralama Sistemi Ana Sınıfı
 * Bu sınıf kullanıcı arayüzünü yönetir ve sistemin ana akışını kontrol eder.
 * Kullanıcılar bu arayüz üzerinden araç kiralama, iade etme ve listeleme işlemlerini gerçekleştirebilir.
 * 
 * @author [nisa]
 */
public class Main {
    /**
     * Programın başlangıç noktası.
     * Kullanıcı menüsünü gösterir ve kullanıcı girişlerine göre işlem yapar.
     * 
     * @param args Komut satırı argümanları
     */
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        CarInventory inventory = new CarInventory();
        RentalService rentalService = new RentalService();

        // Başlangıç araçları
        inventory.addCar(new ElectricCar("E1", "Tesla", "Model 3", 2022, 250));
        inventory.addCar(new ElectricCar("E2", "BMW", "i4", 2023, 300));
        inventory.addCar(new GasCar("G1", "Fiat", "Egea", 2021, 180, Transmission.MANUAL));
        inventory.addCar(new GasCar("G2", "Honda", "Civic", 2022, 220, Transmission.AUTOMATIC));
        inventory.addCar(new GasCar("G3", "Toyota", "Corolla", 2020, 200, Transmission.AUTOMATIC));

        boolean running = true;

        while (running) {
            System.out.println("\n=== ARAÇ KİRALAMA SİSTEMİ ===");
            System.out.println("1 - Müsait araçları listele");
            System.out.println("2 - Araç kirala");
            System.out.println("3 - Araç iade et");
            System.out.println("4 - Kiralama geçmişini göster");
            System.out.println("0 - Çıkış");
            System.out.print("Seçiminiz: ");

            int choice = scanner.nextInt();
            scanner.nextLine(); // buffer temizleme

            switch (choice) {

            case 1:
                System.out.println("1 - Elektrikli araçlar");
                System.out.println("2 - Gazlı araçlar");
                int typeChoice = scanner.nextInt();
                scanner.nextLine();

                System.out.println("\nMüsait araçlar:");

                switch (typeChoice) {
                    case 1:
                        inventory.listAvailableCarsByType(ElectricCar.class).forEach(car ->
                            System.out.println(car + " | Günlük Ücret: " + car.getDailyPrice() + " TL")
                        );
                        break;

                    case 2:
                        System.out.println("1 - Manuel");
                        System.out.println("2 - Otomatik");
                        int t = scanner.nextInt();
                        scanner.nextLine();

                        Transmission tr = (t == 1)
                            ? Transmission.MANUAL
                            : Transmission.AUTOMATIC;

                        for (GasCar car : inventory.listAvailableGasCarsByTransmission(tr)) {
                            System.out.println(car + " | Günlük Ücret: " + car.getDailyPrice() +" TL");
                        }
                        break;

                    default:
                        System.out.println("Geçersiz seçim.");
                }
                break;


            case 2:
                System.out.print("Kiralanacak araç ID: ");
                String rentId = scanner.nextLine();

                Car carToRent = inventory.getAllCars()
                        .stream()
                        .filter(c -> c.getId().equals(rentId))
                        .findFirst()
                        .orElse(null);

                if (carToRent == null) {
                    System.out.println("Araç bulunamadı.");
                    break;
                }

                System.out.print("Müşteri adı: ");
                String name = scanner.nextLine();

                System.out.print("Telefon: ");
                String phone = scanner.nextLine();

                Customer customer = new Customer(name, phone);

                System.out.print("Kaç gün kiralanacak?: ");
                int days = scanner.nextInt();
                scanner.nextLine();

                // VALİDASYON BURAYA EKLENDİ! ⭐
                if (days <= 0) {
                    System.out.println("❌ Geçersiz gün sayısı! Lütfen pozitif bir sayı girin.");
                    break;
                }

                System.out.println("Ödeme yöntemi seçin:");
                System.out.println("1 - Kredi Kartı");
                System.out.println("2 - Havale");
                System.out.println("3 - Nakit");

                int pm = scanner.nextInt();
                scanner.nextLine();

                PaymentMethod method =
                    pm == 1 ? PaymentMethod.CREDIT_CARD :
                    pm == 2 ? PaymentMethod.BANK_TRANSFER :
                              PaymentMethod.CASH;

                Payment payment = new Payment(carToRent.calculateRentalFee(days), method);

                if (method == PaymentMethod.CREDIT_CARD) {
                    System.out.print("Kart Sahibi Adı: ");
                    String cardHolder = scanner.nextLine();

                    System.out.print("Kart Numarası: ");
                    String cardNumber = scanner.nextLine();

                    System.out.print("Son Kullanma Tarihi (AA/YY): ");
                    String expiry = scanner.nextLine();

                    System.out.print("CVV: ");
                    String cvv = scanner.nextLine();

                    payment.setCardInfo(cardHolder, cardNumber, expiry, cvv);
                }

                rentalService.rentCar(carToRent, customer, days, payment);

                break;


                case 3:
                    System.out.print("İade edilecek araç ID: ");
                    String returnId = scanner.nextLine();

                    Car carToReturn = inventory.getAllCars()
                            .stream()
                            .filter(c -> c.getId().equals(returnId))
                            .findFirst()
                            .orElse(null);

                    if (carToReturn != null) {
                        rentalService.returnCar(carToReturn);
                    } else {
                        System.out.println("Araç bulunamadı.");
                    }
                    break;

                case 4:
                    System.out.println("\n=== KİRALAMA GEÇMİŞİ ===");
                    if (rentalService.getRentalHistory().isEmpty()) {
                        System.out.println("Henüz kiralama yapılmadı.");
                    } else {
                        rentalService.getRentalHistory().forEach(record -> {
                            System.out.println(record);
                            System.out.println("----------------------");
                        });
                    }
                    break;


                case 0:
                    running = false;
                    System.out.println("Program sonlandırıldı.");
                    break;

                default:
                    System.out.println("Geçersiz seçim.");
            }
        }

        scanner.close();
    }
}