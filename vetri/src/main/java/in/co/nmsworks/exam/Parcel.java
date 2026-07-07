package in.co.nmsworks.exam;

import java.util.Objects;

public class Parcel {
    private String Weight;
    private String Distance;

    public Parcel() {
    }

    public Parcel(String weight, String distance) {
        Weight = weight;
        Distance = distance;
    }

    public String getWeight() {
        return Weight;
    }

    public void setWeight(String weight) {
        Weight = weight;
    }

    public String getDistance() {
        return Distance;
    }

    public void setDistance(String distance) {
        Distance = distance;
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        Parcel parcel = (Parcel) o;
        return Objects.equals(Weight, parcel.Weight) && Objects.equals(Distance, parcel.Distance);
    }

    @Override
    public int hashCode() {
        return Objects.hash(Weight, Distance);
    }

    @Override
    public String toString() {
        return "Parcel{" +
                "Weight='" + Weight + '\'' +
                ", Distance='" + Distance + '\'' +
                '}';
    }
}
