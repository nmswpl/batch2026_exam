package in.co.nmsworks.exam.logistis;

public class SeaShipping implements ShippingMethod{
    private double basePrice;
    private double baseWeight;
    private double baseDistance;
    private double parcel;

    public SeaShipping(double basePrice, double baseWeight, double baseDistance, double parcel) {
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
        if(weight < 25){
            return 30;
        }
        else if (weight > 25 && weight < 50) {
            return 40;
        }
        return 45;
    }

    @Override
    public double additionalDistanceCost(double distance) {
        if(distance < 100){
            return  10;
        }
        else if (distance > 100 && distance < 5000) {
            return 20;
        }
        return 25;
    }

}
