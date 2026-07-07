package in.co.nmsworks.exam;

class Parcel {
    private double weight;
    private double distance;

    public Parcel(double weight, double distance) {
        this.weight = weight;
        this.distance = distance;
    }

    public double getWeight() {
        return weight; }
    public double getDistance() {
        return distance; }

    public void setWeight(double weight) {
        this.weight = weight;
    }

    public void setDistance(double distance) {
        this.distance = distance;
    }

    @Override
    public String toString() {
        return "Parcel{" +
                "weight=" + weight +
                ", distance=" + distance +
                '}';
    }
}

