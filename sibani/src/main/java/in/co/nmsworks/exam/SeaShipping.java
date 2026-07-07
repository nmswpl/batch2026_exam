package in.co.nmsworks.exam;

public class SeaShipping implements ShippingMethod{
    @Override
    public double getBasePrice() {
        return 250.0;
    }

    @Override
    public double getBaseWeight() {
        return 0;
    }

    @Override
    public double getBaseDistance() {
        return 50.0;
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
            if (weight >= 25){
                baseAmount += (weight * 30.0);
            } else if (weight <= 50){
                baseAmount += (weight * 40.0);
            } else {
                baseAmount += (weight * 45.0);
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
            if (distance >= 100){
                baseAmount += (distance * 10.0);
            } else if (distance <= 500){
                baseAmount += (distance * 20.0);
            } else {
                baseAmount += (distance * 25.0);
            }
        }
        return baseAmount;
    }
}
