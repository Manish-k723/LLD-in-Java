package ParkingSystem.payment;

import ParkingSystem.VehicleType;
import java.util.HashMap;
import java.util.Map;

public class ParkingRate {
    private static ParkingRate instance;
    private Map<VehicleType, Double> hourlyRates;

    private ParkingRate() {
        hourlyRates = new HashMap<>();
        hourlyRates.put(VehicleType.MOTORCYCLE, 1.0);
        hourlyRates.put(VehicleType.CAR, 2.0);
        hourlyRates.put(VehicleType.TRUCK, 3.5);
        hourlyRates.put(VehicleType.VAN, 2.5);
    }

    public static ParkingRate getInstance() {
        if (instance == null) {
            instance = new ParkingRate();
        }
        return instance;
    }

    public double calculateRate(VehicleType vehicleType, long hours) {
        Double rate = hourlyRates.get(vehicleType);
        if (rate == null) {
            rate = 2.0; // Default rate
        }
        return rate * hours;
    }

    public void setRate(VehicleType vehicleType, double rate) {
        hourlyRates.put(vehicleType, rate);
    }

    public double getRate(VehicleType vehicleType) {
        return hourlyRates.getOrDefault(vehicleType, 2.0);
    }
}