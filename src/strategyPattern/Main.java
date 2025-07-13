package strategyPattern;

public class Main {
    public static void main(String[] args) {
        GoodVehicle goodVehicle = new GoodVehicle();
        goodVehicle.drive();
        OffRoadVehicle offRoadVehicle = new OffRoadVehicle();
        offRoadVehicle.drive();
        SportsVehicle sportsVehicle = new SportsVehicle();
        sportsVehicle.drive();
    }
}
