package advent.of.code;

import advent.of.code.day13.DistressSignalCalculator;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class Day13DistressSignalTest {

    @Test
    void comparePairOneIsInRightOrder() {
        String input1 = "[1,1,3,1,1]";
        String input2 = "[1,1,5,1,1]";

        DistressSignalCalculator distressSignalCalculator = new DistressSignalCalculator();
        Assertions.assertTrue(distressSignalCalculator.validateInput(input1, input2));
    }
}
