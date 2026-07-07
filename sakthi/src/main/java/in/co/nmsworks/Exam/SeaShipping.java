package in.co.nmsworks.Exam;

public class SeaShipping implements ShippingMethod {
    @Override
    public double getBasePrice() { return 100.0; }
    @Override
    public double getBaseWeight() { return 2.0; }
    @Override
    public double getBaseDistance() { return 50.0; }

    @Override
    public double additionalWeightCost(double weight) {
        double extraWeight = weight - getBaseWeight();
        if (extraWeight <= 0) return 0.0;

        double cost = 0.0;
        if (extraWeight <= 25) {
            cost += extraWeight * 30;
        } else if (extraWeight <= 50) {
            cost += (25 * 30) + ((extraWeight - 25) * 40);
        } else {
            cost += (25 * 30) + (25 * 40) + ((extraWeight - 50) * 45);
        }
        return cost;
    }

    @Override
    public double additionalDistanceCost(double distance) {
        double extraDistance = distance - getBaseDistance();
        if (extraDistance <= 0) return 0.0;

        double cost = 0.0;
        if (extraDistance <= 100) {
            cost += extraDistance * 10;
        } else if (extraDistance <= 500) {
            cost += (100 * 10) + ((extraDistance - 100) * 20);
        } else {
            cost += (100 * 10) + (400 * 20) + ((extraDistance - 500) * 25);
        }
        return cost;
    }
}