package in.co.nmsworks.exam;

class AirShipping implements Shipping {

    @Override
    public double getBasePrice() {
        return 100;
    }

    @Override
    public double getBaseWeight() {
        return 2;
    }

    @Override
    public double getBaseDistance() {
        return 50;
    }

    @Override
    public double additionalWeightCost(double weight) {
        double extra = weight - getBaseWeight();
        double cost = 0;
        if (extra <= 10) {
            cost += extra * 50;
        } else {
            cost += (10 * 50) + (10 * 60) + ((extra - 20) * 70);
        }
        return cost;
    }

    @Override
    public double additionalDistanceCost(double distance) {
        double extra = distance - getBaseDistance();
        double cost = 0;
        if (extra <= 500) {
            cost += extra * 20;
        }else {
            cost += (500 * 20) + (500 * 40) + ((extra - 1000) * 50);
        }
        return cost;
    }
}




