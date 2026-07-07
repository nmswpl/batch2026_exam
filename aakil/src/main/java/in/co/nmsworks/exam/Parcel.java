package in.co.nmsworks.exam;

public class Parcel {
    private int weight;
    private int shippingDistance;

    public Parcel(int weight, int shippingDistance) {
        this.weight = weight;
        this.shippingDistance = shippingDistance;
    }

    public int getWeight() {
        return weight;
    }

    public void setWeight(int weight) {
        this.weight = weight;
    }

    public int getShippingDistance() {
        return shippingDistance;
    }

    public void setShippingDistance(int shippingDistance) {
        this.shippingDistance = shippingDistance;
    }

    @Override
    public String toString() {
        return "Parcel{" +
                "weight=" + getWeight() +
                ", shippingDistance=" + getShippingDistance() +
                '}';
    }
}
