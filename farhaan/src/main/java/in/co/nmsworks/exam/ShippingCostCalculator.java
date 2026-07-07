package in.co.nmsworks.exam;

public class ShippingCostCalculator {
    public static void main(String[] args) {
        ShippingCostCalculator runner = new ShippingCostCalculator();
        ShippingMethod air = new AirShipping();
        ShippingMethod land = new LandShipping();
        Parcel parcel = new Parcel(30, 200);
        runner.calculateTotalCost(air, parcel);
        runner.calculateTotalCost(land, parcel);
    }


    private void calculateTotalCost(ShippingMethod shippingMethod, Parcel parcel) {
        if (shippingMethod instanceof AirShipping) {
            double totalPrice = (shippingMethod.getBasePrice() + shippingMethod.additionalDistanceCost(parcel.getWeight()) + shippingMethod.additionalDistanceCost(parcel.getDistance())) * 2.5;
            System.out.println("The total cost for air shipping is " + totalPrice);
        } else {
            double totalPrice = shippingMethod.getBasePrice() + shippingMethod.additionalDistanceCost(parcel.getWeight()) + shippingMethod.additionalDistanceCost(parcel.getDistance());
            System.out.println("The total cost is " + totalPrice);
        }
    }
}
