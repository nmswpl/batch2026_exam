package in.co.nmsworks.exam;

public class Parcel{
    private double distance;
    private double weight;

    public Parcel() {
    }

    public Parcel(double distance, double weight) {
        this.distance = distance;
        this.weight = weight;
    }

    public double getDistance() {
        return distance;
    }

    public void setDistance(double distance) {
        this.distance = distance;
    }

    public double getWeight() {
        return weight;
    }

    public void setWeight(double weight) {
        this.weight = weight;
    }

    @Override
    public String toString() {
        return "Parcel{" +
                "distance=" + distance +
                ", weight=" + weight +
                '}';
    }
}
