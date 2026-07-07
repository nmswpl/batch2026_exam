package in.co.nmsworks.exam;

public class AirShipping implements ShippingMethod{

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
        if(weight<=10){
            return weight*50;
        }
        else if(weight>10 && weight<=20){
            return weight*60;
        }
        else{
            return weight*70;
        }
    }

    @Override
    public double additionalDistanceCost(double distance) {
        if(distance<=10){
            return distance*50;
        }
        else if(distance>10 && distance<=20){
            return distance*60;
        }
        else{
            return distance*70;
        }
    }
}
