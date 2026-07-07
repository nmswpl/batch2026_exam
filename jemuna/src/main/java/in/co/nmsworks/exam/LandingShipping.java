package in.co.nmsworks.exam;

public class LandingShipping implements ShippingMethod {
    int basePrice =100;
    int baseWeight = 100;
    int parcelWeight;
    int baseDistance;
    int parcelDistance;


    public void setBasePrice(int basePrice) {
        this.basePrice = basePrice;
    }

    @Override
    public double getBasePrice() {
        return basePrice;
    }

    @Override
    public double getBaseWeight() {
        if(parcelWeight<=baseWeight) {
            return baseWeight;
        }
        return baseWeight;
    }

    @Override
    public double getBaseDistance() {
        if(parcelDistance<=baseDistance){
            return baseDistance;
        }
        return baseDistance;
    }

    @Override
    public double additionalWeightCost(double weight) {
        if(weight<=5){
            return weight*10;
        }
        else if(weight>5 && weight<10){
            return weight*15;
        }
        else{
            return weight*20;
        }
    }

    @Override
    public double additionalDistanceCost(double distance) {
        if(distance<=300){
            return distance*20;
        }
        else if(distance>300 && distance<=700){
            return distance*30;
        }
        else{
            return distance*35;
        }
    }
}
