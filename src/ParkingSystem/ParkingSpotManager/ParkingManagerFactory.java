package ParkingSystem.ParkingSpotManager;

import ParkingSystem.ParkingSpots.TwoWheelerParkingSpot;

public class ParkingManagerFactory {
    public ParkingSpotManager getParkingSpotManager(String type, int size) {
        switch (type) {
            case "two wheeler":
                new TwoWheelerParkingSpotManager(size);
                break;
            case "Four wheeler":
                new FourWheelerParkingSpotManager(size);
                break;
            default:
                return null;
        }
        return null;
    }
}
