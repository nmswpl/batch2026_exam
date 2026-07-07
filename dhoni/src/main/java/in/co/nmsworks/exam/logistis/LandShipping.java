package in.co.nmsworks.exam.logistis;

public class LandShipping implements ShippingMethod {
    private double basePrice;
    private double baseWeight;
    private double baseDistance;
    private double parcel;

    public LandShipping(double basePrice, double baseWeight, double baseDistance, double parcel) {
        this.basePrice = basePrice;
        this.baseWeight = baseWeight;
        this.baseDistance = baseDistance;
        this.parcel = parcel;
    }

    public double getParcel() {
        return parcel;
    }

    public void setParcel(double parcel) {
        this.parcel = parcel;
    }

    @Override
    public double getBasePrice() {
        return basePrice;
    }

    @Override
    public double getBaseWeight() {
        return baseWeight;
    }

    @Override
    public double getBaseDistance() {
        return baseDistance;
    }

    @Override
    public double additionalWeightCost(double weight) {
        if(weight < 5){
            return 10;
        }
        else if (weight > 5 && weight < 15) {
            return 15;
        }
        return 20;
    }

    @Override
    public double additionalDistanceCost(double distance) {
        if(distance < 300){
            return  20;
        }
        else if (distance > 300 && distance < 7000) {
            return 30;
        }
        return 35;
    }

}
