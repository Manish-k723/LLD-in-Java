package ParkingLotSystem;

public class ParkingSpot {
    private String spotNumber;
    private VehicleType vehicleType;
    private boolean isAvailable;
    private Vehicle parkedVehicle;
    
    public ParkingSpot(String spotNumber, VehicleType vehicleType) {
        this.spotNumber = spotNumber;
        this.vehicleType = vehicleType;
        this.isAvailable = true;
        this.parkedVehicle = null;
    }
    
    public String getSpotNumber() {
        return spotNumber;
    }
    
    public VehicleType getVehicleType() {
        return vehicleType;
    }
    
    public boolean isAvailable() {
        return isAvailable;
    }
    
    public Vehicle getParkedVehicle() {
        return parkedVehicle;
    }
    
    public boolean parkVehicle(Vehicle vehicle) {
        if (isAvailable && vehicle.getVehicleType() == this.vehicleType) {
            this.parkedVehicle = vehicle;
            this.isAvailable = false;
            return true;
        }
        return false;
    }
    
    public Vehicle removeVehicle() {
        Vehicle vehicle = this.parkedVehicle;
        this.parkedVehicle = null;
        this.isAvailable = true;
        return vehicle;
    }
    
    @Override
    public String toString() {
        return "ParkingSpot{" +
                "spotNumber='" + spotNumber + '\'' +
                ", vehicleType=" + vehicleType +
                ", isAvailable=" + isAvailable +
                ", parkedVehicle=" + parkedVehicle +
                '}';
    }
}