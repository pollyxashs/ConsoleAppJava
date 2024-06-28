package Engine;

public class EnginesC extends Engines {

    private static final double FUEL_CONS = 1.0;
    private static final double LAUNCH = 10.0;
    private static final double CURRENT_SPEED = 100.0;

    private double bac = 1000.0;

    public EnginesC() {
        super();
    }

    @Override
    public double getBac() {
        return bac;
    }

    @Override
    protected void setBac(double bac) {
        this.bac = bac;
    }

    @Override
    public double calculateTime(double distance) {
        return distance / CURRENT_SPEED;
    }

    @Override
    public double calculateFuelConsumption(double distance) {
        return (FUEL_CONS * distance) * LAUNCH;
    }

    @Override
    public boolean calculatePassDistance(double distance) {
        return calculateFuelConsumption(distance) <= bac;
    }
}