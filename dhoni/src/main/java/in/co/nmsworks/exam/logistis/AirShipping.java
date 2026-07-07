package in.co.nmsworks.exam.logistis;

public class AirShipping implements ShippingMethod{

   private double basePrice;
   private double baseWeight;
   private double baseDistance;
   private double parcel;

    public AirShipping(double basePrice, double baseWeight, double baseDistance, double parcel) {
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
        if(weight < 10){
            return 50;
        }
        else if (weight > 10 && weight < 20) {
            return 60;
        }
        return 70;
    }

    @Override
    public double additionalDistanceCost(double distance) {
        if(distance < 500){
            return  20;
        }
        else if (distance > 500 && distance < 1000) {
            return 40;
        }
        return 50;
    }

}
