package in.co.nmsworks.exam;

public class AirShipping implements ShippingMethod{
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
            if(weight<10){
                return weight*50;
            } else if (weight>10 && weight<20) {
                return weight*60;
            }
            else if(weight>20){
                return weight*70;
            }
        }
        return getBaseWeight();
    }

    @Override
    public double additionalDistanceCost(double distance) {
        if(distance>getBaseWeight()){
            if(distance<500){
                return distance*50;
            } else if (distance>500 && distance<1000) {
                return distance*60;
            }
            else if(distance>1000){
                return distance*70;
            }
        }
        return getBasePrice();
    }
}
