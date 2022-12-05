package advent.of.code.rockpaperscissor;

import advent.of.code.calories.Printer;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class RockPaperScissorsCsvReader {
    private final String filePath;

    public RockPaperScissorsCsvReader(String filePath) {
        this.filePath = filePath;
    }

    public int readRockPaperScissorsInput() {
        String line = "";
        int score = 0;
        RockPaperScissors rockPaperScissors = new RockPaperScissors();
        Printer printer = new Printer();
        int lineNumber=0;
        try {
            BufferedReader br = new BufferedReader(new FileReader(filePath));
            while ((br.readLine()) != null) {
                lineNumber++;
                Draw opponentDraw = Draw.getByOpponentCode(line.substring(0, 1));
                Draw myDraw = Draw.getByMyCode(line.substring(2, 3));
                if (opponentDraw == null || myDraw == null) {
                    throw new IllegalStateException("Unexpected value: " + opponentDraw + " " + myDraw);
                }
                int individualScore= rockPaperScissors.runGame(opponentDraw, myDraw);
                score +=individualScore;
                printer.printDraws(opponentDraw, myDraw, individualScore, score, lineNumber);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return score;
    }


    public int readRockPaperScissorsByAction() {
        String line = "";
        int score = 0;
        RockPaperScissors rockPaperScissors = new RockPaperScissors();
        Printer printer = new Printer();
        int lineNumber=0;
        try {
            BufferedReader br = new BufferedReader(new FileReader(filePath));
            while ((line = br.readLine()) != null) {
                lineNumber++;
                Draw opponentDraw = Draw.getByOpponentCode(line.substring(0, 1));
                Outcome outcome = Outcome.getByCode(line.substring(2, 3));
                if (opponentDraw == null || outcome == null) {
                    throw new IllegalStateException("Unexpected value: " + opponentDraw + " " + outcome);
                }
                Draw myDraw = rockPaperScissors.getDrawByOutcome(opponentDraw, outcome);
                int individualScore= rockPaperScissors.runGame(opponentDraw, myDraw);
                score +=individualScore;
                printer.printDraws(opponentDraw, myDraw, individualScore, score, lineNumber);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return score;
    }
}
