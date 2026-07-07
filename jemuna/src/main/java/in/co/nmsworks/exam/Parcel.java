package in.co.nmsworks.exam;

public class Parcel {
    int weight;
    int distance;

    public Parcel(int weight, int distance) {
        this.weight = weight;
        this.distance = distance;
    }

    public Parcel() {
    }

    public static void main(String[] args) {
        Parcel parcel = new Parcel(15,120);
    }
    public int getWeight() {
        return weight;
    }

    public void setWeight(int weight) {
        this.weight = weight;
    }

    public int getDistance() {
        return distance;
    }

    public void setDistance(int distance) {
        this.distance = distance;
    }
}
