package in.co.nmsworks.exam;

import java.util.HashMap;
import java.util.Map;

public class SeaShipping extends DefaultShipping{
    private final Map<Integer, Integer> weightCost = new HashMap<>();
    private final Map<Integer, Integer> distanceCost = new HashMap<>();

    public SeaShipping(double basePrice, double baseDistance, double baseWeight) {
        super(basePrice, baseDistance, baseWeight);
        weightCost.put(0, 30);
        weightCost.put(25, 40);
        weightCost.put(50, 45);

        distanceCost.put(0, 10);
        distanceCost.put(100, 20);
        distanceCost.put(500, 25);
    }
}
