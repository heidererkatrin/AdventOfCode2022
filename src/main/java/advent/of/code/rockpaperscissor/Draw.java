package advent.of.code.rockpaperscissor;

public enum Draw {
    ROCK("ROCK", "A", "X", 1, "PAPER"),
    PAPER("PAPER", "B", "Y", 2, "SCISSORS"),
    SCISSORS("SCISSORS", "C", "Z", 3, "ROCK");

    private final String name;
    private final String opponentCode;
    private final String myCode;
    private final int score;
    private final String winAgainst;

    Draw(String name, String opponentCode, String myCode, int score, String winAgainst) {
        this.name = name;
        this.opponentCode = opponentCode;
        this.myCode = myCode;
        this.score = score;
        this.winAgainst = winAgainst;
    }

    public static Draw getByOpponentCode(String code) {
        for (Draw e : values()) {
            if (e.opponentCode.equals(code)) return e;
        }
        return null;
    }

    public static Draw getLoosing(String draw, String win) {
        for (Draw e : values()) {
            if (!e.name.equals(draw) && !e.name.equals(win)) {
                return e;
            }
        }
        return null;
    }

    public static Draw getByName(String name) {
        for (Draw e : values()) {
            if (e.name.equals(name)) return e;
        }
        return null;
    }

    public static Draw getByMyCode(String myCode) {
        for (Draw e : values()) {
            if (e.myCode.equals(myCode)) return e;
        }
        return null;
    }

    public String getName() {
        return name;
    }

    public String getWinAgainst() {
        return winAgainst;
    }

    public int getScore() {
        return score;
    }
}
