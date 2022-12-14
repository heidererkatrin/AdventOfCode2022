package advent.of.code.ropeBridge;

import advent.of.code.signal.SignalCalculator;

import java.io.BufferedReader;
import java.io.FileReader;

public class RopeBridgeCsvReader {

    public RopeBridgeGrid readInput(String treeGridFilePathSnip) {
        String line = "";
        RopeBridgeGrid ropeBridgeGrid = new RopeBridgeGrid();
        StepInformation stepInformation = ropeBridgeGrid.initFirstStep();
        try {
            BufferedReader br = new BufferedReader(new FileReader(treeGridFilePathSnip));
            while ((line = br.readLine()) != null) {
                String[] commandAndSteps = line.split(" ");
                int steps = Integer.parseInt(commandAndSteps[1]);
                for (int step = 0; step < steps; step++) {
                    stepInformation = ropeBridgeGrid.walk(commandAndSteps[0], stepInformation);
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return ropeBridgeGrid;
    }
}
