package in.co.nmsworks.exam;

public class SeaShipping implements ShippingMethod{
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
        int totalCost = 0;
        if(weight<=25){
            totalCost =(int) weight*30;
        }
        else if(weight>25 && weight<50){
            totalCost =(int) weight*40;
        }
        else{
            totalCost =(int) weight*45;
        }
        return totalCost;
    }

    @Override
    public double additionalDistanceCost(double distance) {
        if(distance<=100){
            return distance*10;
        }
        else if(distance>100 && distance<=500){
            return distance*20;
        }
        else{
            return distance*25;
        }
    }
}

