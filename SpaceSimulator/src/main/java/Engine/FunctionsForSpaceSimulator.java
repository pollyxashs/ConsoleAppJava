package Engine;

public class FunctionsForSpaceSimulator {

    private static boolean isNitrineLazerActivate;
    private static boolean people = true;
    private static boolean deadVoid;
    private static boolean isActive;

    public static boolean isNitrineLazerIsActivate() {
        return isNitrineLazerActivate;
    }

    private static void setNitrineLazerIsActivate(boolean isNitrineLazerActivate) {
        FunctionsForSpaceSimulator.isNitrineLazerActivate = isNitrineLazerActivate;
    }

    public static boolean isPeople() {
        return people;
    }

    private static void setPeople(boolean people) {
        FunctionsForSpaceSimulator.people = people;
    }

    public static boolean isDeadVoid() {
        return deadVoid;
    }

    private static void setDeadVoid(boolean deadVoid) {
        FunctionsForSpaceSimulator.deadVoid = deadVoid;
    }

    public static boolean isActive() {
        return isActive;
    }

    private static void setActive(boolean isActive) {
        FunctionsForSpaceSimulator.isActive = isActive;
    }

    public static void deadInVoid() {
        setDeadVoid(true);
    }

    public static void setNitrineLazer(boolean value) {
        setNitrineLazerIsActivate(value);
    }

    public static void destroyShip() {
        setActive(false);
        setPeople(false);
    }

    public static void toGetLostInTheVoid() {
        setActive(false);
        setPeople(false);
    }

    public static boolean killPeople() {
        if (isPeople()) {
            setPeople(false);
            return true;
        } else {
            return false;
        }
    }
}