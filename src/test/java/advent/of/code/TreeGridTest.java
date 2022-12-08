package advent.of.code;

import advent.of.code.trees.Grid;
import advent.of.code.trees.GridCsvReader;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class TreeGridTest {
    public static final String TREE_GRID_FILE_PATH = "C:\\dev\\AdventOfCode2022\\src\\test\\resources\\TreeTest.csv";
    @Test
    public void visibleTrees21(){
        GridCsvReader gridCsvReader = new GridCsvReader();
        Grid grid = gridCsvReader.readInput(TREE_GRID_FILE_PATH);

//        assertThat(grid.calculateTree(3,1)).isFalse();
//        assertThat(grid.calculateTree(2,2)).isFalse();
//        assertThat(grid.calculateTree(1,3)).isFalse();
//        assertThat(grid.calculateTree(3,3)).isFalse();

        assertThat(grid.calculateVisibleTrees()).isEqualTo(1543);
    }
}
