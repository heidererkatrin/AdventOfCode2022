package advent.of.code.rockpaperscissor;

public class RockPaperScissors {

    private static final int WIN_SCORE = 6;
    private static final int DRAW_SCORE = 3;

    public int runGame(Draw opponentDraw, Draw myDraw) {
        if (myDraw.getName().equals(opponentDraw.getWinAgainst())) {
            return WIN_SCORE + myDraw.getScore();
        } else if (myDraw.equals(opponentDraw)) {
            return DRAW_SCORE + myDraw.getScore();
        } else {
            return myDraw.getScore();
        }
    }

    public Draw getDrawByOutcome(Draw opponentDraw, Outcome outcome) {
        switch (outcome) {
            case WIN:
                return Draw.getByName(opponentDraw.getWinAgainst());
            case LOSE:
                return Draw.getLoosing(opponentDraw.getName(), opponentDraw.getWinAgainst());
            case DRAW:
                return opponentDraw;
        }
        return null;
    }
}
