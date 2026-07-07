package in.co.nmsworks.exam;

public class LandShipping implements Shipping{

    @Override
    public double getBasePrice() {
        return 50;
    }

    @Override
    public double getBaseWeight() {
        return 2;
    }

    @Override
    public double getBaseDistance() {
        return 100;
    }

    @Override
    public double additionalWeightCost(double weight) {

    }

    @Override
    public double additionalDistanceCost(double distance) {

    }
}
