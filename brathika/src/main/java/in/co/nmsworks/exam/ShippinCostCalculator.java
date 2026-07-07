package in.co.nmsworks.exam;

public class ShippinCostCalculator {
    public static void main(String[] args) {
        ShippinCostCalculator shippinCostCalculator = new ShippinCostCalculator();
        AirShipping airShipping = new AirShipping();
        LandShipping landShipping = new LandShipping();
        SeaShipping seaShipping = new SeaShipping();
        shippinCostCalculator.calculateTotalCost(airShipping,new Parcel(30,40));
        shippinCostCalculator.generateQuotation(new Parcel(15,120));
    }

    private void generateQuotation(Parcel parcel) {
        System.out.println("Quotation for the Parcel Weight: "+parcel.getWeight()+" Distance: "+parcel.getDistance());
        LandShipping landShipping = new LandShipping();
        System.out.println("LandShipping: ");
        calculateTotalCost(landShipping,parcel);
        System.out.println("Sea Shipping: ");
        SeaShipping seaShipping = new SeaShipping();
        calculateTotalCost(seaShipping,parcel);
        System.out.println("Air Shipping");
        AirShipping airShipping = new AirShipping();
        calculateTotalCost(airShipping,parcel);
    }

    private void calculateTotalCost(ShippingMethod shippingMethod, Parcel parcel) {
        double weight = parcel.getWeight();
        double distance = parcel.getDistance();
        double shippingPrice = shippingMethod.getBasePrice();
        shippingPrice += shippingMethod.additionalWeightCost(weight);
        shippingPrice += shippingMethod.additionalDistanceCost(distance);
        if (shippingMethod.getName().equals("AirShipping")) {
            double additionalCost = 2.5 * shippingMethod.getBasePrice();
            shippingPrice += additionalCost;
        }
        System.out.println("Total shipping Cost for "+shippingMethod.getName()+" is "+shippingPrice);
    }
}
