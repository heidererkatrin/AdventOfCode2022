package advent.of.code.day11;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.HashMap;
import java.util.List;

public class MonkeyThrowCalculator {
    private final HashMap<Integer, Monkey> monkeyMap = new HashMap<>();
    private boolean decreaseBoringLevel = true;

    public void doMonkeyBusiness(int amountRounds) {
        for (int start = 1; start<=amountRounds; start++){
            doMonkeyBusiness();
        }
    }

    public void doMonkeyBusiness() {
        for (Monkey monkey : monkeyMap.values()) {
            runThrowingCalculation(monkey);
        }
    }

    public void runThrowingCalculation(Monkey monkey) {
        System.out.println("Monkey:" + monkey.getMonkeyIndex());
        for (Item item : monkey.getItems()) {
            System.out.println("Monkey inspects an item with a worry level of " + item.getWorryLevel());
            BigDecimal increasedWorryLevel = monkey.getCurrentOperation().calculateWorryLevel(item.getWorryLevel());
            BigDecimal decreaseBoringWorryLevel = increasedWorryLevel;
            if (decreaseBoringLevel) {
                decreaseBoringWorryLevel =increasedWorryLevel
                        .divide(new BigDecimal(3), 0, RoundingMode.DOWN);
                System.out.println("Monkey gets bored with item. Worry level is divided by 3 to " + decreaseBoringWorryLevel);
            }

            int nextMonkey = monkey.getMonkeyDecision().calculateNextMonkey(decreaseBoringWorryLevel.intValue());
            monkeyMap.get(nextMonkey).addItemWithWorryLevel(new Item(decreaseBoringWorryLevel.intValue()));

            monkey.increaseInspectionCounter();
            System.out.println("----------------------------");
        }
        monkey.clearItemList();
    }

    public void disableStressRelieve(){
        decreaseBoringLevel = false;
    }


    public void setMonkeys(List<Monkey> monkeys) {
        monkeys.forEach(monkey -> monkeyMap.put(monkey.getMonkeyIndex(), monkey));
    }

    public Monkey getMonkeyByID(int id) {
        return monkeyMap.get(id);
    }
}
