package in.co.nmsworks.exam;

public class SeaShipping implements ShippingMethod{
    @Override
    public double getBasePrice() {
        return 100;
    }
    public String getName() {
        return "SeaShipping";
    }

    @Override
    public double getBaseWeight() {
        return 10;
    }

    @Override
    public double getBaseDistance() {
        return 15;
    }

    @Override
    public double additionalWeightCost(double weight) {
        double additionalCost = 0.0;
        if (weight > getBaseWeight()) {
            double additionalWeight = weight - getBaseWeight();
            while (additionalWeight > 0) {
                if (additionalWeight < 25) {
                    additionalCost += weight * 30;
                    additionalWeight -= weight;
                } else if (additionalWeight > 25 && additionalWeight < 50) {
                    additionalCost += weight * 40;
                    additionalWeight -= weight;
                }
                else {
                    additionalCost += weight * 40;
                    additionalWeight -= weight;

                }
            }
            return additionalCost;
        }
        return 0;
    }

    @Override
    public double additionalDistanceCost(double distance) {
        double additionalCost = 0.0;
        if (distance > getBaseDistance()) {
            double additionalDistance = distance - getBaseDistance();
            if (additionalDistance < 100) {
                additionalCost += distance * 10;
                additionalDistance -= distance;

            } else if (additionalDistance > 100 && additionalDistance < 500) {
                additionalCost += distance * 20;
                additionalDistance -= distance;
            }
            else {
                additionalCost += distance * 25;
                additionalDistance -= distance;
            }
            return additionalCost;
        }

        return 0;
    }
}
