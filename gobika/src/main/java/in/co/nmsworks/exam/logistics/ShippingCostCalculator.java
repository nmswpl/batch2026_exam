package in.co.nmsworks.exam.logistics;

public class ShippingCostCalculator {
    public static void main(String[] args) {
        ShippingCostCalculator calculator = new ShippingCostCalculator();
        Parcel parcel = new Parcel(15,120);
        calculator.generateQuotation(parcel);

    }

    private void generateQuotation(Parcel parcel) {
        AirShipping airShipping = new AirShipping(10, 100, 500);
        LandShipping landShipping = new LandShipping(100,2,50);
        SeaShipping seaShipping = new SeaShipping(50,100,10000);

        calculateTotalCost(airShipping, parcel);
        calculateTotalCost(landShipping,parcel);
        calculateTotalCost(seaShipping,parcel);
    }

    private void calculateTotalCost(ShippingMethod shippingMethod, Parcel parcel) {
        double basePrice = shippingMethod.getBasePrice();
        double baseWeight = shippingMethod.getBaseWeight();
        double baseDistance = shippingMethod.getBaseDistance();
        double totalShippingCost = 0.0;
        if (parcel.getWeight() > baseWeight){
            totalShippingCost += shippingMethod.additionalWeightCost(parcel.getWeight()) + (baseWeight * basePrice);
        }
        else {
            totalShippingCost += parcel.getWeight() * basePrice;
        }
        if (parcel.getDistance() > baseDistance){
            totalShippingCost += shippingMethod.additionalDistanceCost(parcel.getDistance()) + (baseDistance * basePrice);
        }
        else {
            totalShippingCost += parcel.getDistance() * basePrice;
        }
        if (shippingMethod instanceof AirShipping){
            totalShippingCost += 2.5 / 100 ;
        }

        System.out.println("Total Cost for Shipping :"+ totalShippingCost);
    }
}
