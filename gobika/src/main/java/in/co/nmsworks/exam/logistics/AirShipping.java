package in.co.nmsworks.exam.logistics;

public class AirShipping implements ShippingMethod{
    private double basePrice;
    private double baseWeight;
    private double baseDistance;
    private Parcel parcel;

    public AirShipping(double basePrice, double baseWeight, double baseDistance) {
        this.basePrice = basePrice;
        this.baseWeight = baseWeight;
        this.baseDistance = baseDistance;
    }

    public AirShipping(double basePrice, double baseWeight, double baseDistance, Parcel parcel) {
        this.basePrice = basePrice;
        this.baseWeight = baseWeight;
        this.baseDistance = baseDistance;
        this.parcel = parcel;
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
        if (additionalWeight < 10){
            additionalWeightCost =  additionalWeight * 50;
        } else if (additionalWeight >= 10 && additionalWeight <=20) {
            additionalWeightCost = additionalWeight * 60;
        }
        else {
            additionalWeightCost = additionalWeight * 70;
        }
        return additionalWeightCost;
    }

    @Override
    public double additionalDistanceCost(double distance) {
        double additionalDistance = distance - baseDistance;
        double additionalDistanceCost = 0.0;
        if (additionalDistance < 500){
            additionalDistanceCost =  additionalDistance * 20;
        } else if (additionalDistance >= 500 && additionalDistance < 1000) {
            additionalDistanceCost = additionalDistance * 40;
        }
        else {
            additionalDistanceCost = additionalDistance * 50;
        }
        return additionalDistanceCost;
    }
}
