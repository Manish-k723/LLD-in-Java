package ParkingSystem.ParkingSpotManager;

import ParkingSystem.ParkingSpots.ParkingSpot;
import ParkingSystem.ParkingSpots.TwoWheelerParkingSpot;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class ParkingSpotManager {

    List<ParkingSpot> parkingSpots;
    private int size;

    public ParkingSpotManager(int size) {
        this.size = size;
        this.parkingSpots = new ArrayList<>(size);
    }

    public void addVehicle(ParkingSpot parkingSpot) {
        if(parkingSpots.size() == size) {
            System.out.println("No more two wheeler parking spots");
            return;
        }
        parkingSpots.add(parkingSpot);
    }

    public List<ParkingSpot> getParkingSpots() {
        return Collections.emptyList();
    }

    public void setParkingSpots(List<ParkingSpot> parkingSpots) {

    }

    public void addParkingSpot(List<ParkingSpot> parkingSpots) {

    }
}
