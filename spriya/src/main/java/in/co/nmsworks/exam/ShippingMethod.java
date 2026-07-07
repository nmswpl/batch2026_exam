package in.co.nmsworks.exam;

public interface ShippingMethod {
    public double getBasePrice();

    public double getBaseWeight();

    public double getBaseDistance();

    public double additionalWeightCost(double weight);


    public double additionalDistanceCost(double distance);
}


