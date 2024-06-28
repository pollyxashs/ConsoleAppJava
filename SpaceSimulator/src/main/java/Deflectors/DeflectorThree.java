package Deflectors;

public class DeflectorThree extends Deflector {

    private static final double COEFFICIENT = 2;
    private static final double HEALTH = 400;

    public DeflectorThree() {
        super();
        this.setHealth(HEALTH);
        this.setCoefficient(COEFFICIENT);
    }

    @Override
    public double takeDamage(Obstacles obstacles) {
        if (obstacles == null) {
            throw new SpaceException();
        }

        double damageTaken = obstacles.getAmountDamage();

        if (damageTaken > this.getHealth()) {
            this.setHealth(0);
            this.setActive(false);
        } else {
            this.setHealth(this.getHealth() - damageTaken);
        }

        return this.getHealth();
    }
}