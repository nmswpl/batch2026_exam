package in.co.nmsworks.exam;

public class ShippingCostCalculator {
    public static void main(String[] args) {
        ShippingCostCalculator costCalculator = new ShippingCostCalculator();
        Parcel parcel = new Parcel(15,120);
        AirShipping airShipping = new AirShipping();
        SeaShipping seaShipping = new SeaShipping();
        LandShipping landShipping = new LandShipping();
        costCalculator.calculateTotalCost(airShipping, parcel);

    }

    private void calculateTotalCost(AirShipping shipping, Parcel parcel) {
    }
}
