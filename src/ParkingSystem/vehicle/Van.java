package ParkingSystem.vehicle;

import ParkingSystem.VehicleType;
import ParkingSystem.parking.ParkingSpot;

public class Van extends Vehicle {
    public Van(String licenseNumber) {
        super(licenseNumber, VehicleType.VAN);
    }

    @Override
    public boolean canFitInSpot(ParkingSpot spot) {
        return spot.getSpotType() == VehicleType.VAN;
    }
}