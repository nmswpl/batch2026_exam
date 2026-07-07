package in.co.nmsworks.exam;

import java.util.HashMap;
import java.util.Map;

public class LandShipping extends DefaultShipping{
    private final Map<Integer, Integer> weightCost = new HashMap<>();
    private final Map<Integer, Integer> distanceCost = new HashMap<>();

    public LandShipping(double basePrice, double baseDistance, double baseWeight) {
        super(basePrice, baseDistance, baseWeight);
        weightCost.put(0, 10);
        weightCost.put(5, 15);
        weightCost.put(15, 20);

        distanceCost.put(0, 20);
        distanceCost.put(300, 30);
        distanceCost.put(700, 35);
    }
}
