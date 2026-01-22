import java.util.Scanner;
import java.io.*;
import java.util.List;
import java.util.ArrayList;
import models.*;
import services.*;

/**
 * Araç Kiralama Sistemi Ana Sınıfı
 * Bu sınıf kullanıcı arayüzünü yönetir ve sistemin ana akışını kontrol eder.
 * 
 * @author [nisa]
 */
public class Main {


    private static final String FILE_PATH = "car.txt";

    // 🆕 DOSYADAN ARAÇLARI YÜKLE
    private static List<Car> loadCarsFromFile() {
        List<Car> cars = new ArrayList<>();
        File file = new File(FILE_PATH);
        
        System.out.println("📍 Dosya aranan yer: " + file.getAbsolutePath());
        
        try (BufferedReader br = new BufferedReader(new FileReader(FILE_PATH))) {
            String line;
            int lineCount = 0;
            
            while ((line = br.readLine()) != null) {
                lineCount++;
                String[] parts = line.split(",");
                
                if (parts.length < 6) {
                    System.out.println("⚠️ Satır " + lineCount + " atlandı (eksik veri)");
                    continue;
                }
                
                try {
                    String id = parts[0].trim();
                    String brand = parts[1].trim();
                    String model = parts[2].trim();
                    int year = Integer.parseInt(parts[3].trim());
                    double dailyPrice = Double.parseDouble(parts[4].trim());
                    String type = parts[5].trim();
                    
                    if (type.equalsIgnoreCase("ELECTRIC")) {
                        cars.add(new ElectricCar(id, brand, model, year, dailyPrice));
                    } 
                    else if (type.equalsIgnoreCase("GAS") && parts.length >= 7) {
                        Transmission transmission = parts[6].trim().equalsIgnoreCase("MANUAL") 
                            ? Transmission.MANUAL 
                            : Transmission.AUTOMATIC;
                        cars.add(new GasCar(id, brand, model, year, dailyPrice, transmission));
                    }
                } catch (NumberFormatException e) {
                    System.out.println("⚠️ Satır " + lineCount + " atlandı (sayı formatı hatası)");
                }
            }
            
            System.out.println("✅ Dosyadan " + cars.size() + " araç yüklendi.\n");
            
        } catch (FileNotFoundException e) {
            System.out.println("⚠️ car.txt dosyası bulunamadı. Varsayılan araçlar yükleniyor.\n");
        } catch (IOException e) {
            System.out.println("❌ Dosya okuma hatası: " + e.getMessage() + "\n");
        }
        
        return cars;
    }

    // 🆕 ARAÇLARI DOSYAYA KAYDET
    private static void saveCarsToFile(List<Car> cars) {
        File file = new File(FILE_PATH);
        
        try (BufferedWriter bw = new BufferedWriter(new FileWriter(FILE_PATH))) {
            
            System.out.println("💾 Kaydediliyor: " + cars.size() + " araç");
            System.out.println("📍 Dosya konumu: " + file.getAbsolutePath());
            
            for (Car car : cars) {
                StringBuilder sb = new StringBuilder();
                sb.append(car.getId()).append(",");
                sb.append(car.getBrand()).append(",");
                sb.append(car.getModel()).append(",");
                sb.append(car.getYear()).append(",");
                sb.append(car.getDailyPrice()).append(",");
                
                if (car instanceof ElectricCar) {
                    sb.append("ELECTRIC");
                } else if (car instanceof GasCar) {
                    GasCar gasCar = (GasCar) car;
                    sb.append("GAS,");
                    sb.append(gasCar.getTransmission());
                }
                
                bw.write(sb.toString());
                bw.newLine();
            }
            
            System.out.println("✅ Araçlar başarıyla dosyaya kaydedildi!\n");
            
        } catch (IOException e) {
            System.out.println("❌ Dosya yazma hatası: " + e.getMessage());
            e.printStackTrace();
        }
    }

    /**
     * Programın başlangıç noktası.
     * Kullanıcı menüsünü gösterir ve kullanıcı girişlerine göre işlem yapar.
     * 
     * @param args Komut satırı argümanları (kullanılmıyor)
     */
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        CarInventory inventory = new CarInventory();
        RentalService rentalService = new RentalService();

        // 🆕 DOSYADAN ARAÇLARI YÜKLE
        List<Car> carsFromFile = loadCarsFromFile();

        if (carsFromFile.isEmpty()) {
            // Dosya yoksa veya boşsa varsayılan araçlar
            System.out.println("📦 Varsayılan araçlar sisteme ekleniyor...\n");
            inventory.addCar(new ElectricCar("E1", "Tesla", "Model 3", 2022, 250));
            inventory.addCar(new ElectricCar("E2", "BMW", "i4", 2023, 300));
            inventory.addCar(new GasCar("G1", "Fiat", "Egea", 2021, 180, Transmission.MANUAL));
            inventory.addCar(new GasCar("G2", "Honda", "Civic", 2022, 220, Transmission.AUTOMATIC));
            inventory.addCar(new GasCar("G3", "Toyota", "Corolla", 2020, 200, Transmission.AUTOMATIC));
            
            // 🔥 Varsayılan araçları hemen kaydet
            saveCarsToFile(inventory.getAllCars());
        } else {
            // Dosyadan yüklenen araçları envantere ekle
            for (Car car : carsFromFile) {
                inventory.addCar(car);
            }
        }

        boolean running = true;

        while (running) {
            System.out.println("\n=== ARAÇ KİRALAMA SİSTEMİ ===");
            System.out.println("1 - Müsait araçları listele");
            System.out.println("2 - Araç kirala");
            System.out.println("3 - Araç iade et");
            System.out.println("4 - Kiralama geçmişini göster");
            System.out.println("5 - Yeni araç ekle");
            System.out.println("6 - Araçları dosyaya kaydet");
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
                        List<Car> electricCars = inventory.listAvailableCarsByType(ElectricCar.class);
                        if (electricCars.isEmpty()) {
                            System.out.println("Müsait elektrikli araç yok.");
                        } else {
                            electricCars.forEach(car ->
                                System.out.println(car + " | Günlük Ücret: " + car.getDailyPrice() + " TL")
                            );
                        }
                        break;

                    case 2:
                        System.out.println("1 - Manuel");
                        System.out.println("2 - Otomatik");
                        int t = scanner.nextInt();
                        scanner.nextLine();

                        Transmission tr = (t == 1)
                            ? Transmission.MANUAL
                            : Transmission.AUTOMATIC;

                        List<GasCar> gasCars = inventory.listAvailableGasCarsByTransmission(tr);
                        if (gasCars.isEmpty()) {
                            System.out.println("Müsait " + tr + " vites araç yok.");
                        } else {
                            for (GasCar car : gasCars) {
                                System.out.println(car + " | Günlük Ücret: " + car.getDailyPrice() +" TL");
                            }
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
                    System.out.println("❌ Araç bulunamadı.");
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

                // VALİDASYON
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
                    System.out.println("❌ Araç bulunamadı.");
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

            // 🆕 CASE 5: YENİ ARAÇ EKLE
            case 5:
                System.out.println("\n=== YENİ ARAÇ EKLE ===");
                
                System.out.print("Araç ID: ");
                String newId = scanner.nextLine();
                
                // ID kontrolü
                boolean idExists = inventory.getAllCars().stream()
                    .anyMatch(c -> c.getId().equals(newId));
                
                if (idExists) {
                    System.out.println("❌ Bu ID zaten kullanılıyor! Farklı bir ID girin.");
                    break;
                }
                
                System.out.print("Marka: ");
                String newBrand = scanner.nextLine();
                
                System.out.print("Model: ");
                String newModel = scanner.nextLine();
                
                System.out.print("Yıl: ");
                int newYear = scanner.nextInt();
                scanner.nextLine();
                
                System.out.print("Günlük Ücret: ");
                double newPrice = scanner.nextDouble();
                scanner.nextLine();
                
                System.out.println("Araç Tipi:");
                System.out.println("1 - Elektrikli");
                System.out.println("2 - Gazlı");
                int carType = scanner.nextInt();
                scanner.nextLine();
                
                if (carType == 1) {
                    inventory.addCar(new ElectricCar(newId, newBrand, newModel, newYear, newPrice));
                    System.out.println("✅ Elektrikli araç başarıyla eklendi!");
                } else if (carType == 2) {
                    System.out.println("Vites Tipi:");
                    System.out.println("1 - Manuel");
                    System.out.println("2 - Otomatik");
                    int trans = scanner.nextInt();
                    scanner.nextLine();
                    
                    Transmission transmission = (trans == 1) ? Transmission.MANUAL : Transmission.AUTOMATIC;
                    inventory.addCar(new GasCar(newId, newBrand, newModel, newYear, newPrice, transmission));
                    System.out.println("✅ Gazlı araç başarıyla eklendi!");
                } else {
                    System.out.println("❌ Geçersiz araç tipi!");
                    break;
                }
                

                saveCarsToFile(inventory.getAllCars());
                
                break;

            // 🆕 CASE 6: DOSYAYA KAYDET
            case 6:
                saveCarsToFile(inventory.getAllCars());
                break;

            case 0:

                System.out.println("\n👋 Program kapatılıyor...");
                saveCarsToFile(inventory.getAllCars());
                running = false;
                System.out.println("Program sonlandırıldı.");
                break;

            default:
                System.out.println("❌ Geçersiz seçim. Lütfen tekrar deneyin.");
            }
        }

        scanner.close();
    }
}