package advent.of.code.day12;

import advent.of.code.trees.Grid;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class MapReader {
    private final String filePath;

    public MapReader(String filePath) {
        this.filePath = filePath;
    }

    public ElfMap readMap() {
        String line = "";
        int columns = 0;
        int rows = 0;
        ElfMap elfmap  = new ElfMap();
        try {
            BufferedReader br = new BufferedReader(new FileReader(filePath));
            while ((line = br.readLine()) != null) {
                columns = line.length();
                rows++;
            }
            elfmap.initSteps(rows, columns);

            rows = 0;
            br = new BufferedReader(new FileReader(filePath));
            while ((line = br.readLine()) != null) {
                rows = insertSteps(line, rows, elfmap);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return elfmap;
    }

    private int insertSteps(String line, int rows, ElfMap elfMap) {
        for (int index = 0; index < line.length(); index++){
            char input = line.substring(index, index + 1).charAt(0);
            elfMap.addStep(rows, index, input);
        }
        rows++;
        return rows;
    }
}
