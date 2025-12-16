import java.util.Scanner;
import models.*;
import services.*;

public class Main {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        CarInventory inventory = new CarInventory();
        RentalService rentalService = new RentalService();

        // Başlangıç araçları
        inventory.addCar(new ElectricCar("E1", "Tesla", "Model 3", 2022, 75));
        inventory.addCar(new GasCar("G1", "Toyota", "Corolla", 2020, 50));

        boolean running = true;

        while (running) {
            System.out.println("\n=== ARAÇ KİRALAMA SİSTEMİ ===");
            System.out.println("1 - Müsait araçları listele");
            System.out.println("2 - Araç kirala");
            System.out.println("3 - Araç iade et");
            System.out.println("0 - Çıkış");
            System.out.print("Seçiminiz: ");

            int choice = scanner.nextInt();
            scanner.nextLine(); // buffer temizleme

            switch (choice) {
                case 1:
                    System.out.println("\nMüsait araçlar:");
                    inventory.listAvailableCars().forEach(System.out::println);
                    break;

                case 2:
                    System.out.print("Kiralanacak araç ID: ");
                    String rentId = scanner.nextLine();
                    Car carToRent = inventory.getAllCars()
                            .stream()
                            .filter(c -> c.getId().equals(rentId))
                            .findFirst()
                            .orElse(null);

                    if (carToRent != null) {
                        rentalService.rentCar(carToRent);
                    } else {
                        System.out.println("Araç bulunamadı.");
                    }
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
