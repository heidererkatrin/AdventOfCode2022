package advent.of.code.day10;

public class VideoSignal {
    private static final int CYCLE_DURATION = 2;
    public static final String ADDING = "addx ";
    public static final String NOOP = "noop";

    private final Cycle cycle;
    private final Sprite sprite;

    private StringBuilder ctrRow = new StringBuilder();
    private int xRegister = 1;


    public VideoSignal(Sprite sprite, Cycle cycle) {
        this.sprite = sprite;
        this.cycle = cycle;
    }

    public void readInput(String input) {
        if (input.equals(NOOP)) {
            processNextDay();
        } else if (input.startsWith(ADDING)) {
            processAdd(input);
        }
    }

    private void processAdd(String input) {
        int positionsToMove = Integer.parseInt(input.split(ADDING)[1]);
        for (int day = 0; day < CYCLE_DURATION; day++) {
            processNextDay();
            if (day != 0){
                this.xRegister += positionsToMove;
                sprite.moveSpritePosition(positionsToMove);
            }
        }
    }

    private void processNextDay() {
        cycle.increaseCycle();
        paintSprite();
    }

    private void paintSprite() {
        ctrRow.append(sprite.isInSprite(cycle.getDayInCycle()) ? "#" : ".");
        checkForMaxCycle();
    }

    private void checkForMaxCycle() {
        if (ctrRow.length() == Cycle.MAX_CYCLE_LENGTH) {
            System.out.println(ctrRow);
            ctrRow = new StringBuilder();
            cycle.resetCycle();
        }
    }

    public String getCtrRow() {
        return ctrRow.toString();
    }

    public int getCycle() {
        return cycle.getDayInCycle();
    }

    public int getXRegister() {
        return xRegister;
    }
}
