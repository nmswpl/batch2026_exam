package in.co.nmsworks.exam;

public class AirShipping implements ShippingMethod{

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
        if(weight < 10){
            return weight*50;
        }
        else if (weight >= 10 && weight < 20){
            return weight * 60;
        }
        else {
            return weight * 70;
        }
    }

    @Override
    public double additionalDistanceCost(double distance) {
        if(distance <= 500){
            return 20 * distance;
        } else if (distance > 500 && distance < 1000) {
            return distance * 40;
        }
        else{
            return distance * 50;
        }
    }
}
