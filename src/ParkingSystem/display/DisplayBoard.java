package ParkingSystem.display;

import ParkingSystem.VehicleType;
import ParkingSystem.parking.ParkingFloor;

public class DisplayBoard {
    private String id;
    private ParkingFloor floor;

    public DisplayBoard() {
        this.id = "DB-" + System.currentTimeMillis();
    }

    public String getId() {
        return id;
    }

    public void updateAvailability(ParkingFloor floor) {
        this.floor = floor;
        showAvailability();
    }

    public void showAvailability() {
        if (floor == null) {
            System.out.println("Display Board: No floor information available");
            return;
        }

        System.out.println("=== Parking Availability - " + floor.getName() + " ===");
        System.out.println("Available spots:");
        System.out.println("Motorcycle: " + floor.getAvailableSpots(VehicleType.MOTORCYCLE));
        System.out.println("Car: " + floor.getAvailableSpots(VehicleType.CAR));
        System.out.println("Truck: " + floor.getAvailableSpots(VehicleType.TRUCK));
        System.out.println("Van: " + floor.getAvailableSpots(VehicleType.VAN));
        System.out.println("================================");
    }
}