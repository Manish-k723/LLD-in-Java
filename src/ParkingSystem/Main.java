package ParkingSystem;

import ParkingSystem.PaymentType;
import ParkingSystem.VehicleType;
import ParkingSystem.parking.ParkingFloor;
import ParkingSystem.parking.ParkingLot;
import ParkingSystem.parking.ParkingSpot;
import ParkingSystem.payment.ParkingRate;
import ParkingSystem.payment.ParkingTicket;
import ParkingSystem.payment.Payment;
import ParkingSystem.user.Admin;
import ParkingSystem.user.ParkingAttendant;
import ParkingSystem.user.Person;
import ParkingSystem.vehicle.Car;
import ParkingSystem.vehicle.Motorcycle;
import ParkingSystem.vehicle.Truck;

public class Main {
    public static void main(String[] args) {
        // Create a parking lot
        ParkingLot parkingLot = new ParkingLot("Central Parking", "123 Main Street, City");

        // Create parking floors
        ParkingFloor floor1 = new ParkingFloor("Floor 1");
        ParkingFloor floor2 = new ParkingFloor("Floor 2");

        // Add parking spots to floor 1
        for (int i = 1; i <= 10; i++) {
            floor1.addSpot(new ParkingSpot("F1-" + i, VehicleType.CAR));
        }
        for (int i = 11; i <= 15; i++) {
            floor1.addSpot(new ParkingSpot("F1-" + i, VehicleType.MOTORCYCLE));
        }
        for (int i = 16; i <= 18; i++) {
            floor1.addSpot(new ParkingSpot("F1-" + i, VehicleType.TRUCK));
        }

        // Add parking spots to floor 2
        for (int i = 1; i <= 8; i++) {
            floor2.addSpot(new ParkingSpot("F2-" + i, VehicleType.CAR));
        }
        for (int i = 9; i <= 12; i++) {
            floor2.addSpot(new ParkingSpot("F2-" + i, VehicleType.VAN));
        }

        // Add floors to parking lot
        parkingLot.addFloor(floor1);
        parkingLot.addFloor(floor2);

        // Create admin and parking attendant
        Person adminPerson = new Person("John Admin", "admin@parking.com", "555-0101");
        Admin admin = new Admin("admin", "admin123", adminPerson);

        Person attendantPerson = new Person("Mike Attendant", "attendant@parking.com", "555-0102");
        ParkingAttendant attendant = new ParkingAttendant("attendant", "att123", attendantPerson);

        // Show initial parking status
        System.out.println("Initial Parking Status:");
        parkingLot.showParkingStatus();

        // Demonstrate vehicle parking
        System.out.println("\n=== Vehicle Entry Process ===");

        // Park a car
        Car car1 = new Car("ABC123");
        ParkingTicket ticket1 = attendant.processVehicleEntry(car1, parkingLot);
        if (ticket1 != null) {
            System.out.println("Car parked successfully! Ticket: " + ticket1.getTicketNumber());
        }

        // Park a motorcycle
        Motorcycle bike1 = new Motorcycle("XYZ789");
        ParkingTicket ticket2 = attendant.processVehicleEntry(bike1, parkingLot);
        if (ticket2 != null) {
            System.out.println("Motorcycle parked successfully! Ticket: " + ticket2.getTicketNumber());
        }

        // Park a truck
        Truck truck1 = new Truck("TRK456");
        ParkingTicket ticket3 = attendant.processVehicleEntry(truck1, parkingLot);
        if (ticket3 != null) {
            System.out.println("Truck parked successfully! Ticket: " + ticket3.getTicketNumber());
        }

        // Show updated parking status
        System.out.println("\nUpdated Parking Status:");
        parkingLot.showParkingStatus();

        // Demonstrate vehicle exit and payment
        System.out.println("\n=== Vehicle Exit Process ===");

        // Simulate some time passing
        try {
            Thread.sleep(2000); // Wait 2 seconds to simulate time passing
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        // Process payment and exit for car
        Payment payment1 = attendant.processVehicleExit("ABC123", PaymentType.CREDIT_CARD, parkingLot);
        if (payment1 != null) {
            System.out.println("Car exit processed successfully!");
            System.out.println("Payment ID: " + payment1.getPaymentId());
            System.out.println("Amount: $" + payment1.getAmount());
        }

        // Show final parking status
        System.out.println("\nFinal Parking Status:");
        parkingLot.showParkingStatus();

        // Demonstrate admin functions
        System.out.println("\n=== Admin Functions ===");

        // Update parking rates
        admin.updateParkingRate(VehicleType.CAR, 2.5);
        System.out.println("Updated car parking rate to $2.5/hour");

        // Show new rates
        System.out.println("Current rates:");
        System.out.println("Motorcycle: $" + ParkingRate.getInstance().getRate(VehicleType.MOTORCYCLE) + "/hour");
        System.out.println("Car: $" + ParkingRate.getInstance().getRate(VehicleType.CAR) + "/hour");
        System.out.println("Truck: $" + ParkingRate.getInstance().getRate(VehicleType.TRUCK) + "/hour");
        System.out.println("Van: $" + ParkingRate.getInstance().getRate(VehicleType.VAN) + "/hour");
    }
}