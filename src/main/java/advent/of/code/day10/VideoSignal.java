package advent.of.code.day10;

public class VideoSignal {
    private static final int CYCLE_DURATION = 2;
    public static final String ADDING = "addx ";
    public static final String NOOP = "noop";

    private final Cycle cycle;
    private int xRegister = 1;
    private StringBuilder ctrRow = new StringBuilder();
    private Sprite sprite;


    public VideoSignal(Sprite sprite) {
        this.sprite = sprite;
        cycle = new Cycle();
    }

    public void readInput(String input) {
        if (input.equals(NOOP)) {
            cycle.increaseCycle();
            paintSprite();

        } else if (input.startsWith(ADDING)) {
            String[] value = input.split(ADDING);
            int positionsToMove = Integer.parseInt(value[1]);
            for (int index = 0; index < CYCLE_DURATION; index++) {
                cycle.increaseCycle();
                paintSprite();
                if (index != 0){
                    this.xRegister += positionsToMove;
                    sprite.moveSpritePosition(positionsToMove);
                }
            }
        }
    }

    private void paintSprite() {
        if (sprite.isInSprite(cycle.getDayInCycle())){
            ctrRow.append("#");
        }
        else{
            ctrRow.append(".");
        }
        checkForMaxCycle();
    }

    private void checkForMaxCycle() {
        if (ctrRow.length() == Cycle.MAX_CYCLE_LENGTH){
            System.out.println(ctrRow);
            ctrRow = new StringBuilder();
            cycle.setCycleBack();
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
