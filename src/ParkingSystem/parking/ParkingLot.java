package ParkingSystem.parking;

import ParkingSystem.VehicleType;
import ParkingSystem.payment.ParkingTicket;
import ParkingSystem.vehicle.Vehicle;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ParkingLot {
    private String name;
    private String address;
    private List<ParkingFloor> floors;
    private Map<String, ParkingTicket> activeTickets;
    private static int ticketCounter = 1;

    public ParkingLot(String name, String address) {
        this.name = name;
        this.address = address;
        this.floors = new ArrayList<>();
        this.activeTickets = new HashMap<>();
    }

    public String getName() {
        return name;
    }

    public String getAddress() {
        return address;
    }

    public List<ParkingFloor> getFloors() {
        return floors;
    }

    public boolean addFloor(ParkingFloor floor) {
        return floors.add(floor);
    }

    public boolean removeFloor(String floorName) {
        return floors.removeIf(floor -> floor.getName().equals(floorName));
    }

    public ParkingTicket parkVehicle(Vehicle vehicle) {
        for (ParkingFloor floor : floors) {
            if (floor.parkVehicle(vehicle)) {
                String ticketNumber = "TKT-" + ticketCounter++;
                ParkingSpot spot = floor.findAvailableSpot(vehicle.getType());
                ParkingTicket ticket = new ParkingTicket(ticketNumber, vehicle, spot);
                vehicle.setTicket(ticket);
                activeTickets.put(vehicle.getLicenseNumber(), ticket);
                floor.updateDisplayBoard();
                return ticket;
            }
        }
        return null;
    }

    public Vehicle removeVehicle(String licenseNumber) {
        ParkingTicket ticket = activeTickets.get(licenseNumber);
        if (ticket != null && ticket.isPaid()) {
            for (ParkingFloor floor : floors) {
                Vehicle vehicle = floor.removeVehicle(licenseNumber);
                if (vehicle != null) {
                    activeTickets.remove(licenseNumber);
                    floor.updateDisplayBoard();
                    return vehicle;
                }
            }
        }
        return null;
    }

    public ParkingTicket getTicketByLicense(String licenseNumber) {
        return activeTickets.get(licenseNumber);
    }

    public void showParkingStatus() {
        System.out.println("=== " + name + " Parking Status ===");
        System.out.println("Address: " + address);
        System.out.println("Total Floors: " + floors.size());

        for (ParkingFloor floor : floors) {
            System.out.println("\nFloor: " + floor.getName());
            System.out.println("Available spots:");
            System.out.println("  Motorcycle: " + floor.getAvailableSpots(VehicleType.MOTORCYCLE));
            System.out.println("  Car: " + floor.getAvailableSpots(VehicleType.CAR));
            System.out.println("  Truck: " + floor.getAvailableSpots(VehicleType.TRUCK));
            System.out.println("  Van: " + floor.getAvailableSpots(VehicleType.VAN));
        }
        System.out.println("================================");
    }

    public boolean isFull(VehicleType vehicleType) {
        for (ParkingFloor floor : floors) {
            if (floor.getAvailableSpots(vehicleType) > 0) {
                return false;
            }
        }
        return true;
    }
}