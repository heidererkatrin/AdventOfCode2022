package advent.of.code.day2;

public enum Outcome {
    DRAW ("Y"),
    LOSE("X"),
    WIN("Z");

    private final String code;

    Outcome(String code) {
        this.code = code;
    }

    public static Outcome getByCode(String code) {
        for(Outcome e : values()) {
            if(e.code.equals(code)) return e;
        }
        return null;
    }
}
