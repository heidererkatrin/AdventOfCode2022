package advent.of.code.day14;

import java.io.BufferedReader;
import java.io.FileReader;

public class RockCsvReader {

    public RockBlueprint readInput(String sandMapFilePath) {
        String line = "";
        RockBlueprint rockBlueprint = new RockBlueprint();
        try {
            BufferedReader br = new BufferedReader(new FileReader(sandMapFilePath));
            while ((line = br.readLine()) != null) {
                rockBlueprint.addLine(line);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return rockBlueprint;
    }
}
