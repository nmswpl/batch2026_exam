package in.co.nmsworks.exam;

public class AirShipping implements ShippingMethod {


    private double additionalChargeForWeight;
    private double additionalChargeForDistance;

    public double getAdditionalChargeForDistance() {
        return additionalChargeForDistance;
    }

    public void setAdditionalChargeForDistance(double additionalChargeForDistance) {
        this.additionalChargeForDistance = additionalChargeForDistance;
    }

    public double getAdditionalChargeForWeight() {
        return additionalChargeForWeight;
    }

    public void setAdditionalChargeForWeight(double additionalChargeForWeight) {
        this.additionalChargeForWeight = additionalChargeForWeight;
    }

    public AirShipping(double additionalChargeForWeight, double additionalChargeForDistance) {

        this.additionalChargeForWeight = additionalChargeForWeight;
        this.additionalChargeForDistance = additionalChargeForDistance;
    }

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
