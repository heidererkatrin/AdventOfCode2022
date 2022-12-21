package advent.of.code.day11;

import java.math.BigDecimal;

public class Operation {
    private final Operator operator;
    private final Integer operand;

    public Operation(Operator operator, Integer operand) {
        this.operator = operator;
        this.operand = operand;
    }

    public BigDecimal calculateWorryLevel(BigDecimal startingWorryLevel) {
        switch (operator) {
            case ADD -> {
                return calculateAdd(startingWorryLevel);
            }
            case MULTIPLY -> {
                return calculateMultiplay(startingWorryLevel);
            }
            default -> throw new IllegalStateException("Unexpected value: " + operator);
        }
    }

    private BigDecimal calculateMultiplay(BigDecimal startingWorryLevel) {
        BigDecimal increasedWorryLevel;
        if (operand == null) {
            increasedWorryLevel = startingWorryLevel.multiply(startingWorryLevel);
        } else {
            increasedWorryLevel = startingWorryLevel.multiply(BigDecimal.valueOf(operand));
        }
        System.out.println("Worry level is multiplied by " + operand + " to " + increasedWorryLevel);
        return increasedWorryLevel;
    }

    private BigDecimal calculateAdd(BigDecimal startingWorryLevel) {
        BigDecimal increasedWorryLevel;
        if (operand == null) {
            increasedWorryLevel = startingWorryLevel.add(startingWorryLevel);
        } else {
            increasedWorryLevel = startingWorryLevel.add(BigDecimal.valueOf(operand));
        }
        System.out.println("Worry level increases by " + operand + " to " + increasedWorryLevel);
        return increasedWorryLevel;
    }
}
