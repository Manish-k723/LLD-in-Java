package ParkingSystem.parking;

import ParkingSystem.VehicleType;
import ParkingSystem.vehicle.Vehicle;

public class ParkingSpot {
    private String number;
    private VehicleType spotType;
    private Vehicle vehicle;
    private boolean isOccupied;

    public ParkingSpot(String number, VehicleType spotType) {
        this.number = number;
        this.spotType = spotType;
        this.isOccupied = false;
    }

    public String getNumber() {
        return number;
    }

    public VehicleType getSpotType() {
        return spotType;
    }

    public Vehicle getVehicle() {
        return vehicle;
    }

    public boolean isOccupied() {
        return isOccupied;
    }

    public boolean parkVehicle(Vehicle vehicle) {
        if (isOccupied || !vehicle.canFitInSpot(this)) {
            return false;
        }
        this.vehicle = vehicle;
        this.isOccupied = true;
        return true;
    }

    public Vehicle removeVehicle() {
        if (!isOccupied) {
            return null;
        }
        Vehicle removedVehicle = this.vehicle;
        this.vehicle = null;
        this.isOccupied = false;
        return removedVehicle;
    }
}