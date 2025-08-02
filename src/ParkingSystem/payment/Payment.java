package ParkingSystem.payment;

import ParkingSystem.PaymentStatus;
import ParkingSystem.PaymentType;
import ParkingSystem.VehicleType;
import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;

public class Payment {
    private String paymentId;
    private ParkingTicket ticket;
    private double amount;
    private PaymentStatus status;
    private LocalDateTime paymentTime;
    private PaymentType paymentType;

    public Payment(ParkingTicket ticket, PaymentType paymentType) {
        this.paymentId = "PAY-" + System.currentTimeMillis();
        this.ticket = ticket;
        this.paymentType = paymentType;
        this.status = PaymentStatus.PENDING;
        calculateAmount();
    }

    private void calculateAmount() {
        LocalDateTime now = LocalDateTime.now();
        long hours = ChronoUnit.HOURS.between(ticket.getIssuedAt(), now);
        if (hours < 1)
            hours = 1; // Minimum 1 hour charge

        ParkingRate rate = ParkingRate.getInstance();
        this.amount = rate.calculateRate(ticket.getVehicle().getType(), hours);
        ticket.setAmount(this.amount);
    }

    public boolean processPayment() {
        // Simulate payment processing
        try {
            Thread.sleep(1000); // Simulate processing time
            this.status = PaymentStatus.COMPLETED;
            this.paymentTime = LocalDateTime.now();
            this.ticket.markAsPaid();
            return true;
        } catch (InterruptedException e) {
            this.status = PaymentStatus.FAILED;
            return false;
        }
    }

    public String getPaymentId() {
        return paymentId;
    }

    public ParkingTicket getTicket() {
        return ticket;
    }

    public double getAmount() {
        return amount;
    }

    public PaymentStatus getStatus() {
        return status;
    }

    public LocalDateTime getPaymentTime() {
        return paymentTime;
    }

    public PaymentType getPaymentType() {
        return paymentType;
    }
}