package adapterPattern.adapter;

import adapterPattern.adaptee.WeightMachine;

public class WeightAdapterImpl implements WeightAdapter{
    WeightMachine weightMachine;

    public WeightAdapterImpl(WeightMachine weightMachine) {
        this.weightMachine = weightMachine;
    }

    @Override
    public double getWeightInPounds() {
        double weightInKg = weightMachine.getWeightInKg();
        return weightInKg * 2.2;
    }
}
