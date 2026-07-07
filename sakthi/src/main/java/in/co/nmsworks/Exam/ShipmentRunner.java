package in.co.nmsworks.Exam;

public class ShipmentRunner {

    public static void main(String[] args) {
            Parcel parcel = new Parcel(15.0, 120.0);
            ShippingCostCalculator calculator = new ShippingCostCalculator();
            calculator.generateQuotation(parcel);
        }

}
