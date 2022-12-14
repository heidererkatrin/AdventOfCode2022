package advent.of.code.day10;

public class VideoSignal {
    private static final int CYCLE_DURATION = 2;
    public static final String ADDING = "addx ";
    public static final String NOOP = "noop";

    private final Cycle cycle;
    private final Sprite sprite;

    private int xRegister = 1;
    private StringBuilder ctrRow = new StringBuilder();


    public VideoSignal(Sprite sprite) {
        this.sprite = sprite;
        cycle = new Cycle();
    }

    public void readInput(String input) {
        if (input.equals(NOOP)) {
            cycle.increaseCycle();
            paintSprite();
        } else if (input.startsWith(ADDING)) {
            int positionsToMove = Integer.parseInt(input.split(ADDING)[1]);
            for (int iteration = 0; iteration < CYCLE_DURATION; iteration++) {
                cycle.increaseCycle();
                paintSprite();
                if (iteration != 0){
                    this.xRegister += positionsToMove;
                    sprite.moveSpritePosition(positionsToMove);
                }
            }
        }
    }

    private void paintSprite() {
        ctrRow.append(sprite.isInSprite(cycle.getDayInCycle()) ? "#" : ".");
        checkForMaxCycle();
    }

    private void checkForMaxCycle() {
        if (ctrRow.length() == Cycle.MAX_CYCLE_LENGTH){
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
