package ParkingSystem.user;

import ParkingSystem.VehicleType;
import ParkingSystem.parking.ParkingFloor;
import ParkingSystem.parking.ParkingLot;
import ParkingSystem.payment.ParkingRate;

public class Admin extends Account {
    public Admin(String username, String password, Person person) {
        super(username, password, person);
    }

    @Override
    public boolean resetPassword() {
        // Admin password reset logic
        System.out.println("Admin password reset for: " + getUsername());
        return true;
    }

    public boolean addParkingFloor(ParkingLot parkingLot, ParkingFloor floor) {
        return parkingLot.addFloor(floor);
    }

    public boolean removeParkingFloor(ParkingLot parkingLot, String floorName) {
        return parkingLot.removeFloor(floorName);
    }

    public void updateParkingRate(VehicleType vehicleType, double newRate) {
        ParkingRate.getInstance().setRate(vehicleType, newRate);
    }
}