package ParkingLotSystem;

import java.util.HashMap;
import java.util.Map;

public class PricingStrategy {
    private static PricingStrategy instance;
    private Map<VehicleType, Double> hourlyRates;
    
    private PricingStrategy() {
        hourlyRates = new HashMap<>();
        // Initialize default rates
        hourlyRates.put(VehicleType.TWO_WHEELER, 10.0);
        hourlyRates.put(VehicleType.FOUR_WHEELER, 20.0);
        hourlyRates.put(VehicleType.TRUCK, 50.0);
    }
    
    public static PricingStrategy getInstance() {
        if (instance == null) {
            instance = new PricingStrategy();
        }
        return instance;
    }
    
    public double getHourlyRate(VehicleType vehicleType) {
        return hourlyRates.getOrDefault(vehicleType, 0.0);
    }
    
    public void setHourlyRate(VehicleType vehicleType, double rate) {
        hourlyRates.put(vehicleType, rate);
    }
    
    public double calculateCost(VehicleType vehicleType, long durationInMinutes) {
        double hourlyRate = getHourlyRate(vehicleType);
        double hours = Math.ceil(durationInMinutes / 60.0); // Round up to nearest hour
        return hours * hourlyRate;
    }
}