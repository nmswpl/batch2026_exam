package in.co.nmsworks.exam;

public class AirShipping extends Parcel implements ShippingMethod{
    public AirShipping(double weight, double distance) {
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
        if(weight<10)
        {
            return 50;
        }
        else if(weight>10&& weight<20)
        {
            return 60;
        }
        else if(weight>20)
        {
            return 70;
        }
        return 0;
    }

    @Override
    public double additionalDistanceCost(double distance) {
        if(distance<500)
        {
            return 20;
        }
        else if(distance>500&& distance<1000)
        {
            return 40;
        }
        else if(distance>1000)
        {
            return 50;
        }
        return 0;
    }
}
