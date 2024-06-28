package Hull;

public abstract class HullClass {

    protected HullClass() {
    }

    private double health;
    private boolean isShipDead;
    private double coefficient;

    public double getHealth() {
        return health;
    }

    protected void setHealth(double health) {
        this.health = health;
    }

    public boolean isShipDead() {
        return isShipDead;
    }

    public void setShipDead(boolean shipDead) {
        isShipDead = shipDead;
    }

    public double getCoefficient() {
        return coefficient;
    }

    protected void setCoefficient(double coefficient) {
        this.coefficient = coefficient;
    }

    public abstract double damage(double value);
}
