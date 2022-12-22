package advent.of.code.day10;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class VideoSignalReader {
    private final String filePath;

    public VideoSignalReader(String filePath) {
        this.filePath = filePath;
    }

    public VideoSignal readVideoSignal(int startCycle, int numOfCycles) {
        String line = "";
        int lineNumber = 0;
        VideoSignal videoSignal = new VideoSignal(new Sprite(), new Cycle());
        try {
            BufferedReader br = new BufferedReader(new FileReader(filePath));
            while ((line = br.readLine()) != null) {
                lineNumber++;
                if (lineNumber >= startCycle && lineNumber <= numOfCycles){
                    videoSignal.readInput(line);
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return videoSignal;
    }

    public VideoSignal readVideoSignal() {
      return readVideoSignal(0,240);
    }


}
