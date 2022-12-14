package advent.of.code.day10;

public class Cycle {
    public static final int MAX_CYCLE_LENGTH = 40;
    int dayInCycle;

    public void increaseCycle() {
        dayInCycle += 1;
    }

    public int getDayInCycle() {
        return dayInCycle;
    }

    public void resetCycle() {
        dayInCycle -= MAX_CYCLE_LENGTH;
    }
}
