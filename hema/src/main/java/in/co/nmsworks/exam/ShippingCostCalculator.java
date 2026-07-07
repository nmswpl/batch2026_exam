package in.co.nmsworks.exam;

public class ShippingCostCalculator {
    public static void main(String[] args) {

        ShippingCostCalculator costCalculator = new ShippingCostCalculator();
        ShippingMethod land = new LandShipping();


        costCalculator.calculateTotalCost(new LandShipping(),new Parcel(15,120));
        costCalculator.generateQuotation(new Parcel(15,20));

    }

    public void generateQuotation(Parcel parcel)
    {
        System.out.println("\nQUOTATION:\n");
        System.out.println("Land Shipping:\n");
        calculateTotalCost(new LandShipping(),parcel);
        System.out.println("\nSea Shipping:\n");
        calculateTotalCost(new SeaShipping(),parcel);
        System.out.println("\nAir Shipping:\n");
        calculateTotalCost(new AirShipping(),parcel);
    }
    public void calculateTotalCost(ShippingMethod shippingMethod, Parcel parcel)
    {
        double totalShippingCost = 0;

        double weight = parcel.getWeight();
        double distance = parcel.getDistance();

        double weightCost = 0;
        double distanceCost = 0;

        if( weight > shippingMethod.getBaseWeight() )
        {
            double billableWeight = weight - shippingMethod.getBaseWeight();

            weightCost = shippingMethod.additionalWeightCost(billableWeight);
        }

        if( distance > shippingMethod.getBaseDistance())
        {

            double billableDistance = distance - shippingMethod.getBaseDistance();

            distanceCost = shippingMethod.additionalDistanceCost(billableDistance);
        }


        totalShippingCost = shippingMethod.getBasePrice() + weightCost + distanceCost;

        System.out.println("TOTAL COST = "+ totalShippingCost);

    }
}
