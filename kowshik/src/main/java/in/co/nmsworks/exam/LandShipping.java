package in.co.nmsworks.exam;

public class LandShipping implements ShippingMethod{
    @Override
    public double getBasePrice() {
        return 100;
    }

    @Override
    public double getBaseWeight() {
        return 10;
    }

    @Override
    public double getBaseDistance() {
        return 50;
    }

    @Override
    public double additionalWeightCost(double weight) {
        if (weight <= 5) {
            return (10 * weight);
        } else if (weight <= 15) {
            return (15 * weight);
        }
        return (weight * 20);
    }

    @Override
    public double additionalDistanceCost(double distance) {
        if (distance <= 300) {
            return (20 * distance);
        } else if (distance <= 700) {
            return (30 * distance);
        }
        return (distance * 35);
    }
}
