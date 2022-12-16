package advent.of.code.day11;

import advent.of.code.rockpaperscissor.Draw;

public enum Operator {
    ADD("+"),
    MULTIPLY("*");

    String code;

    Operator(String code) {
        this.code = code;
    }

    public static Operator getCodeByOperator(String code) {
        for (Operator e : values()) {
            if (e.code.equals(code)) return e;
        }
        return null;
    }

}
