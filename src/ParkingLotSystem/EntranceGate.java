package ParkingLotSystem;

import java.util.HashMap;
import java.util.Map;

public class EntranceGate {
    private static EntranceGate instance;
    private Map<String, ParkingTicket> activeTickets;
    private ParkingManager parkingManager;
    
    private EntranceGate() {
        activeTickets = new HashMap<>();
        parkingManager = ParkingManager.getInstance();
    }
    
    public static EntranceGate getInstance() {
        if (instance == null) {
            instance = new EntranceGate();
        }
        return instance;
    }
    
    public ParkingTicket processVehicleEntry(Vehicle vehicle) {
        System.out.println("\n=== Vehicle Entry Process ===");
        System.out.println("Vehicle detected: " + vehicle.getVehicleNumber() + " (" + vehicle.getVehicleType() + ")");
        
        // Check if vehicle is already parked
        if (activeTickets.containsKey(vehicle.getVehicleNumber())) {
            System.out.println("ERROR: Vehicle " + vehicle.getVehicleNumber() + " is already parked!");
            return null;
        }
        
        // Find available parking spot
        ParkingSpot availableSpot = parkingManager.findAvailableSpot(vehicle.getVehicleType());
        if (availableSpot == null) {
            System.out.println("ERROR: No available parking spots for " + vehicle.getVehicleType());
            return null;
        }
        
        // Park the vehicle
        boolean parked = parkingManager.parkVehicle(vehicle);
        if (!parked) {
            System.out.println("ERROR: Failed to park vehicle " + vehicle.getVehicleNumber());
            return null;
        }
        
        // Generate parking ticket
        ParkingTicket ticket = new ParkingTicket(
            vehicle.getVehicleNumber(),
            vehicle.getVehicleType(),
            availableSpot.getSpotNumber()
        );
        
        activeTickets.put(vehicle.getVehicleNumber(), ticket);
        
        System.out.println("SUCCESS: Vehicle parked at spot " + availableSpot.getSpotNumber());
        System.out.println("Parking ticket generated: " + ticket.getTicketId());
        
        return ticket;
    }
    
    public ParkingTicket getActiveTicket(String vehicleNumber) {
        return activeTickets.get(vehicleNumber);
    }
    
    public void removeActiveTicket(String vehicleNumber) {
        activeTickets.remove(vehicleNumber);
    }
    
    public void displayActiveTickets() {
        System.out.println("\n=== Active Parking Tickets ===");
        if (activeTickets.isEmpty()) {
            System.out.println("No active tickets");
        } else {
            for (ParkingTicket ticket : activeTickets.values()) {
                System.out.println("Ticket: " + ticket.getTicketId() + 
                    " | Vehicle: " + ticket.getVehicleNumber() + 
                    " | Spot: " + ticket.getSpotNumber() +
                    " | Duration: " + ticket.getDurationInMinutes() + " minutes");
            }
        }
    }
}