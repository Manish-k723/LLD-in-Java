package CarRentalSystem;

import CarRentalSystem.Product.Vehicle;

import java.util.List;

public class VehicleManagementSystem {
    List<Vehicle> vehicleList;

    VehicleManagementSystem(List<Vehicle> vehicleList) {
        this.vehicleList = vehicleList;
    }

    void addVehicle(Vehicle vehicle) {
        vehicleList.add(vehicle);
    }
    void removeVehicle(Vehicle vehicle) {
        vehicleList.remove(vehicle);
    }

    public List<Vehicle> getVehicleList() {
        return vehicleList;
    }

    public void setVehicleList(List<Vehicle> vehicleList) {
        this.vehicleList = vehicleList;
    }
}
