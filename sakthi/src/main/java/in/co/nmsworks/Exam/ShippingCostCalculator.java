package in.co.nmsworks.Exam;
public class ShippingCostCalculator {

    public double calculateTotalCost(ShippingMethod shippingMethod, Parcel parcel) {
        double basePrice = shippingMethod.getBasePrice();
        double weightCost = shippingMethod.additionalWeightCost(parcel.getWeight());
        double distanceCost = shippingMethod.additionalDistanceCost(parcel.getDistance());

        double total = basePrice + weightCost + distanceCost;


        if (shippingMethod instanceof AirShipping) {
            total += total * 0.025;
        }

        return total;
    }

    public void generateQuotation(Parcel parcel) {
        ShippingMethod land = new LandShipping();
        ShippingMethod air = new AirShipping();
        ShippingMethod sea = new SeaShipping();

        System.out.printf("Quotation for Parcel (Weight: %.2f kg, Distance: %.2f km):%n",
                parcel.getWeight(), parcel.getDistance());
        System.out.printf("Land Shipping: Rs %.2f%n", calculateTotalCost(land, parcel));
        System.out.printf("Air Shipping : Rs %.2f%n", calculateTotalCost(air, parcel));
        System.out.printf("Sea Shipping: Rs %.2f%n", calculateTotalCost(sea, parcel));
    }
}