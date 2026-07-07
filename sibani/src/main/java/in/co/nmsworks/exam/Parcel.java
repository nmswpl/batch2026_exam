package in.co.nmsworks.exam;

public class Parcel {
    private Double weight;
    private Double Distance;

    public Parcel(Double weight, Double distance) {
        this.weight = weight;
        Distance = distance;
    }

    public Double getWeight() {
        return weight;
    }

    public void setWeight(Double weight) {
        this.weight = weight;
    }

    public Double getDistance() {
        return Distance;
    }

    public void setDistance(Double distance) {
        Distance = distance;
    }

    @Override
    public String toString() {
        return "Parcel{" +
                "weight=" + weight +
                ", Distance=" + Distance +
                '}';
    }
}
