package in.co.nmsworks.exam;

public class ShippingCostCalculator {
    public static void main(String[] args) {
        ShippingCostCalculator shippingCostCalculator=new ShippingCostCalculator();
        Parcel parcel =new Parcel();
        AirShipping airShipping=new AirShipping(100,200);
        shippingCostCalculator.calculateTotalCost(airShipping,parcel);

        shippingCostCalculator.generateQuoatation();
    }

    private void generateQuoatation() {


    }

    private void calculateTotalCost(ShippingMethod shippingMethod,Parcel parcel) {
        double billableWeight=parcel.getWeight()- shippingMethod.getBaseDistance();
        double distanceCost=shippingMethod.additionalDistanceCost(billableWeight);
        System.out.println(billableWeight+" "+distanceCost);
    }
}
