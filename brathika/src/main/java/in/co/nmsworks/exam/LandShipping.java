package in.co.nmsworks.exam;

public class LandShipping implements ShippingMethod{
    @Override
    public double getBasePrice() {
        return 100;
    }
    public String getName() {
        return "LandShipping";
    }

    @Override
    public double getBaseWeight() {
        return 2;
    }

    @Override
    public double getBaseDistance() {
        return 50;
    }

    @Override
    public double additionalWeightCost(double weight) {
        double additionalCost = 0.0;
        if (weight > getBaseWeight()) {
            double additionalWeight = weight - getBaseWeight();
            while (additionalWeight > 0) {
                if (additionalWeight < 5) {
                    additionalCost += weight * 10;
                    additionalWeight -= weight;
                } else if (additionalWeight > 5 && additionalWeight < 15) {
                    additionalCost += weight * 15;
                    additionalWeight -= weight;
                }
                else {
                    additionalCost += weight * 20;
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
            while (additionalDistance > 0) {
                if (additionalDistance < 300) {
                    additionalCost += distance * 20;
                    additionalDistance -= distance;

                } else if (additionalDistance > 300 && additionalDistance < 700) {
                    additionalCost += distance * 30;
                    additionalDistance -= distance;
                }
                else {
                    additionalCost += distance * 35;
                    additionalDistance -= distance;
                }
            }
            return additionalCost;
        }
        return 0;


    }
}
