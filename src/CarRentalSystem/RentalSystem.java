package CarRentalSystem;

import CarRentalSystem.Product.Vehicle;

import java.util.List;

public class RentalSystem {
    List<User> users;
    List<Store> stores;

    RentalSystem(List<User> users, List<Store> stores) {
        this.users = users;
        this.stores = stores;
    }

    public Store getStore(Location location) {
        return stores.get(0);
    }
}
