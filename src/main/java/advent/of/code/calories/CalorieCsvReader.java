package advent.of.code.calories;

import advent.of.code.model.Elf;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class CalorieCsvReader {
    private final String filePath;

    public CalorieCsvReader(String filePath) {
        this.filePath = filePath;
    }

    public void readElfCalories(ElfStorage elfStorage) {
        String line = "";
        Elf elf = new Elf();
        elfStorage.addNewElf(elf);
        try {
            BufferedReader br = new BufferedReader(new FileReader(filePath));
            while ((line = br.readLine()) != null) {
                if (line.equals("")) {
                    elf = new Elf();
                    elfStorage.addNewElf(elf);
                } else {
                    elf.addCalories(Integer.parseInt(line.trim()));
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
