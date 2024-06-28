package Ship;

import Deflectors.DeflectorOne;
import Deflectors.NitrineEmitter;
import Deflectors.PhotonDeflector;
import Engine.*;
import Hull.HullClassOne;
import Obstacle.Obstacles;

import java.util.List;

import static Ship.AvgurSpaceShip.createEnginesList;

public class StellaSpaceShip extends SpaceShip {

    private DeflectorOne deflectorOne;

    public StellaSpaceShip(boolean value2) {
        super(new DeflectorOne(), new HullClassOne(), createEnginesList(), new PhotonDeflector(false), new NitrineEmitter(false));
        deflectorOne = new DeflectorOne();
        setShipPhotonDeflector(new PhotonDeflector(value2));
    }

    public void calculateDamage(Obstacles obstacles) {
        if (deflectorOne.getHealth() > 0) {
            getShipHull().damage(deflectorOne.takeDamage(obstacles));
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
        return List.of(new EnginesC(), new OmegaEngines());
    }
}