package ParkingSystem.vehicle;

import ParkingSystem.VehicleType;
import ParkingSystem.parking.ParkingSpot;

public class Car extends Vehicle {
    public Car(String licenseNumber) {
        super(licenseNumber, VehicleType.CAR);
    }

    @Override
    public boolean canFitInSpot(ParkingSpot spot) {
        return spot.getSpotType() == VehicleType.CAR || spot.getSpotType() == VehicleType.VAN;
    }
}