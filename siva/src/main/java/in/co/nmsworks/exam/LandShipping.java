package in.co.nmsworks.exam;

public class LandShipping implements ShippingMethod{


    @Override
    public double getBasePrice() {
        return 30;
    }

    @Override
    public double getBaseWeight() {
        return 12;
    }

    @Override
    public double getBaseDistance() {
        return 250;
    }

    @Override
    public double additionalWeightCost(double weight) {
        if (weight < 5)
            return 10 * weight;
        else if (weight <= 15)
            return 15 * weight;
        else
            return 20 * weight;
    }

    @Override
    public double additionalDistanceCost(double distance) {
        if (distance < 300)
            return 20 * distance;
        else if (distance <= 700)
            return 30 * distance;
        else
            return 35 * distance;
    }
}
