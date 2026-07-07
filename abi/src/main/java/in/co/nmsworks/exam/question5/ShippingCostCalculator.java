package in.co.nmsworks.exam.question5;

public class ShippingCostCalculator {

    public double calculateTotalCost(ShippingMethod shippingMethod, Parcel parcel) {

        double total = shippingMethod.getBasePrice();

        total += shippingMethod.additionalWeightCost(parcel.getWeight());

        total += shippingMethod.additionalDistanceCost(parcel.getDistance());

        if (shippingMethod instanceof AirShipping) {
            total = total + (total * 0.025);
        }

        return total;
    }

    public void generateQuotation(Parcel parcel) {

        ShippingMethod land = new LandShipping();
        ShippingMethod air = new AirShipping();
        ShippingMethod sea = new SeaShipping();

        System.out.println("Quotation for Parcel (Weight: "
                + String.format("%.2f", parcel.getWeight())
                + " kg, Distance: "
                + String.format("%.2f", parcel.getDistance())
                + " km)");

        System.out.printf("Land Shipping : Rs %.2f\n",
                calculateTotalCost(land, parcel));

        System.out.printf("Air Shipping  : Rs %.2f\n",
                calculateTotalCost(air, parcel));

        System.out.printf("Sea Shipping  : Rs %.2f\n",
                calculateTotalCost(sea, parcel));
    }
}
