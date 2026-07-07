package in.co.nmsworks.sample.exam;

public class LandShipping implements ShippingMethod {
    @Override
    public double getBasePrice() {
        return 100.0;
    }

    @Override
    public double getBaseWeight() {
        return 2.0;
    }

    @Override
    public double getBaseDistance() {
        return 50.0;
    }

    @Override
    public double additionalWeightCost(double weight) {
        double additionalWeight = weight-getBaseWeight();
        if(additionalWeight <= 5){
            return 10;
        }
        else if(additionalWeight > 5  && additionalWeight < 15){
            return 15;
        }
        else{
            return 20;
        }
    }

    @Override
    public double additionalDistanceCost(double distance) {
        double additionalDistance = distance - getBaseDistance();
        if(additionalDistance < 300){
            return 20;
        }
        else if( additionalDistance > 300 && additionalDistance < 700){
            return 30 ;
        }
        else{
            return 35;
        }
    }
}
