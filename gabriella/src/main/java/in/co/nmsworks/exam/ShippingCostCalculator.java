package in.co.nmsworks.exam;

public class ShippingCostCalculator {
    public static void main(String[] args) {
        ShippingCostCalculator shippingCostCalculator = new ShippingCostCalculator();
        ShippingMethod airShipping = new AirShipping();
        ShippingMethod seaShipping = new SeaShipping();
        ShippingMethod landShipping = new LandShipping();
        Parcel parcel = new Parcel(15, 120);
        System.out.println("Quotation for parcel " + "weight: " + parcel.getWeight() + ", distance: " + parcel.getDistance());
        System.out.print("Air shipping: ");
        shippingCostCalculator.calculateTotalCost(airShipping, parcel);
        System.out.print("Sea shipping: ");
        shippingCostCalculator.calculateTotalCost(seaShipping, parcel);
        System.out.print("Land shipping: ");
        shippingCostCalculator.calculateTotalCost(landShipping, parcel);
    }

    public void calculateTotalCost(ShippingMethod shippingMethod, Parcel parcel){
        double weight = parcel.getWeight();
        double distance = parcel.getDistance();
        double cost = 0;
        if (shippingMethod instanceof AirShipping){
            cost = shippingMethod.getBasePrice() + shippingMethod.additionalDistanceCost(distance) + shippingMethod.additionalWeightCost(weight);
            double costWithFuel = cost + 0.025*cost;
            cost = costWithFuel;
        } else if (shippingMethod instanceof LandShipping){
            cost = shippingMethod.getBasePrice() + shippingMethod.additionalDistanceCost(distance) + shippingMethod.additionalWeightCost(weight);
        } else {
            cost = shippingMethod.getBasePrice() + shippingMethod.additionalDistanceCost(distance) + shippingMethod.additionalWeightCost(weight);
        }
        System.out.println("Total cost: " + cost);
    }
}
