package in.co.nmsworks.exam;

public class LandShipping extends Parcel implements ShippingMethod {
    public LandShipping(double weight, double distance) {
        super(weight, distance);
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
        if(weight<5)
        {
            return 10;
        }
        else if(weight>5&& weight<15)
        {
            return 15;
        }
        else if(weight>15)
        {
            return 25;
        }
        return 0;
    }

    @Override
    public double additionalDistanceCost(double distance) {
        if(distance<300)
        {
            return 20;
        }
        else if(distance>300&& distance<700)
        {
            return 30;
        }
        else if(distance>700)
        {
            return 35;
        }
        return 0;
    }
}
