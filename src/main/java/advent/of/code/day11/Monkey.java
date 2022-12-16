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

    public int getMonkeyIndex() {
        return monkeyIndex;
    }

    public void addItemWithWorryLevel(Item itemWorryLevel){
        items.add(itemWorryLevel);
    }

    public List<Item> getItems() {
        return items;
    }

    public void clearItemList() {
        items.clear();
    }

    public void setOperation(Operation operation) {
        this.currentOperation = operation;
    }

    public Operation getCurrentOperation() {
        return currentOperation;
    }

    public void setMonkeyDecision(MonkeyDecision monkeyDecision) {
        this.monkeyDecision = monkeyDecision;
    }

    public MonkeyDecision getMonkeyDecision() {
        return monkeyDecision;
    }

    public void increaseInspectionCounter(){
        monkeyInspectsItem += 1;
    }

    public int getMonkeyInspectsItem() {
        return monkeyInspectsItem;
    }
}
