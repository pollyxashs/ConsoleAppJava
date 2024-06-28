package Engine;

public class GammaEngines extends Engines {

    private static final int MAX_LENGTH = 3;
    private static final double FUEL_CONS = 60.0;
    private static final double LAUNCH = 120.0;
    private static final double CURRENT_SPEED = 220.0;

    private double distance;
    private double bac = 1000;

    public GammaEngines(double distance) {
        super();
        this.distance = distance;
    }

    public double getDistance() {
        return distance;
    }

    public void setDistance(double distance) {
        this.distance = distance;
    }

    @Override
    public double getBac() {
        return bac;
    }

    @Override
    protected void setBac(double bac) {
        this.bac = bac;
    }

    public static boolean checkJump(int length) {
        if (length > MAX_LENGTH) {
            FunctionsForSpaceSimulator.toGetLostInTheVoid();
            return true;
        } else if (length < 0) {
            throw new IllegalArgumentException("Length cannot be a negative value");
        } else {
            FunctionsForSpaceSimulator.deadInVoid();
            return false;
        }
    }

    @Override
    public double calculateTime(double distance) {
        return Math.log(distance) / Math.log(CURRENT_SPEED);
    }

    @Override
    public double calculateFuelConsumption(double distance) {
        return (FUEL_CONS * FUEL_CONS * distance) * LAUNCH;
    }

    @Override
    public boolean calculatePassDistance(double distance) {
        return calculateFuelConsumption(distance) <= bac;
    }
}