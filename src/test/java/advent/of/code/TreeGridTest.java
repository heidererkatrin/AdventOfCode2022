package advent.of.code;

import advent.of.code.trees.Grid;
import advent.of.code.trees.GridCsvReader;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class TreeGridTest {
    public static final String TREE_GRID_FILE_PATH = "C:\\dev\\AdventOfCode2022\\src\\test\\resources\\TreeTest.csv";
    public static final String TREE_GRID_FILE_PATH_SNIP = "C:\\dev\\AdventOfCode2022\\src\\test\\resources\\TreeTestSnippet.csv";
    @Test
    public void visibleTrees21(){
        GridCsvReader gridCsvReader = new GridCsvReader();
        Grid grid = gridCsvReader.readInput(TREE_GRID_FILE_PATH);

        assertThat(grid.calculateVisibleTrees()).isEqualTo(1543);
    }

    @Test
    public void visibleTreesTestSnippet(){
        GridCsvReader gridCsvReader = new GridCsvReader();
        Grid grid = gridCsvReader.readInput(TREE_GRID_FILE_PATH_SNIP);

        assertThat(grid.calculateVisibilityOfSingleTree(3,1)).isFalse();
        assertThat(grid.calculateVisibilityOfSingleTree(2,2)).isFalse();
        assertThat(grid.calculateVisibilityOfSingleTree(1,3)).isFalse();
        assertThat(grid.calculateVisibilityOfSingleTree(3,3)).isFalse();

        assertThat(grid.calculateVisibleTrees()).isEqualTo(21);
    }

    @Test
    public void scenicTreesTestSnippet(){
        GridCsvReader gridCsvReader = new GridCsvReader();
        Grid grid = gridCsvReader.readInput(TREE_GRID_FILE_PATH_SNIP);

        assertThat(grid.calculateSingleScenticScore(1,2)).isEqualTo(4);
        assertThat(grid.calculateSingleScenticScore(3,2)).isEqualTo(8);

        assertThat(grid.calculateHighestAllScenticScores()).isEqualTo(8);
    }
    @Test
    public void scenicTreesCalculation(){
        GridCsvReader gridCsvReader = new GridCsvReader();
        Grid grid = gridCsvReader.readInput(TREE_GRID_FILE_PATH);

        assertThat(grid.calculateHighestAllScenticScores()).isEqualTo(595080);
    }
}
