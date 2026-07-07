package in.co.nmsworks.exam.logistics;

public class SeaShipping implements ShippingMethod{
    private double basePrice;
    private double baseWeight;
    private double baseDistance;
    private Parcel parcel;

    public SeaShipping(double basePrice, double baseWeight, double baseDistance, Parcel parcel) {
        this.basePrice = basePrice;
        this.baseWeight = baseWeight;
        this.baseDistance = baseDistance;
        this.parcel = parcel;
    }

    public SeaShipping(double basePrice, double baseWeight, double baseDistance) {
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
        if (additionalWeight < 25){
            additionalWeightCost =  additionalWeight * 30;
        } else if (additionalWeight >= 25 && additionalWeight <= 50) {
            additionalWeightCost = additionalWeight * 40;
        }
        else {
            additionalWeightCost = additionalWeight * 45;
        }
        return additionalWeightCost;
    }

    @Override
    public double additionalDistanceCost(double distance) {
        double additionalDistance = distance - baseDistance;
        double additionalDistanceCost = 0.0;
        if (additionalDistance < 100){
            additionalDistanceCost =  additionalDistance * 10;
        } else if (additionalDistance >= 100 && additionalDistance < 500) {
            additionalDistanceCost = additionalDistance * 20;
        }
        else {
            additionalDistanceCost = additionalDistance * 25;
        }
        return additionalDistanceCost;
    }
}
