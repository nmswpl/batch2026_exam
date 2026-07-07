package in.co.nmsworks.exam;

public class ShippingCostCalculator {
    public  static void calculateTotalCost(ShippingMethod shippingMethod, Parcel parcel){
        double basePrice = shippingMethod.getBasePrice();
        double v = shippingMethod.additionalWeightCost(5);
        double v1 = shippingMethod.additionalDistanceCost(100);



    }
    public static void main(String[] args) {
        ShippingCostCalculator shippingCostCalculator = new ShippingCostCalculator();
        Parcel p = new Parcel(3,50);
        ShippingMethod airShipping = new AirShipping();
        calculateTotalCost(airShipping,p);




    }
}
