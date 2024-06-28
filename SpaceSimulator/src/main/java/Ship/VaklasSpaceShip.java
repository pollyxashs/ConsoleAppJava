package Ship;

import Deflectors.DeflectorOne;
import Deflectors.NitrineEmitter;
import Deflectors.PhotonDeflector;
import Engine.*;
import Hull.HullClassTwo;
import Obstacle.Flash;
import Obstacle.Obstacles;

import java.util.List;

public class VaklasSpaceShip extends SpaceShip {

    public VaklasSpaceShip(boolean value1) {
        super(new DeflectorOne(), new HullClassTwo(), createEnginesList(), new PhotonDeflector(false), new NitrineEmitter(false));
        setShipPhotonDeflector(new PhotonDeflector(value1));
    }

    public void calculateDamage(Obstacles obstacles) {
        if (obstacles instanceof Flash) {
            getShipPhotonDeflector().checkPhotonDeflector(obstacles);
        }

        if (getShipDeflector().getHealth() > 0) {
            getShipHull().damage(getShipDeflector().takeDamage(obstacles));
            getShipDeflector().takeDamage(obstacles);
        } else {
            getShipPhotonDeflector().setPeople(false);
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
        return List.of(new EnginesE(), new GammaEngines());
    }
}