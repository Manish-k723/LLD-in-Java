package ParkingLotSystem;

import java.util.*;

public class ParkingManager {
    private static ParkingManager instance;
    private Map<VehicleType, List<ParkingSpot>> parkingSpots;
    private Map<String, ParkingSpot> vehicleToSpotMap;
    
    private ParkingManager() {
        parkingSpots = new HashMap<>();
        vehicleToSpotMap = new HashMap<>();
        initializeParkingSpots();
    }
    
    public static ParkingManager getInstance() {
        if (instance == null) {
            instance = new ParkingManager();
        }
        return instance;
    }
    
    private void initializeParkingSpots() {
        // Initialize parking spots for each vehicle type
        parkingSpots.put(VehicleType.TWO_WHEELER, new ArrayList<>());
        parkingSpots.put(VehicleType.FOUR_WHEELER, new ArrayList<>());
        parkingSpots.put(VehicleType.TRUCK, new ArrayList<>());
        
        // Add some default parking spots
        for (int i = 1; i <= 20; i++) {
            parkingSpots.get(VehicleType.TWO_WHEELER).add(new ParkingSpot("TW-" + i, VehicleType.TWO_WHEELER));
        }
        for (int i = 1; i <= 15; i++) {
            parkingSpots.get(VehicleType.FOUR_WHEELER).add(new ParkingSpot("FW-" + i, VehicleType.FOUR_WHEELER));
        }
        for (int i = 1; i <= 5; i++) {
            parkingSpots.get(VehicleType.TRUCK).add(new ParkingSpot("TR-" + i, VehicleType.TRUCK));
        }
    }
    
    public ParkingSpot findAvailableSpot(VehicleType vehicleType) {
        List<ParkingSpot> spots = parkingSpots.get(vehicleType);
        if (spots != null) {
            for (ParkingSpot spot : spots) {
                if (spot.isAvailable()) {
                    return spot;
                }
            }
        }
        return null;
    }
    
    public boolean parkVehicle(Vehicle vehicle) {
        ParkingSpot availableSpot = findAvailableSpot(vehicle.getVehicleType());
        if (availableSpot != null) {
            boolean parked = availableSpot.parkVehicle(vehicle);
            if (parked) {
                vehicleToSpotMap.put(vehicle.getVehicleNumber(), availableSpot);
                return true;
            }
        }
        return false;
    }
    
    public ParkingSpot removeVehicle(String vehicleNumber) {
        ParkingSpot spot = vehicleToSpotMap.get(vehicleNumber);
        if (spot != null) {
            spot.removeVehicle();
            vehicleToSpotMap.remove(vehicleNumber);
            return spot;
        }
        return null;
    }
    
    public ParkingSpot getVehicleSpot(String vehicleNumber) {
        return vehicleToSpotMap.get(vehicleNumber);
    }
    
    public void displayParkingStatus() {
        System.out.println("\n=== Parking Status ===");
        for (VehicleType type : VehicleType.values()) {
            List<ParkingSpot> spots = parkingSpots.get(type);
            long availableCount = spots.stream().mapToLong(spot -> spot.isAvailable() ? 1 : 0).sum();
            System.out.println(type + ": " + availableCount + "/" + spots.size() + " spots available");
        }
    }
}