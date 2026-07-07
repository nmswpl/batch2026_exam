package in.co.nmsworks.Exam;



public class AirShipping implements ShippingMethod {
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
        if (extraWeight <= 10) {
            cost += extraWeight * 50;
        } else if (extraWeight <= 20) {
            cost += (10 * 50) + ((extraWeight - 10) * 60);
        } else {
            cost += (10 * 50) + (10 * 60) + ((extraWeight - 20) * 70);
        }
        return cost;
    }

    @Override
    public double additionalDistanceCost(double distance) {
        double extraDistance = distance - getBaseDistance();
        if (extraDistance <= 0) return 0.0;

        double cost = 0.0;
        if (extraDistance <= 500) {
            cost += extraDistance * 20;
        } else if (extraDistance <= 1000) {
            cost += (500 * 20) + ((extraDistance - 500) * 40);
        } else {
            cost += (500 * 20) + (500 * 40) + ((extraDistance - 1000) * 50);
        }
        return cost;
    }
}