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
import ParkingSystem.vehicle.Van;

public class ParkingSystemTest {
    public static void main(String[] args) {
        System.out.println("=== Parking System Test ===\n");

        // Test 1: Create and test different vehicle types
        testVehicleTypes();

        // Test 2: Test parking spot compatibility
        testParkingSpotCompatibility();

        // Test 3: Test payment processing
        testPaymentProcessing();

        // Test 4: Test admin functions
        testAdminFunctions();
    }

    private static void testVehicleTypes() {
        System.out.println("Test 1: Vehicle Types");
        System.out.println("---------------------");

        Car car = new Car("CAR001");
        Motorcycle bike = new Motorcycle("BIKE001");
        Truck truck = new Truck("TRUCK001");
        Van van = new Van("VAN001");

        System.out.println("Car License: " + car.getLicenseNumber() + ", Type: " + car.getType());
        System.out.println("Motorcycle License: " + bike.getLicenseNumber() + ", Type: " + bike.getType());
        System.out.println("Truck License: " + truck.getLicenseNumber() + ", Type: " + truck.getType());
        System.out.println("Van License: " + van.getLicenseNumber() + ", Type: " + van.getType());
        System.out.println();
    }

    private static void testParkingSpotCompatibility() {
        System.out.println("Test 2: Parking Spot Compatibility");
        System.out.println("----------------------------------");

        ParkingSpot carSpot = new ParkingSpot("C1", VehicleType.CAR);
        ParkingSpot bikeSpot = new ParkingSpot("B1", VehicleType.MOTORCYCLE);
        ParkingSpot truckSpot = new ParkingSpot("T1", VehicleType.TRUCK);

        Car car = new Car("CAR002");
        Motorcycle bike = new Motorcycle("BIKE002");
        Truck truck = new Truck("TRUCK002");

        System.out.println("Car can fit in car spot: " + car.canFitInSpot(carSpot));
        System.out.println("Car can fit in bike spot: " + car.canFitInSpot(bikeSpot));
        System.out.println("Bike can fit in car spot: " + bike.canFitInSpot(carSpot));
        System.out.println("Truck can fit in truck spot: " + truck.canFitInSpot(truckSpot));
        System.out.println("Truck can fit in car spot: " + truck.canFitInSpot(carSpot));
        System.out.println();
    }

    private static void testPaymentProcessing() {
        System.out.println("Test 3: Payment Processing");
        System.out.println("---------------------------");

        // Create a simple parking scenario
        Car car = new Car("CAR003");
        ParkingSpot spot = new ParkingSpot("C2", VehicleType.CAR);
        ParkingTicket ticket = new ParkingTicket("TKT-TEST", car, spot);

        // Test different payment types
        Payment cashPayment = new Payment(ticket, PaymentType.CASH);
        Payment cardPayment = new Payment(ticket, PaymentType.CREDIT_CARD);
        Payment mobilePayment = new Payment(ticket, PaymentType.MOBILE_PAYMENT);

        System.out.println("Cash Payment ID: " + cashPayment.getPaymentId());
        System.out.println("Card Payment ID: " + cardPayment.getPaymentId());
        System.out.println("Mobile Payment ID: " + mobilePayment.getPaymentId());
        System.out.println("Ticket Amount: $" + ticket.getAmount());
        System.out.println("Payment Status: " + ticket.getStatus());
        System.out.println();
    }

    private static void testAdminFunctions() {
        System.out.println("Test 4: Admin Functions");
        System.out.println("----------------------");

        Person adminPerson = new Person("Test Admin", "admin@test.com", "555-0000");
        Admin admin = new Admin("testadmin", "password", adminPerson);

        // Test rate updates
        System.out.println("Original Motorcycle rate: $" + ParkingRate.getInstance().getRate(VehicleType.MOTORCYCLE));
        admin.updateParkingRate(VehicleType.MOTORCYCLE, 1.5);
        System.out.println("Updated Motorcycle rate: $" + ParkingRate.getInstance().getRate(VehicleType.MOTORCYCLE));

        // Test password reset
        admin.resetPassword();
        System.out.println("Admin account status: " + admin.getStatus());
        System.out.println();
    }
}