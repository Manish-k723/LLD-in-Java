package ParkingSystem.vehicle;

import ParkingSystem.VehicleType;
import ParkingSystem.parking.ParkingSpot;

public class Motorcycle extends Vehicle {
    public Motorcycle(String licenseNumber) {
        super(licenseNumber, VehicleType.MOTORCYCLE);
    }

    @Override
    public boolean canFitInSpot(ParkingSpot spot) {
        return true; // Motorcycles can fit in any spot
    }
}