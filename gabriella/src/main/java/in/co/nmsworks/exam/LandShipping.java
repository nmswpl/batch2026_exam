package in.co.nmsworks.exam;

public class LandShipping implements ShippingMethod{
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
            if (difference <= 5) {
                additionalCostWeight += (10 * difference);
            } else if (difference > 5 && difference <= 15) {
                additionalCostWeight += (15 * difference);
            } else {
                additionalCostWeight += (20 * difference);
            }

        }
        return additionalCostWeight;
    }

    @Override
    public double additionalDistanceCost(double distance) {
        double additionalCostDistance = 0;
        if (distance > getBaseDistance()) {
            double difference = distance - getBaseDistance();
            if (difference <= 300) {
                additionalCostDistance += getBaseDistance() + (20 * difference);
            } else if (difference > 300 && difference <= 700) {
                additionalCostDistance += getBaseDistance() + (30 * difference);
            } else {
                additionalCostDistance += getBaseDistance() + (35 * difference);
            }

        }
        return additionalCostDistance;
    }
}
