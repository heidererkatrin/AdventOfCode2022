package advent.of.code.signal;

import advent.of.code.sections.SectionCalculator;

import java.io.BufferedReader;
import java.io.FileReader;

public class SignalCsvReader {

    public int readSignalInput(String filePath, int lengthOfMarker) {
        String line = "";
        StringBuilder builder = new StringBuilder();
        SignalCalculator signalCalculator= new SignalCalculator();
        try {
            BufferedReader br = new BufferedReader(new FileReader(filePath));
            while ((line = br.readLine()) != null) {
                builder.append(line);
            }
            return signalCalculator.calculateFirstMarker(builder.toString(), lengthOfMarker);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return 0;
    }
}
