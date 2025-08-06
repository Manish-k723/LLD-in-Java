package ParkingLotSystem;

import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;
import java.util.UUID;

public class ParkingTicket {
    private String ticketId;
    private String vehicleNumber;
    private VehicleType vehicleType;
    private String spotNumber;
    private LocalDateTime entryTime;
    private LocalDateTime exitTime;
    private double amount;
    private boolean isPaid;
    
    public ParkingTicket(String vehicleNumber, VehicleType vehicleType, String spotNumber) {
        this.ticketId = UUID.randomUUID().toString().substring(0, 8).toUpperCase();
        this.vehicleNumber = vehicleNumber;
        this.vehicleType = vehicleType;
        this.spotNumber = spotNumber;
        this.entryTime = LocalDateTime.now();
        this.exitTime = null;
        this.amount = 0.0;
        this.isPaid = false;
    }
    
    public String getTicketId() {
        return ticketId;
    }
    
    public String getVehicleNumber() {
        return vehicleNumber;
    }
    
    public VehicleType getVehicleType() {
        return vehicleType;
    }
    
    public String getSpotNumber() {
        return spotNumber;
    }
    
    public LocalDateTime getEntryTime() {
        return entryTime;
    }
    
    public LocalDateTime getExitTime() {
        return exitTime;
    }
    
    public void setExitTime(LocalDateTime exitTime) {
        this.exitTime = exitTime;
    }
    
    public double getAmount() {
        return amount;
    }
    
    public void setAmount(double amount) {
        this.amount = amount;
    }
    
    public boolean isPaid() {
        return isPaid;
    }
    
    public void setPaid(boolean paid) {
        isPaid = paid;
    }
    
    public long getDurationInMinutes() {
        if (exitTime != null) {
            return ChronoUnit.MINUTES.between(entryTime, exitTime);
        } else {
            return ChronoUnit.MINUTES.between(entryTime, LocalDateTime.now());
        }
    }
    
    @Override
    public String toString() {
        return "ParkingTicket{" +
                "ticketId='" + ticketId + '\'' +
                ", vehicleNumber='" + vehicleNumber + '\'' +
                ", vehicleType=" + vehicleType +
                ", spotNumber='" + spotNumber + '\'' +
                ", entryTime=" + entryTime +
                ", exitTime=" + exitTime +
                ", amount=" + amount +
                ", isPaid=" + isPaid +
                '}';
    }
}