package in.co.nmsworks.exam;


class AirShipping implements ShippingMethod {
    public double getBasePrice() {
        return 100.0;
    }
    public double getBaseWeight() {
        return 2.0;
    }
    public double getBaseDistance() {
        return 50.0;
    }

    public double additionalWeightCost(double weight) {
        double extra = weight - getBaseWeight();
        if (extra <= 0) return 0;
        double cost = 0;
        if (extra <= 10) {
            cost += extra * 50;
        } else if (extra <= 20) {
            cost += (10 * 50) + ((extra - 10) * 60);
        } else {
            cost += (10 * 50) + (10 * 60) + ((extra - 20) * 70);
        }
        return cost;
    }

    public double additionalDistanceCost(double distance) {
        double extra = distance - getBaseDistance();
        if (extra <= 0) return 0;
        double cost = 0;
        if (extra <= 500) {
            cost += extra * 20;
        } else if (extra <= 1000) {
            cost += (500 * 20) + ((extra - 500) * 40);
        } else {
            cost += (500 * 20) + (500 * 40) + ((extra - 1000) * 50);
        }
        return cost;
    }
}


