package in.co.nmsworks.exam;

public class LandShipping implements ShippingMethod{

    public LandShipping() {
    }

    @Override
    public double getBasePrice() {
        return 100;
    }

    @Override
    public double getBaseWeight() {
        return 2;
    }

    @Override
    public double getBaseDistance() {
        return 50;
    }

    @Override
    public double additionalWeightCost(double weight) {
        if( weight <= 5)
            return 10 * weight;
        else if ( weight > 5 && weight < 15) {
            return 15 * weight;
        }
        return 20 * weight;
    }

    @Override
    public double additionalDistanceCost(double distance) {
        return 0;
    }
}
