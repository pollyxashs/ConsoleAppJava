package Deflectors;

public class DeflectorZero extends Deflector {

    private static final int INITIAL_HEALTH = 0;
    private double health;
    private double coefficient;

    public DeflectorZero() {
        super();
        this.health = INITIAL_HEALTH;
    }

    @Override
    public double getHealth() {
        return health;
    }

    @Override
    protected void setHealth(double health) {
        this.health = health;
    }

    @Override
    public double getCoefficient() {
        return coefficient;
    }

    @Override
    protected void setCoefficient(double coefficient) {
        this.coefficient = coefficient;
    }

    @Override
    public double takeDamage(Obstacles obstacles) {
        if (obstacles == null) {
            throw new SpaceException();
        }

        double damageTaken = obstacles.getAmountDamage();

        if (damageTaken > this.getHealth()) {
            super.setHealth(0);
            this.setActive(false);
        } else {
            super.setHealth(this.getHealth() - damageTaken);
        }

        return this.getHealth();
    }
}