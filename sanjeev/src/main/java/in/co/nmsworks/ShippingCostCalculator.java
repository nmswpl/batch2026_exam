package in.co.nmsworks;

public class ShippingCostCalculator
{

    public static void main(String[] args) {
        Parcel p = null;
        AirShipping as = new AirShipping();
        LandShipping ls = new LandShipping();
        SeaShipping ss = new SeaShipping();


        System.out.println(calculateTotalCost(as,p));
        System.out.println(calculateTotalCost(ls,p));
        System.out.println(calculateTotalCost(ss, p));

    }
    public static int calculateTotalCost(ShippingMethod shippingMethod, Parcel parcel){
        shippingMethod.getBasePrice();
        return 0;
    }
    public static void generateQuotation(Parcel parcel){

    }
}


