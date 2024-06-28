package Obstacle;

import Engine.FunctionsForSpaceSimulator;

public class Flash extends Obstacles {

    private static final int DAMAGE = 1;

    public Flash() {
        super();
        setAmountDamage(DAMAGE);
    }

    public static void diedByFlash(Obstacles obstacle) {
        if (obstacle instanceof Flash) {
            FunctionsForSpaceSimulator.killPeople();
        }
    }
}