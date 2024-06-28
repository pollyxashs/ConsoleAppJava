package Ship;

import Deflectors.DeflectorThree;
import Deflectors.NitrineEmitter;
import Deflectors.PhotonDeflector;
import Engine.AlphaEngines;
import Engine.Engines;
import Engine.EnginesC;
import Engine.EnginesE;
import Hull.HullClassThree;
import Obstacle.Obstacles;
import Obstacle.SpaceWhales;

import java.util.ArrayList;
import java.util.List;

public class AvgurSpaceShip extends SpaceShip {

    private DeflectorThree deflectorThree;
    private PhotonDeflector shipPhotonDeflector;

    public AvgurSpaceShip(boolean value2) {
        super(new DeflectorThree(), new HullClassThree(), createEnginesList(), new PhotonDeflector(false), new NitrineEmitter(false));
        this.deflectorThree = new DeflectorThree();
        this.shipPhotonDeflector = new PhotonDeflector(value2);
    }

    private static List<Engines> createEnginesList() {
        List<Engines> enginesList = new ArrayList<>();
        enginesList.add(new EnginesE());
        enginesList.add(new AlphaEngines());
        return enginesList;
    }

    public void calculateDamage(Obstacles obstacles) {
        if (obstacles instanceof SpaceWhales) {
            getShipNitrineEmitter().checkNitrineLazer(obstacles);
        }

        if (deflectorThree.getHealth() <= 0) {
            // Handle ship behavior when deflector is broken
        } else {
            getShipHull().damage(deflectorThree.takeDamage(obstacles));
        }
    }

    @Override
    public boolean haveEngineE(Engines engines) {
        for (Engines engine : getListEngines()) {
            if (engine instanceof EnginesE) {
                return true;
            }
        }
        return false;
    }

    @Override
    public boolean haveJumpEngine(Engines engines) {
        for (Engines engine : getListEngines()) {
            if (engine == null) {
                return false;
            } else if (!(engine instanceof EnginesE) && !(engine instanceof EnginesC)) {
                return true;
            }
        }
        return true;
    }

    @Override
    public boolean checkJumpe(Engines engines) {
        if (engines instanceof AlphaEngines) {
            checkJump(100);
        }
        return false;
    }

    public int getDeadVoid() {
        return deadVoid;
    }

    public void setDeadVoid(int deadVoid) {
        this.deadVoid = deadVoid;
    }

    private int deadVoid;

    public DeflectorThree getDeflectorThree() {
        return deflectorThree;
    }

    public void setDeflectorThree(DeflectorThree deflectorThree) {
        this.deflectorThree = deflectorThree;
    }

    public PhotonDeflector getShipPhotonDeflector() {
        return shipPhotonDeflector;
    }

    public void setShipPhotonDeflector(PhotonDeflector shipPhotonDeflector) {
        this.shipPhotonDeflector = shipPhotonDeflector;
    }
}
