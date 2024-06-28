package Ship;

import Deflectors.Deflector;
import Deflectors.NitrineEmitter;
import Deflectors.PhotonDeflector;
import Engine.Engines;
import Engine.FunctionsForSpaceSimulator;
import Hull.HullClass;

import java.util.ArrayList;
import java.util.List;

public abstract class SpaceShip {

    private List<Engines> engines;

    protected SpaceShip(Deflector deflector, HullClass hull, Iterable<Engines> engines, PhotonDeflector photonDeflector, NitrineEmitter nitrineEmitter) {
        this.engines = new ArrayList<>();
        engines.forEach(this.engines::add); // Initialize engines list
     /*   this.ShipDeflector = deflector;
        this.ShipHull = hull;
        this.ShipPhotonDeflector = photonDeflector;
        this.ShipNitrineEmitter = nitrineEmitter;*/
    }

    public List<Engines> getListEngines() {
        return engines;
    }

    private NitrineEmitter shipNitrineEmitter;
    private PhotonDeflector shipPhotonDeflector;
    private HullClass shipHull;
    private Deflector shipDeflector;
    private double currentSpeed;
    private boolean isActive = true;

    public NitrineEmitter getShipNitrineEmitter() {
        return shipNitrineEmitter;
    }

    public void setShipNitrineEmitter(NitrineEmitter shipNitrineEmitter) {
        this.shipNitrineEmitter = shipNitrineEmitter;
    }

    public PhotonDeflector getShipPhotonDeflector() {
        return shipPhotonDeflector;
    }

    public void setShipPhotonDeflector(PhotonDeflector shipPhotonDeflector) {
        this.shipPhotonDeflector = shipPhotonDeflector;
    }

    public HullClass getShipHull() {
        return shipHull;
    }

    public void setShipHull(HullClass shipHull) {
        this.shipHull = shipHull;
    }

    public Deflector getShipDeflector() {
        return shipDeflector;
    }

    public void setShipDeflector(Deflector shipDeflector) {
        this.shipDeflector = shipDeflector;
    }

    public double getCurrentSpeed() {
        return currentSpeed;
    }

    public void setCurrentSpeed(double currentSpeed) {
        this.currentSpeed = currentSpeed;
    }

    public boolean isActive() {
        return isActive;
    }

    public void setActive(boolean active) {
        isActive = active;
    }

    public abstract boolean haveEngineE(Engines engines);

    public abstract boolean haveJumpEngine(Engines engines);

    public abstract boolean checkJumpe(Engines engines);

    public void setPhotoneDeflector(boolean value1) {
        shipPhotonDeflector.setPhotonDeflectorActive(value1);
    }

    public double calculateFuelConsumption(double distance) {
        double fuel = 0;
        for (Engines engine : engines) {
            fuel += engine.calculateFuelConsumption(distance);
        }
        return fuel;
    }

    protected static void checkJump(int length) {
        if (length > 3) {
            FunctionsForSpaceSimulator.toGetLostInTheVoid();
        } else if (length < 0) {
            throw new IllegalArgumentException("Length cannot be a negative value");
        } else {
            FunctionsForSpaceSimulator.deadInVoid();
        }
    }
}