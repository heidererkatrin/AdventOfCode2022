package advent.of.code;

import advent.of.code.backpack.BackPackCsvReader;
import advent.of.code.backpack.BackPackSorter;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class BackPackTest {
    public static final String CALORIES_FILE_PATH = "C:\\dev\\AdventOfCode2022\\src\\test\\resources\\BackPack.csv";

    @Test
    public void priorityFirstItemShouldBe16() throws Exception {
        BackPackSorter backPackSorter = new BackPackSorter();
        assertThat(16).isEqualTo(backPackSorter.getSharedItem("vJrwpWtwJgWrhcsFMMfFFhFp"));
    }

    @Test
    public void priorityFirstItemShouldBe38() throws Exception {
        BackPackSorter backPackSorter = new BackPackSorter();
        assertThat(38).isEqualTo(backPackSorter.getSharedItem("jqHRNqRjqzjGDLGLrsFMfFZSrLrFZsSL"));
    }

    @Test
    public void priorityFirstItemShouldBe3() throws Exception {
        BackPackSorter backPackSorter = new BackPackSorter();
        assertThat(3).isEqualTo(backPackSorter.getSharedItem("ndlndntsFJntFvccLjjLrjBShcBBfc"));
    }

    @Test
    public void groupBadge() throws Exception {
        BackPackSorter backPackSorter = new BackPackSorter();
        assertThat(18).isEqualTo(backPackSorter.getSharedItemGroup("vJrwpWtwJgWrhcsFMMfFFhFp","jqHRNqRjqzjGDLGLrsFMfFZSrLrFZsSL", "PmmdzqPrVvPwwTWBwg" ));
    }

    @Test
    public void groupBadge2() throws Exception {
        BackPackSorter backPackSorter = new BackPackSorter();
        assertThat(52).isEqualTo(backPackSorter.getSharedItemGroup("wMqvLMZHhHMvwLHjbvcjnnSBnvTQFn","ttgJtRGJQctTZtZT", "CrZsJsPPZsGzwwsLwLmpwMDw" ));
    }

    @Test
    public void allItemsPriority() {
        BackPackCsvReader reader = new BackPackCsvReader(CALORIES_FILE_PATH);
        int sum = reader.readBackpackItems();
        assertThat(sum).isEqualTo(7742);
    }

    @Test
    public void allItemsPriorityGroup() {
        BackPackCsvReader reader = new BackPackCsvReader(CALORIES_FILE_PATH);
        assertThat(reader.readGroupBackpackItems()).isEqualTo(2276);
    }
}
