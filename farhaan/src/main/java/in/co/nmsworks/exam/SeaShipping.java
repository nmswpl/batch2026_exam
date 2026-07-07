package in.co.nmsworks.exam;

public class SeaShipping implements ShippingMethod {
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
        if(weight < 25){
            return weight*30;
        }
        else if (weight >= 25 && weight < 50){
            return weight * 40;
        }
        else {
            return weight * 45;
        }
    }

    @Override
    public double additionalDistanceCost(double distance) {
        if(distance <= 100){
            return 10 * distance;
        } else if (distance > 100 && distance < 500) {
            return distance * 20;
        }
        else{
            return distance * 25;
        }
    }
}
