package advent.of.code;

import advent.of.code.day14.RockBlueprint;
import advent.of.code.day14.RockCsvReader;
import advent.of.code.day14.RockUtil;
import advent.of.code.day20.Encrypter;
import advent.of.code.day20.EncrypterCsvReader;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class Day14SandTest {

    public static final String SAND_FILE_PATH = "C:\\dev\\AdventOfCode2022\\src\\test\\resources\\SandMap.csv";


    @Test
    public void mapSizeShouldBeCalculated() {
        RockBlueprint rockBlueprint = new RockBlueprint();
        rockBlueprint.addLine("498,4 -> 498,6 -> 496,6");
        rockBlueprint.addLine("503,4 -> 502,4 -> 502,9 -> 494,9");

        Assertions.assertEquals(RockUtil.getSmallestX(rockBlueprint.getInputLines()), 494);
        Assertions.assertEquals(RockUtil.getSmallestY(rockBlueprint.getInputLines()), 4);
        Assertions.assertEquals(RockUtil.getLargestX(rockBlueprint.getInputLines()), 503);
        Assertions.assertEquals(RockUtil.getLargestY(rockBlueprint.getInputLines()), 9);
    }

    @Test
    public void rockMapShouldBePainted() {
        RockBlueprint rockBlueprint = new RockBlueprint();
        rockBlueprint.addLine("498,4 -> 498,6 -> 496,6");
        rockBlueprint.addLine("503,4 -> 502,4 -> 502,9 -> 494,9");

        rockBlueprint.initMap();

        String expectedMap = "......+...\n" +
                "..........\n" +
                "..........\n" +
                "..........\n" +
                "....#...##\n" +
                "....#...#.\n" +
                "..###...#.\n" +
                "........#.\n" +
                "........#.\n" +
                "#########.";
//        Assertions.assertEquals(20, rockBlueprint.getPaintedRockMap().size());
    }

    @Test
    public void rockMapShouldBePaintedWithSand() {
        RockBlueprint rockBlueprint = new RockBlueprint();
        rockBlueprint.addLine("498,4 -> 498,6 -> 496,6");
        rockBlueprint.addLine("503,4 -> 502,4 -> 502,9 -> 494,9");

        rockBlueprint.initMap();

        String expectedMap = "......+...\n" +
                "..........\n" +
                "..........\n" +
                "..........\n" +
                "....#...##\n" +
                "....#...#.\n" +
                "..###...#.\n" +
                "........#.\n" +
                "........#.\n" +
                "#########.";

//        Assertions.assertEquals(20, rockBlueprint.getPaintedRockMap().size());
    }

    @Test
    void readRockInputFromFile() {
        RockCsvReader rockCsvReader = new RockCsvReader();

        RockBlueprint rockBlueprint = rockCsvReader.readInput(SAND_FILE_PATH);
        rockBlueprint.initMap();

        Assertions.assertEquals(763, rockBlueprint.getCounter());
    }
}
