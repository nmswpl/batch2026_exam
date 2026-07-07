package in.co.nmsworks.exam.question5;
public class SeaShipping implements ShippingMethod {

    public double getBasePrice() {
        return 100;
    }

    public double getBaseWeight() {
        return 2;
    }

    public double getBaseDistance() {
        return 50;
    }

    public double additionalWeightCost(double weight) {

        double extra = weight - getBaseWeight();

        if (extra <= 0)
            return 0;

        double cost = 0;

        if (extra <= 25) {
            cost = extra * 30;
        } else if (extra <= 50) {
            cost = (25 * 30) + ((extra - 25) * 40);
        } else {
            cost = (25 * 30) + (25 * 40) + ((extra - 50) * 45);
        }

        return cost;
    }

    public double additionalDistanceCost(double distance) {

        double extra = distance - getBaseDistance();

        if (extra <= 0)
            return 0;

        double cost = 0;

        if (extra <= 100) {
            cost = extra * 10;
        } else if (extra <= 500) {
            cost = (100 * 10) + ((extra - 100) * 20);
        } else {
            cost = (100 * 10) + (400 * 20) + ((extra - 500) * 25);
        }

        return cost;
    }
}