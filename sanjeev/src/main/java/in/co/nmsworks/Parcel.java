package in.co.nmsworks;

import java.util.Arrays;

public class Parcel {
    int weigth;
    int distance;
    private int[] latLongTo;

    public Parcel(int weigth, int distance) {
        this.weigth = weigth;
        this.distance = distance;
    }

    public Parcel() {

    }

    public int getWeigth() {
        return weigth;
    }

    public int getDistance() {
        return distance;
    }

    public int[] getLatLongTo() {
        return latLongTo;
    }

    public void setLatLongTo(int[] latLongTo) {
        this.latLongTo = latLongTo;
    }

    @Override
    public String toString() {
        return "Parcel{" +
                "weigth=" + weigth +
                ", distance=" + distance +
                ", latLongTo=" + Arrays.toString(latLongTo) +
                '}';
    }
}
