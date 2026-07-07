package in.co.nmsworks.exam;

public class LandShipping implements ShippingMethod{
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
        if (weight <= 5){
            return 10 * weight;
        } else if (weight >= 5 && weight <= 100) {
            return 15* weight;
            
        } else if (weight >= 15) {
            return 20 * weight;

        }
        return 0;
    }

    @Override
    public double additionalDistanceCost(double distance) {
        return 0;
    }
}
