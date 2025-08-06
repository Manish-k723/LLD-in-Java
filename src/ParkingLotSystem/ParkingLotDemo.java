package ParkingLotSystem;

public class ParkingLotDemo {
    public static void main(String[] args) {
        System.out.println("🅿️ PARKING LOT MANAGEMENT SYSTEM");
        System.out.println("==================================");
        
        // Initialize the parking lot system
        ParkingLotSystem parkingSystem = ParkingLotSystem.getInstance();
        
        // Display initial status
        System.out.println("\n📊 INITIAL SYSTEM STATUS");
        parkingSystem.displayParkingStatus();
        parkingSystem.displayPricingRates();
        
        // Create vehicles
        Vehicle bike = new Vehicle("MH12AB1234", VehicleType.TWO_WHEELER);
        Vehicle car = new Vehicle("MH12CD5678", VehicleType.FOUR_WHEELER);
        Vehicle truck = new Vehicle("MH12EF9012", VehicleType.TRUCK);
        
        // Vehicle Entry Process
        System.out.println("\n🚗 VEHICLE ENTRY SIMULATION");
        System.out.println("============================");
        
        ParkingTicket bikeTicket = parkingSystem.vehicleEntry(bike);
        ParkingTicket carTicket = parkingSystem.vehicleEntry(car);
        ParkingTicket truckTicket = parkingSystem.vehicleEntry(truck);
        
        // Display updated status
        parkingSystem.displayParkingStatus();
        parkingSystem.displayActiveTickets();
        
        // Simulate some parking time
        System.out.println("\n⏰ SIMULATING PARKING TIME (3 minutes)...");
        try {
            Thread.sleep(3000); // 3 seconds to simulate 3 minutes
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
        
        // Display current costs
        System.out.println("\n💰 CURRENT PARKING COSTS");
        System.out.println("========================");
        if (bikeTicket != null) {
            double bikeCost = parkingSystem.getCurrentCost(bike.getVehicleNumber());
            System.out.println("Bike (" + bike.getVehicleNumber() + "): ₹" + bikeCost);
        }
        if (carTicket != null) {
            double carCost = parkingSystem.getCurrentCost(car.getVehicleNumber());
            System.out.println("Car (" + car.getVehicleNumber() + "): ₹" + carCost);
        }
        if (truckTicket != null) {
            double truckCost = parkingSystem.getCurrentCost(truck.getVehicleNumber());
            System.out.println("Truck (" + truck.getVehicleNumber() + "): ₹" + truckCost);
        }
        
        // Vehicle Exit Process
        System.out.println("\n🚙 VEHICLE EXIT SIMULATION");
        System.out.println("===========================");
        
        // Exit bike with card payment
        if (bikeTicket != null) {
            parkingSystem.vehicleExit(bike.getVehicleNumber(), PaymentType.CARD_PAYMENT);
        }
        
        // Exit car with cash payment
        if (carTicket != null) {
            parkingSystem.vehicleExit(car.getVehicleNumber(), PaymentType.CASH_PAYMENT);
        }
        
        // Display final status
        System.out.println("\n📊 FINAL SYSTEM STATUS");
        parkingSystem.displayParkingStatus();
        parkingSystem.displayActiveTickets();
        
        // Admin functions - Update pricing
        System.out.println("\n⚙️ ADMIN FUNCTIONS - PRICING UPDATE");
        System.out.println("====================================");
        parkingSystem.updatePricingRate(VehicleType.TWO_WHEELER, 15.0);
        parkingSystem.updatePricingRate(VehicleType.FOUR_WHEELER, 25.0);
        parkingSystem.displayPricingRates();
        
        // Exit remaining truck with updated pricing
        if (truckTicket != null) {
            System.out.println("\n🚛 EXITING REMAINING TRUCK");
            System.out.println("==========================");
            parkingSystem.vehicleExit(truck.getVehicleNumber(), PaymentType.CARD_PAYMENT);
        }
        
        // Final system status
        System.out.println("\n📊 SYSTEM STATUS AFTER ALL EXITS");
        parkingSystem.displayParkingStatus();
        parkingSystem.displayActiveTickets();
        
        System.out.println("\n✅ PARKING LOT SYSTEM DEMO COMPLETED!");
        
        // Additional test - Try to park same vehicle again
        System.out.println("\n🧪 TESTING EDGE CASES");
        System.out.println("=====================");
        System.out.println("Attempting to park the same bike again:");
        Vehicle sameBike = new Vehicle("MH12AB1234", VehicleType.TWO_WHEELER);
        ParkingTicket duplicateTicket = parkingSystem.vehicleEntry(sameBike);
        
        // Try to exit non-existent vehicle
        System.out.println("\nAttempting to exit non-existent vehicle:");
        parkingSystem.vehicleExit("FAKE123", PaymentType.CARD_PAYMENT);
        
        System.out.println("\n🎯 EDGE CASE TESTING COMPLETED!");
    }
}