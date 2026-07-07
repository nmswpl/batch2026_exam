package in.co.nmsworks.exam;

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
        System.out.println("Quotation for Parcel (Weight: "+ parcel.getWeight()+ " kg " +"\n" + "Distance: "+parcel.getDistance());

        ShippingMethod land = new LandShipping();
        ShippingMethod air = new AirShipping();
        ShippingMethod sea = new SeaShipping();

        System.out.println("Land Shipping: "+calculateTotalCost(land, parcel));
        System.out.println("Air Shipping : "+ calculateTotalCost(air, parcel));
        System.out.println("Sea Shipping : "+ calculateTotalCost(sea, parcel));
    }

    public static void main(String[] args) {
        ShippingCostCalculator calculator = new ShippingCostCalculator();
        Parcel parcel = new Parcel(15.0, 120.0);
        calculator.generateQuotation(parcel);
    }
}
