package in.co.nmsworks.exam;

public class AirShipping implements ShippingMethod {
    @Override
    public double getBasePrice() {
        return 100;
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

        if ( weight <= 10 )
            return 50 * weight;
        else if ( weight > 10 && weight < 20)
        {
            return 60 * weight;
        }
        else {
            return 70 * weight;
        }
    }

    @Override
    public double additionalDistanceCost(double distance) {
        if( distance <= 500)
            return 20 * distance;
        else if ( distance> 500 && distance < 1000)
            return 40 * distance;
        return 50 * distance;
    }
}
