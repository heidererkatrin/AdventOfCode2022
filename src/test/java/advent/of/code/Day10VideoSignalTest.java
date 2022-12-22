package advent.of.code;

import advent.of.code.day10.Cycle;
import advent.of.code.day10.Sprite;
import advent.of.code.day10.VideoSignal;
import advent.of.code.day10.VideoSignalReader;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class Day10VideoSignalTest {
    public static final String VIDEO_SIGNAL_FILE_PATH_SNIP = "C:\\dev\\AdventOfCode2022\\src\\test\\resources\\Day10VideoSignalSnippet.csv";

    @Test
    public void startVideoSignal(){
        VideoSignal videoSignal = new VideoSignal(new Sprite(), new Cycle());

        videoSignal.readInput("noop");
        videoSignal.readInput("addx 3");
        videoSignal.readInput("addx -5");

        assertThat(videoSignal.getCycle()).isEqualTo(5);
        assertThat(videoSignal.getXRegister()).isEqualTo(-1);
    }

    @Test
    public void startVideoSignalForFirst20Cycles(){
        VideoSignal videoSignal = new VideoSignal(new Sprite(), new Cycle());

        videoSignal.readInput("addx 15");
        videoSignal.readInput("addx -11");
        videoSignal.readInput("addx 6");
        videoSignal.readInput("addx -3");
        videoSignal.readInput("addx 5");
        videoSignal.readInput("addx -1");
        videoSignal.readInput("addx -8");
        videoSignal.readInput("addx 13");
        videoSignal.readInput("addx 4");
        videoSignal.readInput("noop");
        videoSignal.readInput("addx -1");

        String ctrRow = videoSignal.getCtrRow();
        assertThat(ctrRow).isEqualTo("##..##..##..##..##..#");
        assertThat(videoSignal.getCycle()).isEqualTo(21);
        assertThat(videoSignal.getXRegister()).isEqualTo(20);

    }

    @Test
    public void startVideoSignalReadCsv(){
        VideoSignalReader videoSignalReader = new VideoSignalReader(VIDEO_SIGNAL_FILE_PATH_SNIP);
        VideoSignal videoSignal = videoSignalReader.readVideoSignal();

        assertThat(videoSignal.getXRegister()).isEqualTo(37);
        //Ergebnis 15260
    }

    @Test
    public void startVideoSignalReadCsvLineByLine(){
        VideoSignalReader videoSignalReader = new VideoSignalReader(VIDEO_SIGNAL_FILE_PATH_SNIP);
        videoSignalReader.readVideoSignal();
    }
}
