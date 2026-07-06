package in.co.nmsworks;

public class AirShipping implements ShippingMethod{
    @Override
    public double getBasePrice() {
        return 0;
    }

    @Override
    public double getBaseWeight() {
        return 0;
    }

    @Override
    public double getBaseDistance() {
        return 0;
    }

    @Override
    public double additionalWeightCost(double weight) {
        return 0;
    }

    @Override
    public double additionalDistanceCost(double distance) {
        return 0;
    }
}
