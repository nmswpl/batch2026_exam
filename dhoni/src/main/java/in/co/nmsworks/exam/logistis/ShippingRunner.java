package in.co.nmsworks.exam.logistis;

public class ShippingRunner {
    public static void main(String[] args) {

        ShippingRunner runner = new ShippingRunner();
        ShippingMethod air = new AirShipping(100,2,50,15);
        ShippingMethod land = new LandShipping(100,2,50,15);
        ShippingMethod sea = new SeaShipping(100,3, 50,15);

        runner.calculateTotalCost(air);
    }

    public void calculateTotalCost(ShippingMethod shipping){

        System.out.println("total cost : " + (shipping.getBaseDistance() * shipping.getBaseWeight() * shipping.getBasePrice()));

    }

}
