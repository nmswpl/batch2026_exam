package in.co.nmsworks.exam;

public class SeaShipping implements ShippingMethod{
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
            if (difference <= 25) {
                additionalCostWeight += (30 * difference);
            } else if (difference > 25 && difference <= 50) {
                additionalCostWeight += (40 * difference);
            } else {
                additionalCostWeight += (45 * difference);
            }

        }
        return additionalCostWeight;
    }

    @Override
    public double additionalDistanceCost(double distance) {
        double additionalCostDistance = 0;
        if (distance > getBaseDistance()) {
            double difference = distance - getBaseDistance();
            if (difference <= 100) {
                additionalCostDistance += (10 * difference);
            } else if (difference > 100 && difference <= 500) {
                additionalCostDistance += (20 * difference);
            } else {
                additionalCostDistance += (25 * difference);
            }

        }
        return additionalCostDistance;
    }

}
