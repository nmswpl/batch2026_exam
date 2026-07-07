package in.co.nmsworks.exam;

 class LandShipping implements ShippingMethod{
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
        if (extra <= 0){
            return 0;
        }
        double cost = 0;
        if (extra <= 5) {
            cost += extra * 10;
        } else if (extra <= 15) {
            cost += (5 * 10) + ((extra - 5) * 15);
        } else {
            cost += (5 * 10) + (10 * 15) + ((extra - 15) * 20);
        }
        return cost;
    }

    public double additionalDistanceCost(double distance) {
        double extra = distance - getBaseDistance();
        if (extra <= 0) return 0;
        double cost = 0;
        if (extra <= 300) {
            cost += extra * 20;
        } else if (extra <= 700) {
            cost += (300 * 20) + ((extra - 300) * 30);
        } else {
            cost += (300 * 20) + (400 * 30) + ((extra - 700) * 35);
        }
        return cost;
    }
}


