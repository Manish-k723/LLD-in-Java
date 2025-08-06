package ParkingLotSystem;

import java.time.LocalDateTime;

public class ExitGate {
    private static ExitGate instance;
    private EntranceGate entranceGate;
    private ParkingManager parkingManager;
    private PricingStrategy pricingStrategy;
    
    private ExitGate() {
        entranceGate = EntranceGate.getInstance();
        parkingManager = ParkingManager.getInstance();
        pricingStrategy = PricingStrategy.getInstance();
    }
    
    public static ExitGate getInstance() {
        if (instance == null) {
            instance = new ExitGate();
        }
        return instance;
    }
    
    public double processVehicleExit(String vehicleNumber, PaymentType paymentType) {
        System.out.println("\n=== Vehicle Exit Process ===");
        System.out.println("Processing exit for vehicle: " + vehicleNumber);
        
        // Get active ticket
        ParkingTicket ticket = entranceGate.getActiveTicket(vehicleNumber);
        if (ticket == null) {
            System.out.println("ERROR: No active ticket found for vehicle " + vehicleNumber);
            return -1;
        }
        
        // Set exit time and calculate duration
        ticket.setExitTime(LocalDateTime.now());
        long durationInMinutes = ticket.getDurationInMinutes();
        
        // Calculate parking cost
        double amount = pricingStrategy.calculateCost(ticket.getVehicleType(), durationInMinutes);
        ticket.setAmount(amount);
        
        System.out.println("Parking duration: " + durationInMinutes + " minutes");
        System.out.println("Total amount: ₹" + amount);
        
        // Process payment
        boolean paymentSuccess = processPayment(paymentType, amount);
        if (!paymentSuccess) {
            System.out.println("ERROR: Payment failed!");
            return -1;
        }
        
        ticket.setPaid(true);
        
        // Remove vehicle from parking spot
        ParkingSpot spot = parkingManager.removeVehicle(vehicleNumber);
        if (spot == null) {
            System.out.println("ERROR: Failed to remove vehicle from parking spot");
            return -1;
        }
        
        // Remove active ticket
        entranceGate.removeActiveTicket(vehicleNumber);
        
        System.out.println("SUCCESS: Vehicle " + vehicleNumber + " exited successfully");
        System.out.println("Payment of ₹" + amount + " processed via " + paymentType);
        System.out.println("Parking spot " + spot.getSpotNumber() + " is now available");
        
        return amount;
    }
    
    private boolean processPayment(PaymentType paymentType, double amount) {
        System.out.println("Processing " + paymentType + " payment of ₹" + amount);
        
        // Simulate payment processing
        try {
            Thread.sleep(1000); // Simulate processing time
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
            return false;
        }
        
        // In a real system, this would integrate with payment gateways
        switch (paymentType) {
            case CARD_PAYMENT:
                System.out.println("Card payment processed successfully");
                return true;
            case CASH_PAYMENT:
                System.out.println("Cash payment received successfully");
                return true;
            default:
                System.out.println("Unknown payment type");
                return false;
        }
    }
    
    public double calculateCurrentCost(String vehicleNumber) {
        ParkingTicket ticket = entranceGate.getActiveTicket(vehicleNumber);
        if (ticket != null) {
            long durationInMinutes = ticket.getDurationInMinutes();
            return pricingStrategy.calculateCost(ticket.getVehicleType(), durationInMinutes);
        }
        return 0.0;
    }
}