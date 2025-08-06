package ParkingLotSystem;

public class ParkingLotSystem {
    private static ParkingLotSystem instance;
    private EntranceGate entranceGate;
    private ExitGate exitGate;
    private ParkingManager parkingManager;
    private PricingStrategy pricingStrategy;
    
    private ParkingLotSystem() {
        entranceGate = EntranceGate.getInstance();
        exitGate = ExitGate.getInstance();
        parkingManager = ParkingManager.getInstance();
        pricingStrategy = PricingStrategy.getInstance();
    }
    
    public static ParkingLotSystem getInstance() {
        if (instance == null) {
            instance = new ParkingLotSystem();
        }
        return instance;
    }
    
    public ParkingTicket vehicleEntry(Vehicle vehicle) {
        return entranceGate.processVehicleEntry(vehicle);
    }
    
    public double vehicleExit(String vehicleNumber, PaymentType paymentType) {
        return exitGate.processVehicleExit(vehicleNumber, paymentType);
    }
    
    public double getCurrentCost(String vehicleNumber) {
        return exitGate.calculateCurrentCost(vehicleNumber);
    }
    
    public void displayParkingStatus() {
        parkingManager.displayParkingStatus();
    }
    
    public void displayActiveTickets() {
        entranceGate.displayActiveTickets();
    }
    
    public void updatePricingRate(VehicleType vehicleType, double rate) {
        pricingStrategy.setHourlyRate(vehicleType, rate);
        System.out.println("Updated " + vehicleType + " rate to ₹" + rate + "/hour");
    }
    
    public void displayPricingRates() {
        System.out.println("\n=== Current Pricing Rates ===");
        for (VehicleType type : VehicleType.values()) {
            System.out.println(type + ": ₹" + pricingStrategy.getHourlyRate(type) + "/hour");
        }
    }
}