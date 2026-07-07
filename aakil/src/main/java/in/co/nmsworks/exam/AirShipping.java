package in.co.nmsworks.exam;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class AirShipping extends DefaultShipping{
    private final Map<Integer, Integer> weightCost = new HashMap<>();
    private final Map<Integer, Integer> distanceCost = new HashMap<>();

    public AirShipping(double basePrice, double baseDistance, double baseWeight) {
        super(basePrice, baseDistance, baseWeight);
        weightCost.put(0, 50);
        weightCost.put(10, 60);
        weightCost.put(20, 70);

        distanceCost.put(0, 20);
        distanceCost.put(500, 40);
        distanceCost.put(1000, 50);
    }
}
