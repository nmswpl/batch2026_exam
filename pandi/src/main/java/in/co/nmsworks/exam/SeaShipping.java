package in.co.nmsworks.exam;

public class SeaShipping extends Parcel implements ShippingMethod{
    public SeaShipping(double weight, double distance) {
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
        if(weight<25)
        {
            return 30;
        }
        else if(weight>25&& weight<50)
        {
            return 40;
        }
        else if(weight>50)
        {
            return 45;
        }
        return 0;
    }

    @Override
    public double additionalDistanceCost(double distance) {
        if(distance<100)
        {
            return 10;
        }
        else if(distance>100&& distance<500)
        {
            return 20;
        }
        else if(distance>500)
        {
            return 25;
        }
        return 0;
    }
}
