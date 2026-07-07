package in.co.nmsworks.sample.exam;

public class Parcel {
    private Double weight;
    private Double distance;

    public Parcel(Double weight, Double distance) {
        this.weight = weight;
        this.distance = distance;
    }


    public Double getWeight() {
        return weight;
    }

    public void setWeight(Double weight) {
        this.weight = weight;
    }

    public Double getDistance() {
        return distance;
    }

    public void setDistance(Double distance) {
        this.distance = distance;
    }
}
