package ParkingSystem.payment;

import ParkingSystem.PaymentStatus;
import ParkingSystem.VehicleType;
import ParkingSystem.parking.ParkingSpot;
import ParkingSystem.vehicle.Vehicle;
import java.time.LocalDateTime;

public class ParkingTicket {
    private String ticketNumber;
    private LocalDateTime issuedAt;
    private LocalDateTime paidAt;
    private double amount;
    private PaymentStatus status;
    private Vehicle vehicle;
    private ParkingSpot spot;

    public ParkingTicket(String ticketNumber, Vehicle vehicle, ParkingSpot spot) {
        this.ticketNumber = ticketNumber;
        this.vehicle = vehicle;
        this.spot = spot;
        this.issuedAt = LocalDateTime.now();
        this.status = PaymentStatus.PENDING;
        this.amount = 0.0;
    }

    public String getTicketNumber() {
        return ticketNumber;
    }

    public LocalDateTime getIssuedAt() {
        return issuedAt;
    }

    public LocalDateTime getPaidAt() {
        return paidAt;
    }

    public double getAmount() {
        return amount;
    }

    public PaymentStatus getStatus() {
        return status;
    }

    public Vehicle getVehicle() {
        return vehicle;
    }

    public ParkingSpot getSpot() {
        return spot;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    public void markAsPaid() {
        this.status = PaymentStatus.COMPLETED;
        this.paidAt = LocalDateTime.now();
    }

    public boolean isPaid() {
        return status == PaymentStatus.COMPLETED;
    }
}