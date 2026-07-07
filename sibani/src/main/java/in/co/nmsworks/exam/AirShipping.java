package in.co.nmsworks.exam;

public class AirShipping implements ShippingMethod{
    @Override
    public double getBasePrice() {
        return 500.0;
    }

    @Override
    public double getBaseWeight() {
        return 0;
    }

    @Override
    public double getBaseDistance() {
        return 250.0;
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
            if (weight >= 10){
                baseAmount += (weight * 50.0);
            } else if (weight <= 20){
                baseAmount += (weight * 60.0);
            } else {
                baseAmount += (weight * 70.0);
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
            if (distance >= 500){
                baseAmount += (distance * 20.0);
            } else if (distance <= 1000){
                baseAmount += (distance * 40.0);
            } else {
                baseAmount += (distance * 50.0);
            }
        }
        return baseAmount;
    }
}
