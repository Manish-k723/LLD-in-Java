package CarRentalSystem;

import CarRentalSystem.Product.Vehicle;
import CarRentalSystem.Product.VehicleType;

import java.util.ArrayList;
import java.util.List;

public class Store {
    int storeId;
    String storeName;
    Location location;
    int latitude;
    int longitude;
    List<Reservations> reservations = new ArrayList<>();
    VehicleManagementSystem vehicleManagementSystem;
    ReservationStatus reservationStatus;
    ReservationType reservationType;

    public Store(int storeId, Location location, VehicleManagementSystem vehicleManagementSystem) {
        this.storeId = storeId;
        this.location = location;
        this.vehicleManagementSystem = vehicleManagementSystem;
    }

    public List<Vehicle> getVehicle(VehicleType vehicleType) {
        return vehicleManagementSystem.getVehicleList();
    }

    public Reservations createReservations(User user, Vehicle vehicle,  Location location) {
        Reservations reservations1 = new  Reservations();
        reservations1.createReservations(user, vehicle, location);
        reservations.add(reservations1);
        return reservations1;
    }
}
