package in.co.nmsworks.exam;

public class ShippingCostCalculator {
    public static void main(String[] args) {

        AirShipping airShipping = new AirShipping();
        Parcel parcel = new Parcel(100, 500);
        calculateTotalCost(airShipping, parcel);
    }

    private static void calculateTotalCost(ShippingMethod shippingMethod, Parcel parcel) {
        double totalWeightCost = 0;
        double totalDistanceCost = 0;

        double totalCost = 0;

        if (parcel.getWeight() <= shippingMethod.getBaseWeight()) {
            totalWeightCost += (shippingMethod.getBasePrice()*shippingMethod.getBaseWeight());
        } else {
            totalWeightCost += shippingMethod.additionalWeightCost(parcel.getWeight());
        }

        if (parcel.getDistance() <= shippingMethod.getBaseDistance()) {
            totalDistanceCost += (shippingMethod.getBaseDistance() * shippingMethod.getBasePrice());
        }
        else {
            totalDistanceCost += shippingMethod.additionalDistanceCost(parcel.getDistance());
        }

        totalCost = (totalWeightCost + totalDistanceCost);
    }


}
