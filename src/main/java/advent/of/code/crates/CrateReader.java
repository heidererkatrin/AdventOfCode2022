package advent.of.code.crates;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class CrateReader {
    private final String filePath;

    public CrateReader(String filePath) {
        this.filePath = filePath;
    }

    public CrateGrid readInitialCrateInput() {
        String line = "";
        CrateGrid crateGrid = new CrateGrid();
        try {
            BufferedReader br = new BufferedReader(new FileReader(filePath));
            int lineIndex = 0;
            while ((line = br.readLine()) != null) {
                if (lineIndex < 8) {
                    int columnIndex = 1;
                    for (int index = 1; index < 36; index = index + 4) {
                        crateGrid.addInput(columnIndex, line.substring(index, index + 1));
                        columnIndex++;
                    }
                    lineIndex++;
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return crateGrid;
    }

    public void readCrates(CrateGrid crateGrid) {
        String line = "";
        CrateOutputPrinter outputPrinter = new CrateOutputPrinter();
        try {
            BufferedReader br = new BufferedReader(new FileReader(filePath));
            int lineIndex = 0;
            while ((line = br.readLine()) != null) {
                lineIndex++;
                if (lineIndex > 10) {
                    crateGrid.getColumn(1);
                    String[] splitMove = line.split("move ");
                    String[] splitFrom = splitMove[1].split(" from ");
                    String[] splitTo = splitFrom[1].split(" to ");
                    crateGrid.moveCrate(Integer.parseInt(splitFrom[0]), Integer.parseInt(splitTo[0]), Integer.parseInt(splitTo[1]));
                    outputPrinter.print(crateGrid);
                    lineIndex++;
                    System.out.println(line);
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void readCratesInBundle(CrateGrid crateGrid) {
        String line = "";
        CrateOutputPrinter outputPrinter = new CrateOutputPrinter();
        try {
            BufferedReader br = new BufferedReader(new FileReader(filePath));
            int lineIndex = 0;
            while ((line = br.readLine()) != null) {
                lineIndex++;
                if (lineIndex > 10) {
                    crateGrid.getColumn(1);
                    String[] splitMove = line.split("move ");
                    String[] splitFrom = splitMove[1].split(" from ");
                    String[] splitTo = splitFrom[1].split(" to ");
                    crateGrid.moveCrateInBundle(Integer.parseInt(splitFrom[0]), Integer.parseInt(splitTo[0]), Integer.parseInt(splitTo[1]));
                    outputPrinter.print(crateGrid);
                    lineIndex++;
                    System.out.println(line);
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
