package in.co.nmsworks.exam;

public class ShippingCostCalculator {

    public static void main(String[] args) {
        ShippingMethod airShipping = new AirShipping();
        ShippingMethod landingShipping = new LandingShipping();
        ShippingMethod seaShipping = new SeaShipping();
        Parcel parcel = new Parcel();
        ShippingCostCalculator shippingCostCalculator = new ShippingCostCalculator();
        System.out.println("Quotation for Parcel (Weight: 15.00 kg, Distance: 120.00 km):");
        shippingCostCalculator.calculateTotalCost(airShipping,parcel);
        shippingCostCalculator.calculateTotalCost(landingShipping,parcel);
        shippingCostCalculator.calculateTotalCost(seaShipping,parcel);

    }

    public void calculateTotalCost(ShippingMethod shippingMethod, Parcel parcel){
        int totalShippingCharge = (int) (shippingMethod.getBasePrice()+shippingMethod.additionalDistanceCost(parcel.distance)+shippingMethod.additionalWeightCost(parcel.weight));
        System.out.println("Total Shipping Charge : "+totalShippingCharge);
    }


}
