package in.co.nmsworks.exam;

public class ShippingCostCalculator {
    public static void main(String[] args) {
        ShippingCostCalculator calculator = new ShippingCostCalculator();
        Parcel parcel = new Parcel(15.0, 120.0);
        calculator.generateQuotation(parcel);
    }

    private void generateQuotation(Parcel parcel) {
        System.out.println("Quotation for Parcel (Weight : " + parcel.getWeight() + " Distance : " + parcel.getDistance());
        AirShipping airShipping = new AirShipping();
        double airShippingCost = calculateTotalCost(airShipping,parcel);
        System.out.println("Air Shipping : " + airShippingCost);

        LandShipping landShipping = new LandShipping();
        double landShippingCost = calculateTotalCost(landShipping,parcel);
        System.out.println("Land Shipping : " + landShippingCost );

        SeaShipping seaShipping = new SeaShipping();
        double seaShippingCost = calculateTotalCost(seaShipping,parcel);
        System.out.println("Sea Shipping : " + seaShippingCost);
    }

    private double calculateTotalCost(ShippingMethod shippingMethod, Parcel parcel) {
        if (shippingMethod instanceof AirShipping) {
            double shippingCost = shippingMethod.additionalDistanceCost(parcel.getDistance()) + shippingMethod.additionalWeightCost(parcel.getWeight());
            double totalCost = (2.5 * shippingCost) / 100;
            return totalCost;
        } else {
            double shippingCost = shippingMethod.additionalDistanceCost(parcel.getDistance()) + shippingMethod.additionalWeightCost(parcel.getWeight());
            return shippingCost;
        }
    }
}
