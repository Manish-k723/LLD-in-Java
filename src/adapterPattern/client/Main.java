package adapterPattern.client;

import adapterPattern.adaptee.WeightMachineForBabies;
import adapterPattern.adapter.WeightAdapter;
import adapterPattern.adapter.WeightAdapterImpl;

public class Main {
    public static void main(String[] args) {
        WeightAdapter weightAdapter = new WeightAdapterImpl(new WeightMachineForBabies());
        System.out.println(weightAdapter.getWeightInPounds());
    }
}
