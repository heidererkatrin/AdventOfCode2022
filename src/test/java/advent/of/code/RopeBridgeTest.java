package advent.of.code;

import advent.of.code.ropeBridge.RopeBridge;
import advent.of.code.ropeBridge.RopeBridgeCsvReader;
import advent.of.code.ropeBridge.RopeBridgeGrid;
import advent.of.code.ropeBridge.StepInformation;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.util.HashMap;

import static org.assertj.core.api.Assertions.assertThat;

public class RopeBridgeTest {
    public static final String TREE_GRID_FILE_PATH = "C:\\dev\\AdventOfCode2022\\src\\test\\resources\\RopeBridge.csv";
    public static final String TREE_GRID_FILE_PATH_SNIP = "C:\\dev\\AdventOfCode2022\\src\\test\\resources\\RopeBridgeTestSnippet.csv";


    @Test
    public void walkSteps(){
        RopeBridgeCsvReader gridCsvReader = new RopeBridgeCsvReader();
        RopeBridgeGrid grid = gridCsvReader.readInput(TREE_GRID_FILE_PATH);

        //9150 ist falsch // high
        //5740 ist falsch // low
        assertThat(grid.getTailCount()).isEqualTo(9150);
    }

    @Test
    public void walkStepsInSnippet(){
        RopeBridgeCsvReader gridCsvReader = new RopeBridgeCsvReader();
        RopeBridgeGrid grid = gridCsvReader.readInput(TREE_GRID_FILE_PATH_SNIP);

        assertThat(grid.getTailCount()).isEqualTo(13);
    }

    @Test
    public void walkStepsInSnippet2() throws IOException {
        RopeBridge gridCsvReader = new RopeBridge();
        gridCsvReader.calculate(TREE_GRID_FILE_PATH_SNIP);

//        assertThat(grid.getTailCount()).isEqualTo(13);
    }

    @Test
    public void walkEightStepsHaveTwoTails(){
        RopeBridgeCsvReader gridCsvReader = new RopeBridgeCsvReader();
        RopeBridgeGrid grid = gridCsvReader.readInput(TREE_GRID_FILE_PATH_SNIP);
        
        StepInformation initalStep = new StepInformation(0,0);
        grid.getWalkStepMap().put(initalStep.getCoordinates(), initalStep);

        grid.walk("R", initalStep);
        grid.walk("R", initalStep);
        grid.walk("R", initalStep);
        grid.walk("R", initalStep);
        grid.walk("U", initalStep);
        grid.walk("U", initalStep);
        grid.walk("U", initalStep);
        grid.walk("U", initalStep);

        assertThat(grid.getAmountPositionsTailHasTouched()).isEqualTo(6);
    }

    @Test
    public void walkFourStepsHaveThreeTails(){
//        RopeBridgeCsvReader gridCsvReader = new RopeBridgeCsvReader();
//        RopeBridgeGrid grid = gridCsvReader.readInput(TREE_GRID_FILE_PATH_SNIP);

        RopeBridgeGrid grid = new RopeBridgeGrid();
        StepInformation initalStep = grid.initFirstStep();
//        StepInformation initalStep = new StepInformation(0,0);
//        grid.getWalkStepMap().put(initalStep.getCoordinates(), initalStep);

        HashMap<String, StepInformation> walkStepMap = grid.getWalkStepMap();
        initalStep = grid.walk("R", initalStep);
        initalStep = grid.walk("R", initalStep);
        initalStep = grid.walk("R", initalStep);
        initalStep = grid.walk("R", initalStep);
//        initalStep = grid.walk("U", initalStep);
//        initalStep = grid.walk("U", initalStep);
//        initalStep = grid.walk("U", initalStep);
//        initalStep = grid.walk("U", initalStep);
        assertThat(grid.getAmountPositionsTailHasTouched()).isEqualTo(3);
    }

}
