package CarRentalsProblem;

import java.util.ArrayList;
import java.util.Scanner;

public class CarManagement {
    public static ArrayList<Car> cars = new ArrayList<>();

    public static void addCar() {
        Car car = Car.createCar();
        if (car != null) {
            cars.add(car);
            CarRentals.checkCar.put(car.regNumber, 1);
        }
    }

    public static void deleteCar(String regNumber) {
        for (int i = 0; i < cars.size(); i++) {
            if (cars.get(i).regNumber.equals(regNumber)) {
                cars.remove(i);
                CarRentals.checkCustomer.remove(regNumber);
                return;
            }
        }
        System.out.println("\nCar does not exist");
    }

    public static void updateCar(String regNumber) {
        Scanner sc = new Scanner(System.in);
        for (int i = 0; i < cars.size(); i++) {
            if (cars.get(i).regNumber.equals(regNumber)) {
                System.out.println("Enter the model of the car");
                String model = sc.nextLine();
                System.out.println("Enter the year of the car");
                String year = sc.nextLine();
                System.out.println("Enter the color of the car");
                String color = sc.nextLine();
                System.out.println("Enter the price of the car");
                String price = sc.nextLine();
                cars.get(i).model = model;
                cars.get(i).year = year;
                cars.get(i).color = color;
                cars.get(i).price = price;
            }
        }
    }

    public static void showCars() {
        for (int i = 0; i < cars.size(); i++) {
            System.out.println("\nDetails of Car " + (i + 1));
            System.out.println("Model: " + cars.get(i).model);
            System.out.println("Year: " + cars.get(i).year);
            System.out.println("Price: " + cars.get(i).price);
            System.out.println("Color: " + cars.get(i).color);
            System.out.println("Registration Number: " + cars.get(i).regNumber);
        }
    }
}
