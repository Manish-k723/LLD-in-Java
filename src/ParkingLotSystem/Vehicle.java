package ParkingLotSystem;

public class Vehicle {
    private String vehicleNumber;
    private VehicleType vehicleType;
    
    public Vehicle(String vehicleNumber, VehicleType vehicleType) {
        this.vehicleNumber = vehicleNumber;
        this.vehicleType = vehicleType;
    }
    
    public String getVehicleNumber() {
        return vehicleNumber;
    }
    
    public VehicleType getVehicleType() {
        return vehicleType;
    }
    
    @Override
    public String toString() {
        return "Vehicle{" +
                "vehicleNumber='" + vehicleNumber + '\'' +
                ", vehicleType=" + vehicleType +
                '}';
    }
}