package in.co.nmsworks.exam;

public class LandShipping implements ShippingMethod {

    @Override
    public double getBasePrice() {
        return 50;
    }

    @Override
    public double getBaseWeight() {
        return 0;
    }

    @Override
    public double getBaseDistance() {
        return 0;
    }

    @Override
    public double additionalWeightCost(double weight) {
        if(weight <= 5){
            return weight*10;
        }
        else if (weight > 5 && weight < 15){
            return weight * 15;
        }
        else {
            return weight * 20;
        }
    }

    @Override
    public double additionalDistanceCost(double distance) {
        if(distance <= 300){
            return 20 * distance;
        } else if (distance > 300 && distance < 700) {
            return distance * 30;
        }
        else{
            return distance * 35;
        }
    }
}
