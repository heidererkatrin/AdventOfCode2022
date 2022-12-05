package advent.of.code.sections;

import java.io.BufferedReader;
import java.io.FileReader;

public class SectionCsvReader {

    public int readAllSectionsHardOverlap(String filePath) {
        String line = "";
        int sum = 0;
        SectionCalculator sectionCalculator = new SectionCalculator();
        try {
            BufferedReader br = new BufferedReader(new FileReader(filePath));
            while ((line = br.readLine()) != null) {
                String[] split = line.split(",");
                if (sectionCalculator.isHardOverlap(sectionCalculator.calculateSections(split[0]), sectionCalculator.calculateSections(split[1]))){
                    sum = sum + 1;
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return sum;
    }

    public int readAllSectionsSoftOverlap(String filePath) {
        String line = "";
        int sum = 0;
        SectionCalculator sectionCalculator = new SectionCalculator();
        try {
            BufferedReader br = new BufferedReader(new FileReader(filePath));
            while ((line = br.readLine()) != null) {
                String[] split = line.split(",");
                if (sectionCalculator.isSoftOverlap(sectionCalculator.calculateSections(split[0]), sectionCalculator.calculateSections(split[1]))){
                    sum = sum + 1;
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return sum;
    }
}
