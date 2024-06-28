package Engine;
public abstract class Engines {

    protected double fuelConsumption;

    protected Engines() {
    }

    public double getFuelConsumption() {
        return fuelConsumption;
    }

    protected void setFuelConsumption(double fuelConsumption) {
        this.fuelConsumption = fuelConsumption;
    }

    public abstract double getBac();

    protected abstract void setBac(double bac);

    public abstract double calculateTime(double distance);

    public abstract double calculateFuelConsumption(double distance);

    public abstract boolean calculatePassDistance(double distance);
}