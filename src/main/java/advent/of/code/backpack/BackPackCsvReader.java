package advent.of.code.backpack;

import advent.of.code.calories.ElfStorage;
import advent.of.code.model.Elf;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class BackPackCsvReader {
    private final String filePath;

    public BackPackCsvReader(String filePath) {
        this.filePath = filePath;
    }

    public int readBackpackItems() {
        String line = "";
        int sum = 0;
        BackPackSorter backPackSorter = new BackPackSorter();
        try {
            BufferedReader br = new BufferedReader(new FileReader(filePath));
            while ((line = br.readLine()) != null) {
                sum = sum + backPackSorter.getSharedItem(line);
                System.out.println("Sum is: " + sum);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return sum;
    }

    public int readGroupBackpackItems() {
        String line = "";
        int sum = 0;
        BackPackSorter backPackSorter = new BackPackSorter();
        try {
            BufferedReader br = new BufferedReader(new FileReader(filePath));
            while ((line = br.readLine()) != null) {
                sum += backPackSorter.getSharedItemGroup(line, br.readLine(), br.readLine());
                System.out.println("Sum is: " + sum);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return sum;
    }
}
