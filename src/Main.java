import java.util.ArrayList;
import java.util.List;

abstract class Vehicle {
    protected String plateNumber;

    public Vehicle(String plateNumber) {
        this.plateNumber = plateNumber;
    }

    public String getPlate() {
        return plateNumber;
    }

    public abstract String getType();
}

class Car extends Vehicle {
    public Car(String plateNumber) {
        super(plateNumber);
    }

    public String getType() {
        return "Car";
    }
}

class Motorcycle extends Vehicle {
    public Motorcycle(String plateNumber) {
        super(plateNumber);
    }

    public String getType() {
        return "Motorcycle";
    }
}

class Ticket {
    private int ticketId;
    private int duration;

    public Ticket(int ticketId, int duration) {
        this.ticketId = ticketId;
        this.duration = duration;
    }

    public int getTicketId() {
        return ticketId;
    }

    public double calculateFee(String vehicleType) {
        if (vehicleType.equals("Car")) {
            return duration * 5000;
        } else {
            return duration * 2000;
        }
    }
}

class ParkingLot {
    private List<Vehicle> vehicles = new ArrayList<>();

    public void addVehicle(Vehicle v) {
        vehicles.add(v);
        System.out.println(v.getType() + " masuk: " + v.getPlate());
    }

    public int getTotalVehicles() {
        return vehicles.size();
    }
}

public class Main {
    public static void main(String[] args) {
        ParkingLot parking = new ParkingLot();

        Vehicle car = new Car("B 1234 ABC");
        Vehicle motor = new Motorcycle("AE 5678 XYZ");

        parking.addVehicle(car);
        parking.addVehicle(motor);

        Ticket ticket1 = new Ticket(1, 2);
        Ticket ticket2 = new Ticket(2, 3);

        System.out.println("Ticket ID: " + ticket1.getTicketId());
        System.out.println("Biaya mobil: " + ticket1.calculateFee(car.getType()));
        System.out.println("Biaya motor: " + ticket2.calculateFee(motor.getType()));

        System.out.println("Total kendaraan: " + parking.getTotalVehicles());
    }
}
