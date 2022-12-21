package advent.of.code;

import advent.of.code.day12.ElfMap;
import advent.of.code.day12.ElfRoadCalculator;
import advent.of.code.day12.MapReader;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class Day12MapTest {

    //Sabqponm
    //abcryxxl
    //accszExk
    //acctuvwj
    //abdefghi

    //v..v<<<<
    //>v.vv<<^
    //.>vv>E^^
    //..v>>>^^
    //..>>>>>^

    //31
    public static final String MAP_FILE_PATH = "C:\\dev\\AdventOfCode2022\\src\\test\\resources\\Day12Map.csv";

    @Test
    void input() {
        MapReader mapReader = new MapReader(MAP_FILE_PATH);
        ElfMap elfMap = mapReader.readMap();
        ElfRoadCalculator elfRoadCalculator = new ElfRoadCalculator(elfMap);

        elfRoadCalculator.calculateAllPossibleWaysToBestSignal();

        assertThat(elfRoadCalculator.getShortestWay()).isEqualTo(31);
    }

    @Test
    void testAlphabeticOrder() {
        assertTrue(isNextInAlphabeth('a', 'b'));
        assertTrue(isNextInAlphabeth('a', 'a'));
        assertFalse(isNextInAlphabeth('a', 'c'));
        assertFalse(isNextInAlphabeth('z', 'x'));
        assertTrue(isNextInAlphabeth('z', 'y'));
    }

    public boolean isNextInAlphabeth(char letter, char nextLetter) {
        if (letter == nextLetter){
            return true;
        }
        if ((int) letter +1 == nextLetter){
            return true;
        }
        if ((int) letter -1 == nextLetter){
            return true;
        }
        return false;
    }
}
