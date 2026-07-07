package in.co.nmsworks.exam;

public class ShippingCostCalculator {

    public static void main(String[] args) {
        ShippingCostCalculator shippingCostCalculator = new ShippingCostCalculator();
        shippingCostCalculator.run();
    }

    private void run() {
        generateQuotation(new Parcel(120,15));
    }

    public double calculateTotalCost(ShippingMethod shippingMethod, Parcel parcel) {
        double weight = parcel.getWeight();
        double distance = parcel.getDistance();
        double baseWeight = shippingMethod.getBaseWeight();
        double baseDistance = shippingMethod.getBaseDistance();
        double basePrice = shippingMethod.getBasePrice();
        double totalCost = basePrice, extraWeight = 0, extraDistance = 0;
        if (baseDistance < distance)
            extraDistance = shippingMethod.additionalDistanceCost(distance - baseDistance);
        if (baseWeight < weight)
            extraWeight = shippingMethod.additionalWeightCost(weight - baseWeight);
        totalCost += (extraDistance + extraWeight);
        if (shippingMethod instanceof AirShipping)
            totalCost += ((totalCost * 2.5)/100);
        return totalCost;
    }
    public void generateQuotation(Parcel parcel) {
        System.out.println("Quotation for Parcel (Weight: "+parcel.getWeight()+" kg, Distance: "+parcel.getDistance()+" km):");
        System.out.println("Land Shipping : Rs "+calculateTotalCost(new LandShipping(),parcel));
        System.out.println("Air Shipping : Rs "+calculateTotalCost(new AirShipping(),parcel));
        System.out.println("Sea Shipping : Rs "+calculateTotalCost(new SeaShipping(),parcel));
    }
}
