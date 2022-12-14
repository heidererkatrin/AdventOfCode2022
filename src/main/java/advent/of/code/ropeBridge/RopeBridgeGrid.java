package advent.of.code.ropeBridge;

import java.util.HashMap;

public class RopeBridgeGrid {
    private final HashMap<String, StepInformation> walkStepMap = new HashMap<>();
    private StepInformation lastTail = null;
    private boolean skippedMovingLastTail = false;
    private int tailCount = 0;


    public StepInformation initFirstStep(){
        StepInformation initalStep = new StepInformation(0,0);

        walkStepMap.put(initalStep.getCoordinates(), initalStep);
        lastTail = initalStep;

        return initalStep;
    }

    public StepInformation walk(String direction, StepInformation previousStep){
        StepInformation currentStep = moveCurrent(direction, previousStep);
        if (checkIfSurrounding(currentStep)){
            skippedMovingLastTail = true;
            System.out.println("Last Tail not moving");
            //DONT MOVE LAST TAIL
        }
        else{
            moveLastTail(currentStep, previousStep,  direction);
            skippedMovingLastTail = false;
        }
        return currentStep;
    }

    private boolean checkIfSurrounding(StepInformation currentStep) {
        return getDifference(lastTail.getX(), currentStep.getX()) <= 1
                && getDifference(lastTail.getY(), currentStep.getY()) <= 1;
    }

    private void moveLastTail(StepInformation currentStep,StepInformation previousStep, String direction) {
        if (skippedMovingLastTail){
            StepInformation stepInformation =
                    walkStepMap.get(
                            calculateXCoordinate(direction, currentStep, true) + ";" +
                                    calculateYCoordinate(direction, currentStep, true));
            stepInformation.setTailTouched(true);
            lastTail = stepInformation;
        }
        else{
            previousStep.setTailTouched(true);
            lastTail = previousStep;
        }
        tailCount += 1;
        System.out.println("New Last Tail is:" +  lastTail.getCoordinates());
    }

    private StepInformation moveCurrent(String direction, StepInformation previousStep) {
        StepInformation stepInformation = new StepInformation(
                calculateXCoordinate(direction, previousStep, false),
                calculateYCoordinate(direction, previousStep, false));
        walkStepMap.put(stepInformation.getCoordinates(), stepInformation);
        return stepInformation;
    }

    private int getDifference(int previousStep, int currentStep) {
        int diff = previousStep - currentStep;
        if (diff < 0){
            diff *= -1;
        }
        return diff;
    }

    private int calculateYCoordinate(String direction, StepInformation step, boolean tail) {
        int tailNum =1;
        if (tail){
            tailNum *= -1;
        }
        if (direction.equals("U")) {
            return step.getY() + tailNum;
        }
        if (direction.equals("D")) {
            return step.getY() - tailNum;
        }
        return step.getY();
    }

    private int calculateXCoordinate(String direction, StepInformation previousStep, boolean tail) {
        int tailNum =1;
        if (tail){
            tailNum *= -1;
        }
        if (direction.equals("R")) {
            return previousStep.getX() + tailNum;
        }
        if (direction.equals("L")) {
            return previousStep.getX() - tailNum;
        }
        return previousStep.getX();
    }

    public int getAmountPositionsTailHasTouched() {
        int sum = 0;
        for (StepInformation entry : walkStepMap.values()) {
            if (!entry.getCoordinates().equals("0;0") && entry.isTailTouched()) {
                sum += 1;
            }
        }
        return sum;
    }

    public int getTailCount(){
        return tailCount;
    }

    public HashMap<String, StepInformation> getWalkStepMap() {
        return walkStepMap;
    }
}
