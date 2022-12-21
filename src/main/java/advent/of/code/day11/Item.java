package advent.of.code.day11;

import java.math.BigDecimal;

public class Item {
    private final BigDecimal worryLevel;

    public Item(int worryLevel) {
        this.worryLevel = BigDecimal.valueOf(worryLevel);
    }

    public BigDecimal getWorryLevel() {
        return worryLevel;
    }
}
