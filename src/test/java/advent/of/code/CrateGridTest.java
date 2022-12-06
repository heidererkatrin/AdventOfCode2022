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
    public void readCsvCrate() {
        CrateReader crateReader = new CrateReader(CRATE_FILE_PATH);
        CrateGrid crateGrid = crateReader.readInitialCrateInput();
        crateReader.readCrates(crateGrid);

        String answer = "JCMHLVGMG";
        for (int i = 1; i < 10; i++) {
            String highestValueInColumn = crateGrid.getHighestValueInColumn(i);
            assertThat(highestValueInColumn).isEqualTo(answer.charAt(i - 1) + "");
        }
    }

    @Test
    public void readInput() {
        CrateGrid crateGrid = new CrateGrid();
        crateGrid.addColumn(1, Stream.of("N", "Z").collect(Collectors.toList()));
        crateGrid.addColumn(2, Stream.of("D", "C", "M").collect(Collectors.toList()));
        crateGrid.addColumn(3, Stream.of("P").collect(Collectors.toList()));

        crateGrid.moveCrateInBundle(1, 2, 1);

        List<String> collectColumn1 = Stream.of("D", "N", "Z").collect(Collectors.toList());
        List<String> collectColumn2 = Stream.of("C", "M").collect(Collectors.toList());
        List<String> collectColumn3 = Stream.of("P").collect(Collectors.toList());

        compareLists(collectColumn1, crateGrid.getColumn(1));
        compareLists(collectColumn2, crateGrid.getColumn(2));
        compareLists(collectColumn3, crateGrid.getColumn(3));

        crateGrid.moveCrateInBundle(3, 1, 3);

        collectColumn2 = Stream.of("C", "M").collect(Collectors.toList());
        collectColumn3 = Stream.of("D", "N", "Z", "P").collect(Collectors.toList());

        compareLists(collectColumn2, crateGrid.getColumn(2));
        compareLists(collectColumn3, crateGrid.getColumn(3));

        crateGrid.moveCrateInBundle(2, 2, 1);

        collectColumn1 = Stream.of("C", "M").collect(Collectors.toList());
        collectColumn3 = Stream.of("D", "N", "Z", "P").collect(Collectors.toList());

        compareLists(collectColumn1, crateGrid.getColumn(1));
        compareLists(collectColumn3, crateGrid.getColumn(3));
    }

    @Test
    public void readCsvCrateExample2() {
        CrateReader crateReader = new CrateReader(CRATE_FILE_PATH);
        CrateGrid crateGrid = crateReader.readInitialCrateInput();
        crateReader.readCratesInBundle(crateGrid);

        String answer = "LVMRWSSPZ";
        for (int i = 1; i < 10; i++) {
            String highestValueInColumn = crateGrid.getHighestValueInColumn(i);
            assertThat(highestValueInColumn).isEqualTo(answer.charAt(i - 1) + "");
            System.out.println(highestValueInColumn);
        }
    }

    private void compareLists(List<String> collectColumn3, List<String> column) {
        assertThat(collectColumn3.size()).isEqualTo(column.size());
        for (int index = 0; index < collectColumn3.size(); index++) {
            assertThat(collectColumn3.get(index)).isEqualTo(column.get(index));
        }
    }
}
