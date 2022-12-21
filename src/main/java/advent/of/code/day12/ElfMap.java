package advent.of.code.day12;

public class ElfMap {
    private static final char STARTING_LETTER = 'S';
    private static final char END_LETTER = 'E';

    private Step[][] steps;
    private Step initalStartingPosition;
    private Step endDestination;

    private int stepRows;
    private int stepColumns;

    public void initSteps(int xSize, int ySize) {
        this.steps = new Step[xSize][ySize];
        this.stepRows = xSize;
        this.stepColumns = ySize;
    }

    public void addStep(int row, int column, char letter) {
        steps[row][column] = new Step(letter, row, column);
        if (letter == STARTING_LETTER) {
            initalStartingPosition = steps[row][column];
            steps[row][column].setLetter('a');
        } else if (letter == END_LETTER) {
            endDestination = steps[row][column];
            steps[row][column].setLetter('z');
        }
    }

    public Step getInitalStartingPosition() {
        return initalStartingPosition;
    }

    public Step getEndDestination() {
        return endDestination;
    }

    public Step[][] getSteps() {
        return steps;
    }

    public int getStepRows() {
        return stepRows;
    }

    public int getStepColumns() {
        return stepColumns;
    }
}
