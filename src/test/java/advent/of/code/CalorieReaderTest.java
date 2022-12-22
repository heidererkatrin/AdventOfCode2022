package advent.of.code;

import advent.of.code.day1.CalorieCsvReader;
import advent.of.code.day1.ElfStorage;
import advent.of.code.day1.model.Elf;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class CalorieReaderTest {

    public static final String CALORIES_FILE_PATH = "C:\\dev\\AdventOfCode2022\\src\\test\\resources\\Calories.csv";
    public static final int EXPECTED_HIGHEST_CALORIE_ELF = 69206;
    public static final int EXPECTED_HIGHEST_3_CALORIE_ELFS = 197400;

    @Test
    public void readCaloriesInput() {
        //Arrange
        ElfStorage elfStorage = new ElfStorage();
        CalorieCsvReader reader = new CalorieCsvReader(CALORIES_FILE_PATH);
        //Act
        reader.readElfCalories(elfStorage);
        //Assert
        assertThat(elfStorage.getElfList()).isNotNull();
        assertThat(elfStorage.getElfList()).isNotEmpty();
    }


    @Test
    public void readHighestCalorieElf() {
        ElfStorage elfStorage = new ElfStorage();
        CalorieCsvReader reader = new CalorieCsvReader(CALORIES_FILE_PATH);
        reader.readElfCalories(elfStorage);

        assertThat(elfStorage.getHighestCalorieElf().getTotalCalories()).isEqualTo(EXPECTED_HIGHEST_CALORIE_ELF);
        assertThat(elfStorage.getElfList().get(0).getTotalCalories()).isEqualTo(elfStorage.getHighestCalorieElf().getTotalCalories());
    }

    @Test
    public void readThreeHighestCalorieElfs() {
        ElfStorage elfStorage = new ElfStorage();
        CalorieCsvReader reader = new CalorieCsvReader(CALORIES_FILE_PATH);
        reader.readElfCalories(elfStorage);

        List<Elf> elfList = elfStorage.getElfList();
        int sum = elfList.get(0).getTotalCalories() + elfList.get(1).getTotalCalories() + elfList.get(2).getTotalCalories();

        assertThat(sum).isEqualTo(EXPECTED_HIGHEST_3_CALORIE_ELFS);
        assertThat(elfStorage.getHighestCalorieElfs(3)
                .stream()
                .mapToInt(Elf::getTotalCalories)
                .sum())
                .isEqualTo(EXPECTED_HIGHEST_3_CALORIE_ELFS);
    }
}
