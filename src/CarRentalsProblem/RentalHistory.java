package CarRentalsProblem;

import java.util.ArrayList;

public class RentalHistory {
    public static ArrayList<Rent> rentals = new ArrayList<>();

    public static void RentalHistoryByCar(String regNumber) {
        int cnt = 0;
        for (int i = 0; i < rentals.size(); i++) {
            if (rentals.get(i).car.regNumber.equals(regNumber)) {
                cnt++;
                System.out.println("\nCar registrataion Number: " + rentals.get(i).car.regNumber);
                System.out.println("Rented By" + rentals.get(i).customer.name);
                System.out.println("Rented on " + rentals.get(i).rentalDate);
                System.out.println("Returned on " + rentals.get(i).returnDate);
                System.out.println("Returned after " + rentals.get(i).totaldays + " days \n");
            }
        }
        if (cnt == 0) {
            System.out.println("\nNo rental history found with this car");
        }
    }

    public static void RentalHistoryByCustomer(String Name) {
        int cnt = 0;
        for (int i = 0; i < rentals.size(); i++) {
            if (rentals.get(i).customer.name.equals(Name)) {
                cnt++;
                System.out.println("\nCar registrataion Number: " + rentals.get(i).car.regNumber);
                System.out.println("Rented By" + rentals.get(i).customer.name);
                System.out.println("Rented on " + rentals.get(i).rentalDate);
                System.out.println("Returned on " + rentals.get(i).returnDate);
                System.out.println("Returned after " + rentals.get(i).totaldays + " days \n");
            }
        }
        if (cnt == 0) {
            System.out.println("\nNo rental history found with this customer");
        }
    }
}
