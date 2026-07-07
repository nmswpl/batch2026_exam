package in.co.nmsworks.exam;

public class LandShipping implements ShippingMethod{
    @Override
    public double getBasePrice() {
        return 100.0;
    }

    @Override
    public double getBaseWeight() {
        return 0;
    }

    @Override
    public double getBaseDistance() {
        return 150.00;
    }

    @Override
    public double additionalWeightCost(double weight) {
        double baseWeight = getBaseWeight();
        double baseAmount = getBasePrice();
        if (weight < baseWeight){
            System.out.println("no additional charge required");
            return getBasePrice();
        }
        else {
            if (weight >= 5){
                baseAmount += (weight * 10.0);
            } else if (weight <= 15){
                baseAmount += (weight * 15.0);
            } else {
                baseAmount += (weight * 20.0);
            }
        }
        return baseAmount;
    }

    @Override
    public double additionalDistanceCost(double distance) {
        double baseDistance = getBaseDistance();
        double baseAmount = getBasePrice();
        if (distance < baseDistance){
            System.out.println("no additional charge required");
            return getBasePrice();
        }
        else {
            if (distance >= 300){
                baseAmount += (distance * 20.0);
            } else if (distance <= 700){
                baseAmount += (distance * 30.0);
            } else {
                baseAmount += (distance * 35.0);
            }
        }
        return baseAmount;
    }

}
