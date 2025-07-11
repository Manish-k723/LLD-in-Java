package CarRentalSystem.Product;

import java.util.Date;


public class Vehicle {

    int vehicleID;
    int vehicleNumber;
    VehicleType vehicleType;
    String companyName;
    double kmDriven;
    Date manufacturingDate;
    int cc;
    double average;
    int hourlyRentalCost;
    int dailyRentalCost;
    int seatCount;
    Status status;

    public void setVehicleID(int vehicleID) {
        this.vehicleID = vehicleID;
    }
    public void setVehicleNumber(int vehicleNumber) {
        this.vehicleNumber = vehicleNumber;
    }
    public void setVehicleType(VehicleType vehicleType) {
        this.vehicleType = vehicleType;
    }
}
