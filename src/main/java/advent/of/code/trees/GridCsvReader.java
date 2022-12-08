package advent.of.code.trees;

import java.io.BufferedReader;
import java.io.FileReader;

public class GridCsvReader {
    public Grid readInput(String treeGridFilePath) {
        String line = "";
        int columns = 0;
        int rows = 0;
        Grid grid = new Grid();
        try {
            BufferedReader br = new BufferedReader(new FileReader(treeGridFilePath));
            while ((line = br.readLine()) != null) {
                columns = line.length();
                rows++;
            }
            grid.initForrest(rows, columns);

            rows = 0;
            br = new BufferedReader(new FileReader(treeGridFilePath));
            while ((line = br.readLine()) != null) {
                rows = insertTrees(line, rows, grid);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return grid;
    }

    private int insertTrees(String line, int rows, Grid grid) {
        for (int index = 0; index < line.length(); index++){
            int input = Integer.parseInt(line.substring(index, index + 1));
            grid.addTree(rows, index, input);
        }
        rows++;
        return rows;
    }
}
