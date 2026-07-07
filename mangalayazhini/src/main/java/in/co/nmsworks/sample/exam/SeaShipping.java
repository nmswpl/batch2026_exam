package in.co.nmsworks.sample.exam;

public class SeaShipping implements ShippingMethod {
    @Override
    public double getBasePrice() {
        return 500.0;
    }

    @Override
    public double getBaseWeight() {
        return 5.0;
    }

    @Override
    public double getBaseDistance() {
        return 500.0;
    }

    @Override
    public double additionalWeightCost(double weight) {
        double additionalWeight = weight-getBaseWeight();
        if(additionalWeight <= 25){
            return 30;
        }
        else if(additionalWeight > 25  && additionalWeight < 50){
            return 40;
        }
        else{
            return 45;
        }
    }

    @Override
    public double additionalDistanceCost(double distance) {
        double additionalDistance = distance - getBaseDistance();
        if(additionalDistance < 100){
            return 10;
        }
        else if( additionalDistance > 100 && additionalDistance < 500){
            return 20 ;
        }
        else{
            return 25;
        }
    }
}
