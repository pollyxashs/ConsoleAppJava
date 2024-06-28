package Deflectors;

import Engine.FunctionsForSpaceSimulator;

public class NitrineEmitter {

    private boolean isNitrineLazerActive;

    public NitrineEmitter(boolean value1) {
        FunctionsForSpaceSimulator.setNitrineLazer(value1);
        this.isNitrineLazerActive = value1;
    }

    public boolean isNitrineLazerActive() {
        return isNitrineLazerActive;
    }

    protected void setNitrineLazerActive(boolean isNitrineLazerActive) {
        this.isNitrineLazerActive = isNitrineLazerActive;
    }

    public static void whalesDamage(Obstacles obstacles) {
        if (obstacles instanceof SpaceWhales) {
            obstacles.setAmountDamage(0);
        }
    }

    public void checkNitrineLazer(Obstacles obstacles) {
        if (isNitrineLazerActive) {
            whalesDamage(obstacles);
        } else {
            FunctionsForSpaceSimulator.killPeople();
        }
    }
}