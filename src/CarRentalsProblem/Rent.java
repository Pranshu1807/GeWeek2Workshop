package CarRentalsProblem;

public class Rent {
    public Car car;
    public Customer customer;
    public String rentalDate, returnDate;
    public int totaldays;

    public Rent(Car car, Customer customer, String rentalDate, String returnDate, int totaldays) {
        this.car = car;
        this.customer = customer;
        this.rentalDate = rentalDate;
        this.totaldays = totaldays;
        this.returnDate = returnDate;
    }
}
