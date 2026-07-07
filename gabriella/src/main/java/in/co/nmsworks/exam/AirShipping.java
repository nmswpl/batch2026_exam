package in.co.nmsworks.exam;

public class AirShipping implements ShippingMethod {

    private double basePrice = 100;
    private double baseWeight = 2;
    private double baseDistance = 50;

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
        double additionalCostWeight = 0;
        if (weight > getBaseWeight()) {
            double difference = weight - getBaseWeight();
            if (difference <= 10) {
                additionalCostWeight += 50 * difference;
            } else if (difference > 10 && difference <= 20) {
                additionalCostWeight += 60 * difference;
            } else {
                additionalCostWeight += 70 * difference;
            }

        }
        return additionalCostWeight;
    }

    @Override
    public double additionalDistanceCost(double distance) {
        double additionalCostDistance = 0;
        if (distance > getBaseDistance()) {
            double difference = distance - getBaseDistance();
            if (difference <= 500) {
                additionalCostDistance += 20 * difference;
            } else if (difference > 500 && difference <= 1000) {
                additionalCostDistance += 40 * difference;
            } else {
                additionalCostDistance += 50 * difference;
            }

        }
        return additionalCostDistance;
    }
}

