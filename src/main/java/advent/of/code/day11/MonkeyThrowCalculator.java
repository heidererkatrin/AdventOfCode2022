package advent.of.code.day11;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.HashMap;
import java.util.List;

public class MonkeyThrowCalculator {
    private final HashMap<Integer, Monkey> monkeyMap = new HashMap<>();
    private boolean decreaseBoringLevel = true;

    public void doMonkeyBusiness(int amountRounds) {
        for (int start = 1; start <= amountRounds; start++) {
            doMonkeyBusiness();
        }
    }
    private void doMonkeyBusiness() {
        monkeyMap.values().forEach(this::runThrowingCalculation);
    }

    public void runThrowingCalculation(Monkey monkey) {
        System.out.println("Monkey:" + monkey.getMonkeyIndex());
        for (Item item : monkey.getItems()) {
            System.out.println("Monkey inspects an item with a worry level of " + item.getWorryLevel());
            BigDecimal increasedWorryLevel = monkey.getCurrentOperation().calculateWorryLevel(item.getWorryLevel());
            if (decreaseBoringLevel) {
                increasedWorryLevel = increasedWorryLevel
                        .divide(new BigDecimal(3), 0, RoundingMode.DOWN);
                System.out.println("Monkey gets bored with item. Worry level is divided by 3 to " + increasedWorryLevel);
            }

            int nextMonkey = monkey.getMonkeyDecision().calculateNextMonkey(increasedWorryLevel.intValue());
            getMonkeyByID(nextMonkey).addItemWithWorryLevel(new Item(increasedWorryLevel.intValue()));

            monkey.increaseInspectionCounter();
            System.out.println("----------------------------");
        }
        monkey.clearItemList();
    }

    public void disableStressRelieve() {
        decreaseBoringLevel = false;
    }


    public void setMonkeys(List<Monkey> monkeys) {
        monkeys.forEach(monkey -> monkeyMap.put(monkey.getMonkeyIndex(), monkey));
    }

    public Monkey getMonkeyByID(int id) {
        return monkeyMap.get(id);
    }
}
