package advent.of.code.day12;

import java.util.ArrayList;
import java.util.List;

public class Step {
    private final int row;
    private final int column;
    private char letter;
    private int stepCounter;

    private boolean touched = false;
    private char directionWent = '.';

    public Step(char letter, int row, int column) {
        this.letter = letter;
        this.row = row;
        this.column = column;
    }

    public char getLetter() {
        return letter;
    }

    public List<Step> getAvailableStepsToGo(ElfMap elfMap) {
        ArrayList<Step> list = new ArrayList<>();
        getStepAbove(elfMap, list);
        getStepRight(elfMap, list);
        getStepDown(elfMap, list);
        getStepLeft(elfMap, list);

        return list;
    }

    private void getStepAbove(ElfMap elfMap, ArrayList<Step> stepList) {
        if (row > 0) {
            Step step = elfMap.getSteps()[row - 1][column];
            if (!step.touched && isNextInAlphabeth(step.getLetter())) {
                stepList.add(step);
            }
        }
    }

    private void getStepDown(ElfMap elfMap, ArrayList<Step> stepList) {
        if (row < elfMap.getStepRows() -1) {
            Step step = elfMap.getSteps()[row +1 ][column];
            if (!step.touched && isNextInAlphabeth(step.getLetter())) {
                stepList.add(step);
            }
        }
    }

    private void getStepLeft(ElfMap elfMap, ArrayList<Step> stepList) {
        if (column > 0) {
            Step step = elfMap.getSteps()[row ][column-1];
            if (!step.touched && isNextInAlphabeth(step.getLetter())) {
                stepList.add(step);
            }
        }
    }

    private void getStepRight(ElfMap elfMap, ArrayList<Step> stepList) {
        if (column < elfMap.getStepColumns() -1) {
            Step step = elfMap.getSteps()[row ][column+1];
            if (!step.touched && isNextInAlphabeth(step.getLetter())) {
                stepList.add(step);
            }
        }
    }

    public boolean isNextInAlphabeth(char nextLetter) {
        return this.letter == nextLetter || (int) letter + 1 == nextLetter || (int) letter - 1 == nextLetter;
    }

    public void setTouched() {
        this.touched = true;
    }

    public void setUntouched(){
        this.touched = false;
    }

    public void setLetter(char letter) {
        this.letter = letter;
    }

    public int getStepCounter() {
        return stepCounter;
    }

    public void setStepCounter(int stepCounter) {
        this.stepCounter = stepCounter;
    }
}
