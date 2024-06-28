package Hull;

public class HullClassTwo extends HullClass {

    private static final double COEFFICIENT = 1.25;
    private static final double HEALTH = 25.0;

    public HullClassTwo() {
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