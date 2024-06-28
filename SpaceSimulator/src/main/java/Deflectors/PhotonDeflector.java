package Deflectors;

public class PhotonDeflector extends Deflector {

    private static final double HEALTH = 3;
    private boolean people = true;
    private boolean isPhotonDeflectorActive;

    public PhotonDeflector(boolean value) {
        super();
        this.isPhotonDeflectorActive = value;
        this.setHealth(HEALTH);
    }

    public boolean isPeople() {
        return people;
    }

    protected void setPeople(boolean people) {
        this.people = people;
    }

    public boolean isPhotonDeflectorActive() {
        return isPhotonDeflectorActive;
    }

    public void setPhotonDeflectorActive(boolean isPhotonDeflectorActive) {
        this.isPhotonDeflectorActive = isPhotonDeflectorActive;
    }

    public void checkPhotonDeflector(Obstacles obstacles) {
        if (isPhotonDeflectorActive) {
            takeDamage(obstacles);
        } else {
            setPeople(false);
        }
    }

    public void setPhotonDeflector(boolean value) {
        this.isPhotonDeflectorActive = value;
    }

    @Override
    public double takeDamage(Obstacles obstacles) {
        if (obstacles == null) {
            throw new SpaceException();
        }

        if (obstacles instanceof Flash) {
            if (this.getHealth() > 0) {
                this.setHealth(this.getHealth() - 1);
            }
        } else if (this.getHealth() == 0) {
            setPeople(false);
        }

        return this.getHealth();
    }
}