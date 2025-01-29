import java.util.Scanner;

public class CarsRun {
    public static void main(String[] args) {
        Volvo240 volvo = new Volvo240();
        Saab95 saab = new Saab95();
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("\nVälj bil att styra:");
            System.out.println("1. Volvo240");
            System.out.println("2. Saab95");
            System.out.println("3. Avsluta");
            int choice = scanner.nextInt();

            Cars car;
            if (choice == 1) {
                car = volvo;
            } else if (choice == 2) {
                car = saab;
            } else {
                break;
            }

            while (true) {
                System.out.println("\nVälj en handling:");
                System.out.println("1. Starta motorn");
                System.out.println("2. Stanna motorn");
                System.out.println("3. Gasa");
                System.out.println("4. Bromsa");
                System.out.println("5. Flytta bilen");
                System.out.println("6. Visa status");
                int action = scanner.nextInt();

                if (action == 1) {
                    car.startEngine();
                } else if (action == 2) {
                    car.stopEngine();
                } else if (action == 3) {
                    System.out.print("Ange gasvärde (0-1): ");
                    double amount = scanner.nextDouble();
                    car.gas(amount);
                } else if (action == 4) {
                    System.out.print("Ange bromsvärde (0-1): ");
                    double amount = scanner.nextDouble();
                    car.brake(amount);
                } else if (action == 5) {
                    car.move();
                } else if (action == 6) {
                    System.out.println("Hastighet: " + car.getCurrentSpeed());
                }
            }
        }
        scanner.close();
        System.out.println("Programmet avslutas.");
    }
}


