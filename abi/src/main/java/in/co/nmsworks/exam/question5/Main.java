package in.co.nmsworks.exam.question5;

public class Main {

    public static void main(String[] args) {

        Parcel parcel = new Parcel(15, 120);

        ShippingCostCalculator calculator = new ShippingCostCalculator();

        calculator.generateQuotation(parcel);
    }
}
