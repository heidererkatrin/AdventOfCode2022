package advent.of.code;

import advent.of.code.signal.SignalCalculator;
import advent.of.code.signal.SignalCsvReader;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class SignalTest {
    public static final String SECTIONS_FILE_PATH = "C:\\dev\\AdventOfCode2022\\src\\test\\resources\\Signals.csv";
    public static final int LENGTH_OF_MARKER_LONG = 14;
    public static final int LENGTH_OF_MARKER_SHORT = 4;

    @Test
    public void calculateMarkerShouldBe5() {
        SignalCalculator signalCalculator = new SignalCalculator();
        int firstMarker = signalCalculator.calculateFirstMarker("bvwbjplbgvbhsrlpgdmjqwftvncz", LENGTH_OF_MARKER_SHORT);
        assertThat(firstMarker).isEqualTo(5);
    }

    @Test
    public void calculateMarkerShouldBe6() {
        SignalCalculator signalCalculator = new SignalCalculator();
        int firstMarker = signalCalculator.calculateFirstMarker("nppdvjthqldpwncqszvftbrmjlhg", LENGTH_OF_MARKER_SHORT);
        assertThat(firstMarker).isEqualTo(6);
    }

    @Test
    public void calculateMarkerShouldBe10() {
        SignalCalculator signalCalculator = new SignalCalculator();
        int firstMarker = signalCalculator.calculateFirstMarker("nznrnfrfntjfmvfwmzdfjlvtqnbhcprsg", LENGTH_OF_MARKER_SHORT);
        assertThat(firstMarker).isEqualTo(10);
    }

    @Test
    public void calculateMarkerShouldBe11() {
        SignalCalculator signalCalculator = new SignalCalculator();
        int firstMarker = signalCalculator.calculateFirstMarker("zcfzfwzzqfrljwzlrfnpqdbhtmscgvjw", LENGTH_OF_MARKER_SHORT);
        assertThat(firstMarker).isEqualTo(11);
    }

    @Test
    public void calculateCsvExercise1() {
        SignalCsvReader signalCsvReader = new SignalCsvReader();
        int firstMarker =  signalCsvReader.readSignalInput(SECTIONS_FILE_PATH, LENGTH_OF_MARKER_SHORT);
        assertThat(firstMarker).isEqualTo(1566);
    }

    @Test
    public void calculateMarkerShouldBe19() {
        SignalCalculator signalCalculator = new SignalCalculator();
        int firstMarker = signalCalculator.calculateFirstMarker("mjqjpqmgbljsphdztnvjfqwrcgsmlb", LENGTH_OF_MARKER_LONG);
        assertThat(firstMarker).isEqualTo(19);
    }

    @Test
    public void calculateMarkerShouldBe23() {
        SignalCalculator signalCalculator = new SignalCalculator();
        int firstMarker = signalCalculator.calculateFirstMarker("bvwbjplbgvbhsrlpgdmjqwftvncz", LENGTH_OF_MARKER_LONG);
        assertThat(firstMarker).isEqualTo(23);
    }

    @Test
    public void calculateCsvExercise2() {
        SignalCsvReader signalCsvReader = new SignalCsvReader();
        int firstMarker = signalCsvReader.readSignalInput(SECTIONS_FILE_PATH, LENGTH_OF_MARKER_LONG);
        assertThat(firstMarker).isEqualTo(2265);
    }
}
