package advent.of.code;

import advent.of.code.day20.Encrypter;
import advent.of.code.day20.EncrypterCsvReader;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

public class Day20Encrypter {
    public static final String ENCRYPTION_FILE_PATH = "C:\\dev\\AdventOfCode2022\\src\\test\\resources\\Day20EncryptedNumbers.csv";
    @Test
    void moveNumberInSequence() {
        //1, 2, -3, 3, -2, 0, 4
        Encrypter encrypter = new Encrypter(new ArrayList<>());
        encrypter.addNumberToList("1");
        encrypter.addNumberToList("2");
        encrypter.addNumberToList("-3");
        encrypter.addNumberToList("3");
        encrypter.addNumberToList("-2");
        encrypter.addNumberToList("0");
        encrypter.addNumberToList("4");
        String encryptedText = encrypter.shuffleNumbers();

        Assertions.assertEquals("1, 2, -3, 4, 0, 3, -2, ", encryptedText);
    }


    @Test
    void moveNumberInSequenceTwoCirles() {
        //1, 2, -3, 3, -2, 0, 4
        Encrypter encrypter = new Encrypter(new ArrayList<>());
        encrypter.addNumberToList("1");
        encrypter.addNumberToList("13");
        encrypter.addNumberToList("-10");
        encrypter.addNumberToList("2");
        String encryptedText = encrypter.shuffleNumbers();

        Assertions.assertEquals("1, 13, 2, -10, ", encryptedText);
    }


    @Test
    void readCsvAndShuffleNumbers() {
        EncrypterCsvReader encrypterCsvReader = new EncrypterCsvReader();

        Encrypter encrypter = encrypterCsvReader.readInput(ENCRYPTION_FILE_PATH);
        encrypter.shuffleNumbers();

        Assertions.assertEquals(encrypter.getThreeHighestNumbers(), 7713);
    }
}
