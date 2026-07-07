package in.co.nmsworks.Exam;
public class LandShipping implements ShippingMethod {
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
        if (extraWeight <= 5) {
            cost += extraWeight * 10;
        } else if (extraWeight <= 15) {
            cost += (5 * 10) + ((extraWeight - 5) * 15);
        } else {
            cost += (5 * 10) + (10 * 15) + ((extraWeight - 15) * 20);
        }
        return cost;
    }

    @Override
    public double additionalDistanceCost(double distance) {
        double extraDistance = distance - getBaseDistance();
        if (extraDistance <= 0) return 0.0;

        double cost = 0.0;
        if (extraDistance <= 300) {
            cost += extraDistance * 20;
        } else if (extraDistance <= 700) {
            cost += (300 * 20) + ((extraDistance - 300) * 30);
        } else {
            cost += (300 * 20) + (400 * 30) + ((extraDistance - 700) * 35);
        }
        return cost;
    }
}