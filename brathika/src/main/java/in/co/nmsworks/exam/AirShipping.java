package in.co.nmsworks.exam;

public class AirShipping implements ShippingMethod{
    @Override
    public double getBasePrice() {
        return 400.0;
    }
    public String getName(){
        return "AirShipping";
    }

    @Override
    public double getBaseWeight() {
        return 5.0;
    }

    @Override
    public double getBaseDistance() {
        return 10.0;
    }

    @Override
    public double additionalWeightCost(double weight) {
        double additionalCost = 0.0;
        if (weight > getBaseWeight()) {
            double additionalWeight = weight - getBaseWeight();
            while (additionalWeight > 0){
                if (additionalWeight < 10) {
                    additionalCost += weight * 50;
                    additionalWeight -= weight;
                } else if (additionalWeight > 10 && additionalWeight < 20) {
                    additionalCost += weight * 60;
                    additionalWeight -= weight;
                }
                else {
                    additionalCost += weight * 70;
                    additionalWeight -= weight;
                }
            }
            return additionalCost;
        }
        return 0;

    }

    @Override
    public double additionalDistanceCost(double distance) {
        double additionalCost = 0.0;
        if (distance > getBaseDistance()) {
            double additionalDistance = distance - getBaseDistance();
            while (additionalDistance > 0) {
                if (additionalDistance < 500) {
                    additionalCost += distance * 20;
                    additionalDistance -= distance;
                } else if (additionalDistance > 500 && additionalDistance < 1000) {
                    additionalCost += distance * 40;
                    additionalDistance -= distance;
                }
                else {
                    additionalCost += distance * 50;
                    additionalDistance -= distance;
                }
            }
            return additionalCost;
        }

        return 0.0;
    }
}
