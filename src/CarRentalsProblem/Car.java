package CarRentalsProblem;

import java.util.Scanner;

public class Car {
    public String model, year, color, price, regNumber;
    public Customer rented = null;
    public String rentedDate = null;

    public Car(String model, String year, String color, String price, String regNumber) {
        this.model = model;
        this.year = year;
        this.color = color;
        this.price = price;
        this.regNumber = regNumber;
    }

    public static Car createCar() {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the model of the cear");
        String model = sc.nextLine();
        System.out.println("Enter the year of the car");
        String year = sc.nextLine();
        System.out.println("Enter the color of the car");
        String color = sc.nextLine();
        System.out.println("Enter the price of the car");
        String price = sc.nextLine();
        System.out.println("Enter the reg number of the car");
        String regNumber = sc.nextLine();
        if (CarRentals.checkCar.containsKey(regNumber)) {
            System.out.println("Car  already exists");
            return null;
        }
        Car car = new Car(model, year, color, price, regNumber);
        return car;
    }
}
