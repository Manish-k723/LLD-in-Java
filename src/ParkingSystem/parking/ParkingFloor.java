package ParkingSystem.parking;

import ParkingSystem.VehicleType;
import ParkingSystem.display.DisplayBoard;
import ParkingSystem.vehicle.Vehicle;
import java.util.ArrayList;
import java.util.List;

public class ParkingFloor {
    private String name;
    private List<ParkingSpot> spots;
    private DisplayBoard displayBoard;

    public ParkingFloor(String name) {
        this.name = name;
        this.spots = new ArrayList<>();
        this.displayBoard = new DisplayBoard();
    }

    public String getName() {
        return name;
    }

    public List<ParkingSpot> getSpots() {
        return spots;
    }

    public DisplayBoard getDisplayBoard() {
        return displayBoard;
    }

    public void addSpot(ParkingSpot spot) {
        spots.add(spot);
    }

    public ParkingSpot findAvailableSpot(VehicleType vehicleType) {
        for (ParkingSpot spot : spots) {
            if (!spot.isOccupied() && spot.getSpotType() == vehicleType) {
                return spot;
            }
        }
        return null;
    }

    public boolean parkVehicle(Vehicle vehicle) {
        ParkingSpot spot = findAvailableSpot(vehicle.getType());
        if (spot != null) {
            return spot.parkVehicle(vehicle);
        }
        return false;
    }

    public Vehicle removeVehicle(String licenseNumber) {
        for (ParkingSpot spot : spots) {
            if (spot.isOccupied() && spot.getVehicle().getLicenseNumber().equals(licenseNumber)) {
                return spot.removeVehicle();
            }
        }
        return null;
    }

    public int getAvailableSpots(VehicleType vehicleType) {
        int count = 0;
        for (ParkingSpot spot : spots) {
            if (!spot.isOccupied() && spot.getSpotType() == vehicleType) {
                count++;
            }
        }
        return count;
    }

    public void updateDisplayBoard() {
        displayBoard.updateAvailability(this);
    }
}