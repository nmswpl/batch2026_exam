package in.co.nmsworks.exam.logistics;

public class LandShipping implements ShippingMethod{
    private double basePrice;
    private double baseWeight;
    private double baseDistance;
    private Parcel parcel;

    public LandShipping(double basePrice, double baseWeight, double baseDistance, Parcel parcel) {
        this.basePrice = basePrice;
        this.baseWeight = baseWeight;
        this.baseDistance = baseDistance;
        this.parcel = parcel;
    }

    public LandShipping(double basePrice, double baseWeight, double baseDistance) {
        this.basePrice = basePrice;
        this.baseWeight = baseWeight;
        this.baseDistance = baseDistance;
    }

    @Override
    public double getBasePrice() {
        return this.basePrice;
    }

    @Override
    public double getBaseWeight() {
        return this.baseWeight;
    }

    @Override
    public double getBaseDistance() {
        return this.baseDistance;
    }

    @Override
    public double additionalWeightCost(double weight) {
        double additionalWeight = weight - baseWeight;
        double additionalWeightCost = 0.0;
        if (additionalWeight < 5){
            additionalWeightCost =  additionalWeight * 10;
        } else if (additionalWeight >= 5 && additionalWeight <= 15) {
            additionalWeightCost = additionalWeight * 15;
        }
        else {
            additionalWeightCost = additionalWeight * 20;
        }
        return additionalWeightCost;
    }

    @Override
    public double additionalDistanceCost(double distance) {
        double additionalDistance = distance - baseDistance;
        double additionalDistanceCost = 0.0;
        if (additionalDistance < 300){
            additionalDistanceCost =  additionalDistance * 20;
        } else if (additionalDistance >= 300 && additionalDistance < 700) {
            additionalDistanceCost = additionalDistance * 30;
        }
        else {
            additionalDistanceCost = additionalDistance * 35;
        }
        return additionalDistanceCost;
    }
}
