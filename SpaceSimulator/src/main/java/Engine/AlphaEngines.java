package Engine;

public class AlphaEngines extends Engines {

    private static final int MAX_LENGTH = 3;
    private static final double FUEL_CONSUMPTION = 15.0;
    private static final double LAUNCH = 45.0;
    private static final double CURRENT_SPEED = 95.0;

    private double bac = 100;

    public AlphaEngines() {
        super();
    }

    @Override
    public double getBac() {
        return bac;
    }

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
        return distance / CURRENT_SPEED;
    }

    @Override
    public double calculateFuelConsumption(double distance) {
        return FUEL_CONSUMPTION * distance * LAUNCH;
    }

    @Override
    public boolean calculatePassDistance(double distance) {
        return calculateFuelConsumption(distance) <= bac;
    }
}