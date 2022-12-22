package advent.of.code.day1.model;

public class Elf {
    private int totalCalories = 0;

    public void addCalories(int calories) {
        totalCalories = totalCalories + calories;
    }

    public int getTotalCalories() {
        return totalCalories;
    }
}
