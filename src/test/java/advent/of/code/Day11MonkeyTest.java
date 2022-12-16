package advent.of.code;

import advent.of.code.day11.*;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

public class Day11MonkeyTest {


    @Test
    void readEnumValue() {
        Operator operatorMultiply = Operator.getCodeByOperator("*");
        Operator operatorAdd = Operator.getCodeByOperator("+");
    }

    @Test
    void oneRoundMonkeyHasSpecificWorryLevels() {
        Monkey monkey = new Monkey(1);
        monkey.addItemWithWorryLevel(new Item(79));
        monkey.addItemWithWorryLevel(new Item(98));
        monkey.setOperation(new Operation(Operator.MULTIPLY, 19));
        monkey.setMonkeyDecision(new MonkeyDecision(23, 2, 3));

        MonkeyThrowCalculator monkeyThrowCalculator = new MonkeyThrowCalculator();
        monkeyThrowCalculator.setMonkeys(Arrays.asList(monkey, new Monkey(2), new Monkey(3)));

        monkeyThrowCalculator.runThrowingCalculation(monkey);
        Monkey monkey3 = monkeyThrowCalculator.getMonkeyByID(3);

        Assertions.assertThat(monkey3.getItems()).hasSize(2);
        Assertions.assertThat(monkey3.getItems().get(0).getWorryLevel()).isEqualTo(500);
        Assertions.assertThat(monkey3.getItems().get(1).getWorryLevel()).isEqualTo(620);
    }

    @Test
    void fourRoundMonkeysShouldHaveSpecificLevels() {
        Monkey monkey = new MonkeyBuilder(0, Arrays.asList(new Item(79), new Item(98)), Operator.MULTIPLY, 19, 23, 2, 3);
        Monkey monkey1 = new MonkeyBuilder(1, Arrays.asList(new Item(54), new Item(65), new Item(75), new Item(74)), Operator.ADD, 6, 19, 2, 0);
        Monkey monkey2 = new MonkeyBuilder(2, Arrays.asList(new Item(79), new Item(60), new Item(97)), Operator.MULTIPLY, null, 13, 1, 3);
        Monkey monkey3 = new MonkeyBuilder(3, Arrays.asList(new Item(74)), Operator.ADD, 3, 17, 0, 1);

        MonkeyThrowCalculator monkeyThrowCalculator = new MonkeyThrowCalculator();
        monkeyThrowCalculator.setMonkeys(Arrays.asList(monkey, monkey1, monkey2, monkey3));

        monkeyThrowCalculator.doMonkeyBusiness();

        Assertions.assertThat(monkey.getItems()).hasSize(4);
        Assertions.assertThat(monkey1.getItems()).hasSize(6);
        Assertions.assertThat(monkey2.getItems()).hasSize(0);
        Assertions.assertThat(monkey3.getItems()).hasSize(0);
    }

    @Test
    void multipleRoundMonkeysShouldHaveSpecificLevels() {
        Monkey monkey = new MonkeyBuilder(0, Arrays.asList(new Item(79), new Item(98)), Operator.MULTIPLY, 19, 23, 2, 3);
        Monkey monkey1 = new MonkeyBuilder(1, Arrays.asList(new Item(54), new Item(65), new Item(75), new Item(74)), Operator.ADD, 6, 19, 2, 0);
        Monkey monkey2 = new MonkeyBuilder(2, Arrays.asList(new Item(79), new Item(60), new Item(97)), Operator.MULTIPLY, null, 13, 1, 3);
        Monkey monkey3 = new MonkeyBuilder(3, Arrays.asList(new Item(74)), Operator.ADD, 3, 17, 0, 1);

        MonkeyThrowCalculator monkeyThrowCalculator = new MonkeyThrowCalculator();
        monkeyThrowCalculator.setMonkeys(Arrays.asList(monkey, monkey1, monkey2, monkey3));

        monkeyThrowCalculator.doMonkeyBusiness(20);

        Assertions.assertThat(monkey.getItems()).hasSize(5);
        Assertions.assertThat(monkey1.getItems()).hasSize(5);
        Assertions.assertThat(monkey2.getItems()).hasSize(0);
        Assertions.assertThat(monkey3.getItems()).hasSize(0);

        Assertions.assertThat(monkey.getMonkeyInspectsItem()).isEqualTo(101);
        Assertions.assertThat(monkey1.getMonkeyInspectsItem()).isEqualTo(95);
        Assertions.assertThat(monkey2.getMonkeyInspectsItem()).isEqualTo(7);
        Assertions.assertThat(monkey3.getMonkeyInspectsItem()).isEqualTo(105);

    }

    @Test
    void allRoundsMonkeys() {
        Monkey monkey = new MonkeyBuilder(0, Arrays.asList(new Item(63), new Item(57)), Operator.MULTIPLY, 11, 7, 6,2);
        Monkey monkey1 = new MonkeyBuilder(1, Arrays.asList(new Item(82), new Item(66), new Item(87), new Item(78), new Item(77), new Item(92), new Item(83)), Operator.ADD, 1, 11, 5, 0);
        Monkey monkey2 = new MonkeyBuilder(2, Arrays.asList(new Item(97), new Item(53), new Item(53), new Item(85), new Item(58), new Item(54)), Operator.MULTIPLY, 7, 13, 4, 3);
        Monkey monkey3 = new MonkeyBuilder(3, Arrays.asList(new Item(50)), Operator.ADD, 3, 3, 1, 7);

        Monkey monkey4 = new MonkeyBuilder(4, Arrays.asList(new Item(64), new Item(69),new Item(52), new Item(65), new Item(73)), Operator.ADD, 6, 17, 3,7);
        Monkey monkey5 = new MonkeyBuilder(5, Arrays.asList(new Item(57), new Item(91), new Item(65)), Operator.ADD, 5, 2, 0, 6);
        Monkey monkey6 = new MonkeyBuilder(6, Arrays.asList(new Item(67), new Item(91), new Item(84), new Item(78), new Item(60), new Item(69), new Item(99), new Item(83)), Operator.MULTIPLY, null, 5, 2, 4);
        Monkey monkey7 = new MonkeyBuilder(7, Arrays.asList(new Item(58),new Item(78), new Item(69), new Item(65)), Operator.ADD, 7, 19, 5, 1);


        MonkeyThrowCalculator monkeyThrowCalculator = new MonkeyThrowCalculator();
        monkeyThrowCalculator.setMonkeys(Arrays.asList(monkey, monkey1, monkey2, monkey3, monkey4, monkey5, monkey6, monkey7));
        monkeyThrowCalculator.disableStressRelieve();

        monkeyThrowCalculator.doMonkeyBusiness(20);

        Assertions.assertThat(monkey.getMonkeyInspectsItem()).isEqualTo(313);
        Assertions.assertThat(monkey1.getMonkeyInspectsItem()).isEqualTo(338);
        Assertions.assertThat(monkey2.getMonkeyInspectsItem()).isEqualTo(319);
        Assertions.assertThat(monkey3.getMonkeyInspectsItem()).isEqualTo(314);
        Assertions.assertThat(monkey4.getMonkeyInspectsItem()).isEqualTo(30);
        Assertions.assertThat(monkey5.getMonkeyInspectsItem()).isEqualTo(19);
        Assertions.assertThat(monkey6.getMonkeyInspectsItem()).isEqualTo(38);
        Assertions.assertThat(monkey7.getMonkeyInspectsItem()).isEqualTo(101);

    }

    @Test
    void round10000RoundsMonkeys() {
        Monkey monkey = new MonkeyBuilder(0, Arrays.asList(new Item(63), new Item(57)), Operator.MULTIPLY, 11, 7, 6,2);
        Monkey monkey1 = new MonkeyBuilder(1, Arrays.asList(new Item(82), new Item(66), new Item(87), new Item(78), new Item(77), new Item(92), new Item(83)), Operator.ADD, 1, 11, 5, 0);
        Monkey monkey2 = new MonkeyBuilder(2, Arrays.asList(new Item(97), new Item(53), new Item(53), new Item(85), new Item(58), new Item(54)), Operator.MULTIPLY, 7, 13, 4, 3);
        Monkey monkey3 = new MonkeyBuilder(3, Arrays.asList(new Item(50)), Operator.ADD, 3, 3, 1, 7);

        Monkey monkey4 = new MonkeyBuilder(4, Arrays.asList(new Item(64), new Item(69),new Item(52), new Item(65), new Item(73)), Operator.ADD, 6, 17, 3,7);
        Monkey monkey5 = new MonkeyBuilder(5, Arrays.asList(new Item(57), new Item(91), new Item(65)), Operator.ADD, 5, 2, 0, 6);
        Monkey monkey6 = new MonkeyBuilder(6, Arrays.asList(new Item(67), new Item(91), new Item(84), new Item(78), new Item(60), new Item(69), new Item(99), new Item(83)), Operator.MULTIPLY, null, 5, 2, 4);
        Monkey monkey7 = new MonkeyBuilder(7, Arrays.asList(new Item(58),new Item(78), new Item(69), new Item(65)), Operator.ADD, 7, 19, 5, 1);


        MonkeyThrowCalculator monkeyThrowCalculator = new MonkeyThrowCalculator();
        monkeyThrowCalculator.disableStressRelieve();
        monkeyThrowCalculator.setMonkeys(Arrays.asList(monkey, monkey1, monkey2, monkey3, monkey4, monkey5, monkey6, monkey7));

        monkeyThrowCalculator.doMonkeyBusiness(10000);

        Assertions.assertThat(monkey.getMonkeyInspectsItem()).isEqualTo(157397);
        Assertions.assertThat(monkey1.getMonkeyInspectsItem()).isEqualTo(161047);
        Assertions.assertThat(monkey2.getMonkeyInspectsItem()).isEqualTo(141343);
        Assertions.assertThat(monkey3.getMonkeyInspectsItem()).isEqualTo(132697);
        Assertions.assertThat(monkey4.getMonkeyInspectsItem()).isEqualTo(37118);
        Assertions.assertThat(monkey5.getMonkeyInspectsItem()).isEqualTo(20733);
        Assertions.assertThat(monkey6.getMonkeyInspectsItem()).isEqualTo(32769);
        Assertions.assertThat(monkey7.getMonkeyInspectsItem()).isEqualTo(123153);

        //25348314659 false

    }

    @Test
    void multipleRoundMonkeysShouldHaveSpecificLevelsWithoutStressRelieve() {
        Monkey monkey = new MonkeyBuilder(0, Arrays.asList(new Item(79), new Item(98)), Operator.MULTIPLY, 19, 23, 2, 3);
        Monkey monkey1 = new MonkeyBuilder(1, Arrays.asList(new Item(54), new Item(65), new Item(75), new Item(74)), Operator.ADD, 6, 19, 2, 0);
        Monkey monkey2 = new MonkeyBuilder(2, Arrays.asList(new Item(79), new Item(60), new Item(97)), Operator.MULTIPLY, null, 13, 1, 3);
        Monkey monkey3 = new MonkeyBuilder(3, Arrays.asList(new Item(74)), Operator.ADD, 3, 17, 0, 1);

        MonkeyThrowCalculator monkeyThrowCalculator = new MonkeyThrowCalculator();
        monkeyThrowCalculator.disableStressRelieve();
        monkeyThrowCalculator.setMonkeys(Arrays.asList(monkey, monkey1, monkey2, monkey3));

        monkeyThrowCalculator.doMonkeyBusiness(20);

        Assertions.assertThat(monkey.getMonkeyInspectsItem()).isEqualTo(99);
        Assertions.assertThat(monkey1.getMonkeyInspectsItem()).isEqualTo(97);
        Assertions.assertThat(monkey2.getMonkeyInspectsItem()).isEqualTo(8);
        Assertions.assertThat(monkey3.getMonkeyInspectsItem()).isEqualTo(103);

    }

    private static class MonkeyBuilder extends Monkey {
        public MonkeyBuilder(int monkeyIndex, List<Item> items, Operator operator, Integer operand, int divisibleBy, int nextTrueMonkey, int nextFalseMonkey) {
            super(monkeyIndex);
            setOperation(new Operation(operator, operand));
            setMonkeyDecision(new MonkeyDecision(divisibleBy, nextTrueMonkey, nextFalseMonkey));
            items.forEach(this::addItemWithWorryLevel);
        }
    }
}
