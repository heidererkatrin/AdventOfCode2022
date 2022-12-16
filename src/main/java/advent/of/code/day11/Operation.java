package advent.of.code.day11;

import java.math.BigDecimal;
import java.math.BigInteger;

public class Operation {
    private Operator operator;
    private Integer operand;

    public Operation(Operator operator, Integer operand) {
        this.operator = operator;
        this.operand = operand;
    }

    public BigDecimal calculateWorryLevel(BigDecimal startingWorryLevel){
        switch (operator){
            case ADD -> {
                BigDecimal increasedWorryLevel;
                if (operand == null){
                    increasedWorryLevel = startingWorryLevel.add(startingWorryLevel);
                }
                else{
                    increasedWorryLevel = startingWorryLevel.add(BigDecimal.valueOf(operand));
                }
                System.out.println("Worry level increases by " + operand + " to " + increasedWorryLevel);
                return increasedWorryLevel;
            }
            case MULTIPLY -> {
                BigDecimal increasedWorryLevel;
                if (operand == null){
                    increasedWorryLevel = startingWorryLevel.multiply(startingWorryLevel);
                }
                else{
                    increasedWorryLevel = startingWorryLevel.multiply(BigDecimal.valueOf(operand));
                }
                System.out.println("Worry level is multiplied by " + operand + " to " + increasedWorryLevel);
                return increasedWorryLevel;
            }
            default -> throw new IllegalStateException("Unexpected value: " + operator);
        }
    }

    public Operator getOperator() {
        return operator;
    }

    public int getOperand() {
        return operand;
    }
}
