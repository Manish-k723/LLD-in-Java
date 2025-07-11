package CarRentalSystem;

import java.util.Date;
import java.util.List;
import CarRentalSystem.Product.Vehicle;

public class Reservations {
    int reservationId;
    User user;
    Vehicle vehicle;
    Date bookingDate;
    Location location;

    public void setUser(User user) {
        this.user = user;
    }

    public void setVehicle(Vehicle vehicle) {
        this.vehicle = vehicle;
    }

    public void createReservations(User user, Vehicle vehicle, Location location) {
        this.reservationId = 1;
        this.user = user;
        this.vehicle = vehicle;
        this.bookingDate = new Date();
        this.location = location;
    }
}
