package CarRentalSystem;

public class Payment {
    Bill bill;

    Payment(Bill bill) {
        this.bill = bill;
    }
    public void  payBill(Bill bill) {
        this.bill.isPaid = true;
    }
}
