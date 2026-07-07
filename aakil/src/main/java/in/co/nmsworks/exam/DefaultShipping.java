package in.co.nmsworks.exam;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public abstract class DefaultShipping implements ShippingMethod{
    private double basePrice;
    private double baseDistance;
    private double baseWeight;

    private final Map<Integer, Integer> weightCost = new HashMap<>();
    private final Map<Integer, Integer> distanceCost = new HashMap<>();

    public DefaultShipping(double basePrice, double baseDistance, double baseWeight) {
        this.basePrice = basePrice;
        this.baseDistance = baseDistance;
        this.baseWeight = baseWeight;
    }

    public Map<Integer, Integer> getWeightCost() {
        return weightCost;
    }

    public Map<Integer, Integer> getDistanceCost() {
        return distanceCost;
    }

    @Override
    public double getBasePrice() {
        return basePrice;
    }

    @Override
    public double getBaseWeight() {
        return baseWeight;
    }

    @Override
    public double getBaseDistance() {
        return baseDistance;
    }

    @Override
    public double additionalWeightCost(double weight) {
        if (weight < getBaseWeight()){
            return 0;
        }

        double cost = 0;
        double additionalWeight = weight - getBaseWeight();
        List<Map.Entry<Integer, Integer>> weightCostEntries = new ArrayList<>(getWeightCost().entrySet());
        weightCostEntries.sort((e1, e2) -> e2.getKey() - e1.getKey());

        for (Map.Entry<Integer, Integer> weightCostEntry : weightCostEntries) {
            if (additionalWeight > weightCostEntry.getKey()){
                cost = additionalWeight * weightCostEntry.getValue();
                System.out.println(cost);
                return cost;
            }
        }

        return cost;
    }

    @Override
    public double additionalDistanceCost(double distance) {
        if (distance < getBaseWeight()){
            return 0;
        }

        double cost = 0;
        double additionalDistance = distance - getBaseWeight();
        List<Map.Entry<Integer, Integer>> distanceCostEntries = new ArrayList<>(getDistanceCost().entrySet());
        distanceCostEntries.sort((e1, e2) -> e2.getKey() - e1.getKey());

        for (Map.Entry<Integer, Integer> distanceCostEntry : distanceCostEntries) {
            if (additionalDistance > distanceCostEntry.getKey()){
                cost = additionalDistance * distanceCostEntry.getValue();
                System.out.println(cost);
            }
        }
        return cost;
    }
}
