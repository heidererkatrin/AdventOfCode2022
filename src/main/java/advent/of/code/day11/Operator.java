package advent.of.code.day11;

public enum Operator {
    ADD("+"),
    MULTIPLY("*");

    final String code;

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
