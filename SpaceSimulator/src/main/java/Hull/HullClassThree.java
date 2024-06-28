package Hull;

public class HullClassThree extends HullClass {

    private static final double COEFFICIENT = 2.0;
    private static final double HEALTH = 400.0;

    public HullClassThree() {
        super();
        setHealth(HEALTH);
        setCoefficient(COEFFICIENT);
    }

    @Override
    public double damage(double value) {
        if (value < 0) {
            throw new IllegalArgumentException("Damage cannot be negative");
        }

        double damageTaken = value * getCoefficient();

        if (damageTaken > getHealth()) {
            damageTaken = getHealth();
            setHealth(0);
            setShipDead(true);
        } else {
            setHealth(getHealth() - damageTaken);
        }

        return damageTaken;
    }
}