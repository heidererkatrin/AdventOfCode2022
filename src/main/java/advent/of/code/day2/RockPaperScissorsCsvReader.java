package advent.of.code.day2;

import advent.of.code.day1.Printer;

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
        try {
            BufferedReader br = new BufferedReader(new FileReader(filePath));
            while ((line = br.readLine()) != null && line.length() > 0) {
                Draw opponentDraw = Draw.getByOpponentCode(line.substring(0, 1));
                Draw myDraw = Draw.getByMyCode(line.substring(2, 3));
                score += rockPaperScissors.runGame(opponentDraw, myDraw);
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
        try {
            BufferedReader br = new BufferedReader(new FileReader(filePath));
            while ((line = br.readLine()) != null) {
                Draw opponentDraw = Draw.getByOpponentCode(line.substring(0, 1));
                Outcome outcome = Outcome.getByCode(line.substring(2, 3));
                Draw myDraw = rockPaperScissors.getDrawByOutcome(opponentDraw, outcome);
                score += rockPaperScissors.runGame(opponentDraw, myDraw);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return score;
    }
}
