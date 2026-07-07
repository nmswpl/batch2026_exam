package in.co.nmsworks.exam;

public class SeaShipping implements ShippingMethod{
    @Override
    public double getBasePrice() {
        return 100;
    }

    @Override
    public double getBaseWeight() {
        return 5;
    }

    @Override
    public double getBaseDistance() {
        return 30;
    }

    @Override
    public double additionalWeightCost(double weight) {
        if (weight <= 25) {
            return (30 * weight);
        } else if (weight <= 50) {
            return (40 * weight);
        }
        return (weight * 45);
    }

    @Override
    public double additionalDistanceCost(double distance) {
        if (distance <= 100) {
            return (10 * distance);
        } else if (distance <= 500) {
            return (20 * distance);
        }
        return (distance * 25);
    }
}
