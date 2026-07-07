package in.co.nmsworks.sample.exam;

public class ShippingCostCalculator {
    public static void main(String[] args) {

        ShippingCostCalculator costCalculator = new ShippingCostCalculator();
        Parcel p1 = new Parcel(15.0,120.0);

        ShippingMethod landShipping = new LandShipping();
        Double amount = costCalculator.calculateTotalCost(landShipping, p1);
        System.out.println("The total cost of parcel in landshipping : " + amount);
    }


    public double calculateTotalCost(ShippingMethod shippingMethod, Parcel parcel){

        double baseWeight = shippingMethod.getBaseWeight();
        double baseDistance = shippingMethod.getBaseDistance();

        double parcelWeight = parcel.getWeight();
        double parcelDistance = parcel.getDistance();

        double totalCost = 0 ;

        if(parcelWeight > baseWeight){
            double diffWeight = parcelWeight - baseWeight;
        }
        if(parcelDistance > baseDistance){

        }

        double distanceCost = shippingMethod.additionalDistanceCost(parcel.getDistance()) ;
        double weightCost = shippingMethod.additionalWeightCost(parcel.getWeight());

        return totalCost;
    }
}
