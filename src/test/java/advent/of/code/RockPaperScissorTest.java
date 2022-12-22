package advent.of.code;

import advent.of.code.day2.*;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class RockPaperScissorTest {
    public static final String DRAWS_FILE_PATH = "C:\\dev\\AdventOfCode2022\\src\\test\\resources\\Draws.csv";

    @Test
    public void runRockPaperScissorsRound1() {
        RockPaperScissors rockPaperScissors = new RockPaperScissors();
        int score = rockPaperScissors.runGame(Draw.ROCK, Draw.PAPER);
        assertThat(score).isEqualTo(8);
    }

    @Test
    public void runRockPaperScissorsRound2() {
        RockPaperScissors rockPaperScissors = new RockPaperScissors();
        int score = rockPaperScissors.runGame(Draw.PAPER, Draw.ROCK);
        assertThat(score).isEqualTo(1);
    }

    @Test
    public void runRockPaperScissorsRound3() {
        RockPaperScissors rockPaperScissors = new RockPaperScissors();
        int score = rockPaperScissors.runGame(Draw.SCISSORS, Draw.SCISSORS);
        assertThat(score).isEqualTo(6);
    }

    @Test
    public void runRockPaperScissorsReadCsvData() {
        RockPaperScissorsCsvReader reader = new RockPaperScissorsCsvReader(DRAWS_FILE_PATH);
        int score = reader.readRockPaperScissorsInput();
        assertThat(score).isEqualTo(11603);
    }


    @Test
    public void runRockPaperScissorsNumbers() {
        RockPaperScissors rockPaperScissors = new RockPaperScissors();
        int score = rockPaperScissors.runGame(Draw.PAPER, Draw.PAPER);
        score += rockPaperScissors.runGame(Draw.ROCK, Draw.SCISSORS);
        score += rockPaperScissors.runGame(Draw.ROCK, Draw.SCISSORS);
        score += rockPaperScissors.runGame(Draw.SCISSORS, Draw.SCISSORS);
        score += rockPaperScissors.runGame(Draw.PAPER, Draw.PAPER);
        score += rockPaperScissors.runGame(Draw.PAPER, Draw.PAPER);
        score += rockPaperScissors.runGame(Draw.PAPER, Draw.ROCK);
        score += rockPaperScissors.runGame(Draw.PAPER, Draw.SCISSORS);
        score += rockPaperScissors.runGame(Draw.SCISSORS, Draw.SCISSORS);
        score += rockPaperScissors.runGame(Draw.PAPER, Draw.ROCK);
        assertThat(score).isEqualTo(44);
    }

    @Test
    public void runRockPaperScissorsRound4() {
        RockPaperScissors rockPaperScissors = new RockPaperScissors();
        Draw myDraw = rockPaperScissors.getDrawByOutcome(Draw.ROCK, Outcome.DRAW);
        int score = rockPaperScissors.runGame(Draw.ROCK, myDraw);
        assertThat(score).isEqualTo(4);
    }

    @Test
    public void runRockPaperScissorsRound5() {
        RockPaperScissors rockPaperScissors = new RockPaperScissors();
        Draw myDraw = rockPaperScissors.getDrawByOutcome(Draw.PAPER, Outcome.LOSE);
        int score = rockPaperScissors.runGame(Draw.PAPER, myDraw);
        assertThat(score).isEqualTo(1);
    }

    @Test
    public void runRockPaperScissorsRound6() {
        RockPaperScissors rockPaperScissors = new RockPaperScissors();
        Draw myDraw = rockPaperScissors.getDrawByOutcome(Draw.SCISSORS, Outcome.WIN);
        int score = rockPaperScissors.runGame(Draw.SCISSORS, myDraw);
        assertThat(score).isEqualTo(7);
    }

    @Test
    public void runRockPaperScissorsReadCsvDataNew2() {
        RockPaperScissors rockPaperScissors = new RockPaperScissors();
        Draw myDraw = rockPaperScissors.getDrawByOutcome(Draw.ROCK, Outcome.DRAW);
        int score = rockPaperScissors.runGame(Draw.ROCK, myDraw);
        assertThat(score).isEqualTo(4);
    }

    @Test
    public void runRockPaperScissorsReadCsvDataNew3() {
        RockPaperScissorsCsvReader reader = new RockPaperScissorsCsvReader(DRAWS_FILE_PATH);
        int score = reader.readRockPaperScissorsByAction();
        assertThat(score).isEqualTo(12725);
    }
}
