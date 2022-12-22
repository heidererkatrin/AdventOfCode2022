package advent.of.code.day11;

import java.util.ArrayList;
import java.util.List;

public class Monkey {
    private final int monkeyIndex;
    private final List<Item> items = new ArrayList<>();
    private int monkeyInspectsItem = 0;

    private MonkeyDecision monkeyDecision;
    private Operation currentOperation;

    public Monkey(int monkeyIndex) {
        this.monkeyIndex = monkeyIndex;
    }

    public Monkey(int monkeyIndex, MonkeyDecision monkeyDecision, Operation currentOperation) {
        this.monkeyIndex = monkeyIndex;
        this.monkeyDecision = monkeyDecision;
        this.currentOperation = currentOperation;
    }

    public void clearItemList() {
        items.clear();
    }

    public void increaseInspectionCounter(){
        monkeyInspectsItem += 1;
    }

    public void addItemWithWorryLevel(Item itemWorryLevel){
        items.add(itemWorryLevel);
    }

    public int getMonkeyIndex() {
        return monkeyIndex;
    }

    public List<Item> getItems() {
        return items;
    }

    public Operation getCurrentOperation() {
        return currentOperation;
    }

    public MonkeyDecision getMonkeyDecision() {
        return monkeyDecision;
    }

    public int getMonkeyInspectsItem() {
        return monkeyInspectsItem;
    }
}
