package CarRentalSystem;

import CarRentalSystem.Product.Car;
import CarRentalSystem.Product.Vehicle;
import CarRentalSystem.Product.VehicleType;

import java.util.ArrayList;
import java.util.List;

public class Main {

    public static void main(String[] args) {
        List<User> users = addUsers();
        List<Vehicle> vehicles = addVehicles();
        List<Store> stores = addStores(vehicles);

        RentalSystem rentalSystem = new RentalSystem(users, stores);

        Location location = new Location("Delhi", "Delhi", "India", 110037);
        Store store = rentalSystem.getStore(location);

        List<Vehicle> storeVehicles = store.getVehicle(VehicleType.CAR);

        Reservations reservations = store.createReservations(users.get(0), storeVehicles.get(0), location);

        Bill bill = new Bill(reservations);
        Payment payment = new Payment(bill);
        payment.payBill(bill);
    }


    private static List<Store> addStores(List<Vehicle> vehicles) {
        List<Store> stores = new ArrayList<>();
        VehicleManagementSystem vehicleManagementSystem = new VehicleManagementSystem(vehicles);
        Location location = new Location("Gurgaon", "Haryana", "India", 122017);
        Store store = new Store(1, location, vehicleManagementSystem);
        stores.add(store);
        return stores;
    }

    private static List<Vehicle> addVehicles() {
        List<Vehicle> vehicles = new ArrayList<>();

        Vehicle vehicle1 = new Car();
        vehicle1.setVehicleID(1);
        vehicle1.setVehicleNumber(123);
        vehicle1.setVehicleType(VehicleType.CAR);
        vehicles.add(vehicle1);

        Vehicle vehicle2 = new Car();
        vehicle1.setVehicleID(2);
        vehicle1.setVehicleNumber(124);
        vehicle1.setVehicleType(VehicleType.BIKE);
        vehicles.add(vehicle2);
        return vehicles;
    }

    private static List<User> addUsers() {
        List<User> userList = new ArrayList<>();
        User user1 = new User(1, "Manish", "DL1");
        User user2 = new User(2, "Priyanka", "DL2");
        userList.add(user1);
        userList.add(user2);
        return userList;
    }
}
