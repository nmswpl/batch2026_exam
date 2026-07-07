package in.co.nmsworks.exam;

public class ShippingCostCalculator {
    public static void main(String[] args) {
        ShippingMethod land = new LandShipping(100, 50, 2);
        ShippingMethod air = new AirShipping(100, 50, 2);
        ShippingMethod sea = new SeaShipping(100, 50, 2);

        Parcel parcel = new Parcel(15, 120);

        ShippingCostCalculator calc = new ShippingCostCalculator();

        System.out.println("QUOTATION FOR " + parcel);
        System.out.println("LAND SHIPPING = " + calc.calculateTotalShippingCost(land,parcel));
        System.out.println("AIR SHIPPING = " + calc.calculateTotalShippingCost(air,parcel));
        System.out.println("SEA  SHIPPING = " + calc.calculateTotalShippingCost(sea,parcel));
    }

    private double calculateTotalShippingCost(ShippingMethod shippingMethod, Parcel parcel) {
        double basePrice = shippingMethod.getBasePrice();
        double additionalWeightCost = shippingMethod.additionalWeightCost(parcel.getWeight());
        double additionalDistanceCost = shippingMethod.additionalDistanceCost(parcel.getShippingDistance());
//        System.out.println(basePrice + ":" + additionalDistanceCost + " : " + additionalWeightCost);

        return basePrice + additionalDistanceCost + additionalWeightCost;
    }
}
