package advent.of.code.day14;

import java.util.List;
import java.util.stream.Stream;

public class RockUtil {

    public static int getLargestX(List<String> inputLines) {
        return inputLines.stream()
                .flatMap(line -> Stream.of(line.split(" -> ")))
                .map(s -> s.split(",")[0])
                .mapToInt(Integer::parseInt)
                .max()
                .orElse(0);
    }

    public static int getLargestY(List<String> inputLines) {
        int smallestY = 0;
        for (String line : inputLines){
            String[] split = line.split(" -> ");
            for (String s : split){
                String[] coordinates = s.split(",");
                if (Integer.parseInt(coordinates[1]) > smallestY){
                    smallestY = Integer.parseInt(coordinates[1]);
                }
            }
        }
        return smallestY;
    }

    public static int getSmallestX(List<String> inputLines) {
        int smallestX = 1000;
        for (String line : inputLines){
            String[] split = line.split(" -> ");
            for (String s : split){
                String[] coordinates = s.split(",");
                if (Integer.parseInt(coordinates[0]) < smallestX){
                    smallestX = Integer.parseInt(coordinates[0]);
                }
            }
        }
        return smallestX;
    }

    public static int getSmallestY(List<String> inputLines) {
        int smallestY = 1000;
        for (String line : inputLines){
            String[] split = line.split(" -> ");
            for (String s : split){
                String[] coordinates = s.split(",");
                if (Integer.parseInt(coordinates[1]) < smallestY){
                    smallestY = Integer.parseInt(coordinates[1]);
                }
            }
        }
        return smallestY;
    }
}
