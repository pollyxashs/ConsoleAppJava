package Ship;

import Deflectors.DeflectorZero;
import Deflectors.NitrineEmitter;
import Deflectors.PhotonDeflector;
import Engine.AlphaEngines;
import Engine.Engines;
import Engine.EnginesC;
import Engine.EnginesE;
import Hull.HullClassOne;
import Obstacle.Obstacles;

import java.util.ArrayList;
import java.util.List;

public class PruglochnySpaceShip extends SpaceShip {

    private DeflectorZero deflectorZero;

    public PruglochnySpaceShip(boolean value2) {
        super(new DeflectorZero(), new HullClassOne(), createEnginesList(), new PhotonDeflector(false), new NitrineEmitter(false));
        this.deflectorZero = new DeflectorZero();
        setShipPhotonDeflector(new PhotonDeflector(value2));
    }

    public void calculateDamage(Obstacles obstacles) {
        if (deflectorZero.getHealth() <= 0) {
            // Handle ship behavior when deflector is broken
        } else {
            getShipHull().damage(deflectorZero.takeDamage(obstacles));
            getShipDeflector().takeDamage(obstacles);
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
            if (engine instanceof EnginesE || engine instanceof EnginesC) {
                return false;
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

    private static List<Engines> createEnginesList() {
        List<Engines> enginesList = new ArrayList<>();
        enginesList.add(new EnginesC());
        return enginesList;
    }

    public DeflectorZero getDeflectorZero() {
        return deflectorZero;
    }

    public void setDeflectorZero(
            DeflectorZero deflectorZero) {
        this.deflectorZero = deflectorZero;
    }
}