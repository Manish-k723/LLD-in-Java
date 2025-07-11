package CarRentalSystem;

public class Bill {
    Reservations reservations;
    boolean isPaid;
    double amount;

    Bill(Reservations reservations) {
        this.reservations = reservations;
        this.amount = computeBillAmount();
    }

    private double computeBillAmount() {
        return 100.0;
    }
}
