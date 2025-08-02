package ParkingSystem.vehicle;

import ParkingSystem.VehicleType;
import ParkingSystem.parking.ParkingSpot;

public class Truck extends Vehicle {
    public Truck(String licenseNumber) {
        super(licenseNumber, VehicleType.TRUCK);
    }

    @Override
    public boolean canFitInSpot(ParkingSpot spot) {
        return spot.getSpotType() == VehicleType.TRUCK;
    }
}