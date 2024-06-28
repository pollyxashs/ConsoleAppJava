package Ship;

import Deflectors.DeflectorTwo;
import Deflectors.NitrineEmitter;
import Deflectors.PhotonDeflector;
import Engine.AlphaEngines;
import Engine.Engines;
import Engine.EnginesC;
import Engine.EnginesE;
import Hull.HullClassTwo;
import Obstacle.Obstacles;
import Obstacle.SpaceWhales;

import java.util.ArrayList;
import java.util.List;

import static Engine.AlphaEngines.checkJump;

public class MeredianSpaceShip extends SpaceShip {

    private DeflectorTwo deflectorTwo;

    public MeredianSpaceShip(boolean value2) {
        super(new DeflectorTwo(), new HullClassTwo(), createEnginesList(), new PhotonDeflector(false), new NitrineEmitter(true));
        this.deflectorTwo = new DeflectorTwo();
        setShipPhotonDeflector(new PhotonDeflector(value2));
    }

    public void calculateDamage(Obstacles obstacles) {
        if (obstacles instanceof SpaceWhales) {
            getShipNitrineEmitter().checkNitrineLazer(obstacles);
            return;
        }

        if (deflectorTwo.getHealth() <= 0) {
            // Handle ship behavior when deflector is broken
        } else {
            getShipHull().damage(deflectorTwo.takeDamage(obstacles));
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
        enginesList.add(new EnginesE());
        return enginesList;
    }

    public DeflectorTwo getDeflectorTwo() {
        return deflectorTwo;
    }

    public void setDeflectorTwo() {
        setDeflectorTwo(null);
    }

    public void setDeflectorTwo(DeflectorTwo deflectorTwo) {
        this.deflectorTwo = deflectorTwo;
    }
}