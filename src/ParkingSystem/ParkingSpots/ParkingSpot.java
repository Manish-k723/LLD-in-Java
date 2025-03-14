package ParkingSystem.ParkingSpots;

import ParkingSystem.Vehicle;

public abstract class ParkingSpot {
    private int id;
    private boolean occupied;
    private Vehicle vehicle;
    private int price;

    public void parkVehicle(Vehicle vehicle) {
        this.vehicle = vehicle;
        occupied = true;
    }

    public void unparkVehicle() {
        this.vehicle = null;
        occupied = false;
    }

    public abstract int price();
}
