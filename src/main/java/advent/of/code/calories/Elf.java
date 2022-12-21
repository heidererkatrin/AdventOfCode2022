package advent.of.code.calories;

public class Elf {
    private int totalCalories = 0;

    public void addCalories(int calories) {
        totalCalories = totalCalories + calories;
    }

    public int getTotalCalories() {
        return totalCalories;
    }
}
