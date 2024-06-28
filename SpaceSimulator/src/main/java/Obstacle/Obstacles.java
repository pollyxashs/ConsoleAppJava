package Obstacle;

public abstract class Obstacles {

    protected Obstacles() {
    }

    protected double amountDamage;

    public double getAmountDamage() {
        return amountDamage;
    }

    protected void setAmountDamage(double amountDamage) {
        this.amountDamage = amountDamage;
    }
}