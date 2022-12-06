package advent.of.code;

import advent.of.code.crates.CrateGrid;
import advent.of.code.crates.CrateReader;
import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;

public class CrateGridTest {
    public static final String CRATE_FILE_PATH = "C:\\dev\\AdventOfCode2022\\src\\test\\resources\\CrateStacks.csv";

    @Test
    public void createTestGrid()  {
        CrateGrid crateGrid = new CrateGrid();
        crateGrid.addColumn(1, Stream.of("G", "T", "R", "W").collect(Collectors.toList()));
        crateGrid.addColumn(2, Stream.of("G", "C", "H", "P", "M", "S", "V", "W").collect(Collectors.toList()));
        crateGrid.addColumn(3, Stream.of("C", "L", "T", "S", "G", "M").collect(Collectors.toList()));
        crateGrid.addColumn(4, Stream.of("J", "H", "D", "M", "W", "R", "F").collect(Collectors.toList()));
        crateGrid.addColumn(5, Stream.of("P", "Q", "L", "H", "S", "W", "F", "J").collect(Collectors.toList()));
        crateGrid.addColumn(6, Stream.of("P", "J", "D", "N", "F", "M", "S").collect(Collectors.toList()));
        crateGrid.addColumn(7, Stream.of("Z", "B", "D", "F", "G", "C", "S", "J").collect(Collectors.toList()));
        crateGrid.addColumn(8, Stream.of("R", "T", "B").collect(Collectors.toList()));
        crateGrid.addColumn(9, Stream.of("H", "N", "W", "L", "C").collect(Collectors.toList()));

        crateGrid.moveCrate(3, 4, 3);

        List<String> collectColumn3 = Stream.of("C", "L", "T", "S", "G", "M", "F", "R", "W").collect(Collectors.toList());
        List<String> collectColumn4 = Stream.of("J", "H", "D", "M").collect(Collectors.toList());

        List<String> column3 = crateGrid.getColumn(3);
        String columnHigh3 = crateGrid.getHighestValueInColumn(3);
        List<String> column4 = crateGrid.getColumn(4);

        assertThat(columnHigh3).isEqualTo("W");
        assertThat(column3).hasSameElementsAs(collectColumn3);
        assertThat(column4).hasSameElementsAs(collectColumn4);
    }

    @Test
    public void readCsvCrate() {
        CrateReader crateReader = new CrateReader(CRATE_FILE_PATH);
        CrateGrid crateGrid = crateReader.readInitialCrateInput();
        crateReader.readCrates(crateGrid);

        String answer = "JCMHLVGMG";
        for (int i = 1; i < 10; i++){
            String highestValueInColumn = crateGrid.getHighestValueInColumn(i);
            assertThat(highestValueInColumn).isEqualTo(answer.charAt(i-1)+"");
        }
    }
}
