package strategyPattern;

import strategyPattern.strategy.DriveStrategy;
import strategyPattern.strategy.NormalDriveStrategy;

public class GoodVehicle extends Vehicle{
    GoodVehicle() {
        super(new NormalDriveStrategy());
    }
}
