package advent.of.code.day12;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class ElfRoadCalculator {
    private ElfMap elfMap;
    private Step crossroad;
    private HashMap<Integer, Step> mapi = new HashMap<>();
    private List<Step> saveSinceLastCrossroad = new ArrayList<>();

    public ElfRoadCalculator(ElfMap elfMap) {
        this.elfMap = elfMap;
    }

    public void calculateAllPossibleWaysToBestSignal() {
        //Hole Startposition
        Step initialStep = elfMap.getInitalStartingPosition();
        Step endStep = elfMap.getEndDestination();

        //Schau welche felder moeglich sind +/- 1 (not touched)
        List<Step> steps = initialStep.getAvailableStepsToGo(elfMap);

        //nimm erstes Feld
        mapi.put(0, initialStep);
        searchFieldRecursive(endStep, steps, 0);
    }

    //TODO Not working / finished
    private void searchFieldRecursive(Step endStep, List<Step> steps, int previousStepCounter) {
        for (Step step : steps){
            List<Step> availableStepsToGo = step.getAvailableStepsToGo(elfMap);

            saveSinceLastCrossroad.add(step);
            step.setStepCounter(++previousStepCounter);
            mapi.put(step.getStepCounter(), step);
            if (step == endStep){
                System.out.println("Weg gefunden!!! Schritte: " + step.getStepCounter());
                break;
            }

            if (step.getAvailableStepsToGo(elfMap).isEmpty()){
                System.out.println("Es kann kein Weg mehr gefunden werden");
            }
            else{
                if (step.getAvailableStepsToGo(elfMap).size() > 1){
                    crossroad = step;
                }
                step.setTouched();
                steps = step.getAvailableStepsToGo(elfMap);
                searchFieldRecursive(endStep,  steps, step.getStepCounter());
            }
        }
    }

    public int getShortestWay() {
        return 0;
    }
}
