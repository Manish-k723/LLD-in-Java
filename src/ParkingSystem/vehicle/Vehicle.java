package ParkingSystem.vehicle;

import ParkingSystem.VehicleType;
import ParkingSystem.parking.ParkingSpot;
import ParkingSystem.payment.ParkingTicket;

public abstract class Vehicle {
    private String licenseNumber;
    private VehicleType type;
    private ParkingTicket ticket;

    public Vehicle(String licenseNumber, VehicleType type) {
        this.licenseNumber = licenseNumber;
        this.type = type;
    }

    public String getLicenseNumber() {
        return licenseNumber;
    }

    public VehicleType getType() {
        return type;
    }

    public ParkingTicket getTicket() {
        return ticket;
    }

    public void setTicket(ParkingTicket ticket) {
        this.ticket = ticket;
    }

    public abstract boolean canFitInSpot(ParkingSpot spot);
}