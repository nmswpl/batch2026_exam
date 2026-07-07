package in.co.nmsworks.exam;

public class SeaShipping implements ShippingMethod{

    @Override
    public double getBasePrice() {
        return 60;
    }

    @Override
    public double getBaseWeight() {
        return 30;
    }

    @Override
    public double getBaseDistance() {
        return 140;
    }

    @Override
    public double additionalWeightCost(double weight) {
        if (weight < 25)
            return 30 * weight;
        else if (weight <= 50)
            return 40 * weight;
        else
            return 45 * weight;
    }

    @Override
    public double additionalDistanceCost(double distance) {
        if (distance < 100)
            return 10 * distance;
        else if (distance <= 500)
            return 20 * distance;
        else
            return 25 * distance;
    }
}
