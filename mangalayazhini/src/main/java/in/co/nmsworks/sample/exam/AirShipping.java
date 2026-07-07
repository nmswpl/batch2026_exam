package in.co.nmsworks.sample.exam;

public class AirShipping implements ShippingMethod {
    @Override
    public double getBasePrice() {
        return 1000.0;
    }

    @Override
    public double getBaseWeight() {
        return 5.0;
    }

    @Override
    public double getBaseDistance() {
        return 1500.0;
    }

    @Override
    public double additionalWeightCost(double weight) {
        double additionalWeight = weight-getBaseWeight();
        if(additionalWeight <= 10){
            return 50;
        }
        else if(additionalWeight > 10 && additionalWeight < 20){
            return 60;
        }
        else{
            return 70;
        }

    }

    @Override
    public double additionalDistanceCost(double distance) {
        double additionalDistance = distance - getBaseDistance();
        if(additionalDistance < 500){
            return 20;
        }
        else if( additionalDistance > 500 && additionalDistance < 1000){
            return 40 ;
        }
        else{
            return 50;
        }

    }
}
