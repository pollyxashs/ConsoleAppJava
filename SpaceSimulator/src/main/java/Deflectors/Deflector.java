package Deflectors;

import Obstacle.Obstacles;

public abstract class Deflector {

    protected double health;
    protected boolean isActive;
    protected double coefficient;

    protected Deflector() {
    }

    public double getHealth() {
        return health;
    }

    protected void setHealth(double health) {
        this.health = health;
    }

    public boolean isActive() {
        return isActive;
    }

    protected void setActive(boolean isActive) {
        this.isActive = isActive;
    }

    public double getCoefficient() {
        return coefficient;
    }

    protected void setCoefficient(double coefficient) {
        this.coefficient = coefficient;
    }

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