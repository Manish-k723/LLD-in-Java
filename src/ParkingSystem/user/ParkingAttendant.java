package ParkingSystem.user;

import ParkingSystem.PaymentType;
import ParkingSystem.VehicleType;
import ParkingSystem.parking.ParkingLot;
import ParkingSystem.payment.ParkingTicket;
import ParkingSystem.payment.Payment;
import ParkingSystem.vehicle.Vehicle;

public class ParkingAttendant extends Account {
    public ParkingAttendant(String username, String password, Person person) {
        super(username, password, person);
    }

    @Override
    public boolean resetPassword() {
        // Parking attendant password reset logic
        System.out.println("Parking attendant password reset for: " + getUsername());
        return true;
    }

    public ParkingTicket processVehicleEntry(Vehicle vehicle, ParkingLot parkingLot) {
        return parkingLot.parkVehicle(vehicle);
    }

    public Payment processVehicleExit(String licenseNumber, PaymentType paymentType, ParkingLot parkingLot) {
        ParkingTicket ticket = parkingLot.getTicketByLicense(licenseNumber);
        if (ticket != null && !ticket.isPaid()) {
            Payment payment = new Payment(ticket, paymentType);
            if (payment.processPayment()) {
                parkingLot.removeVehicle(licenseNumber);
                return payment;
            }
        }
        return null;
    }
}