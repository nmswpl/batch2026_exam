package in.co.nmsworks.exam;

public class LandShipping implements ShippingMethod{
    @Override
    public double getBasePrice() {
        return 0;
    }

    @Override
    public double getBaseWeight() {
        return 5;
    }

    @Override
    public double getBaseDistance() {
        return 50;
    }

    @Override
    public double additionalWeightCost(double weight) {
        if(weight>getBaseWeight()){
            if(weight<5){
                return weight*10;
            } else if (weight>5 && weight<15) {
                return weight*15;
            }
            else if(weight>15){
                return weight*20;
            }
        }
        return getBaseWeight();
    }

    @Override
    public double additionalDistanceCost(double distance) {
        if(distance>getBaseWeight()){
            if(distance<300){
                return distance*20;
            } else if (distance>300 && distance<700) {
                return distance*30;
            }
            else if(distance>700){
                return distance*35;
            }
        }
        return getBasePrice();
    }
}
