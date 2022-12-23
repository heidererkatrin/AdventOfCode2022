package advent.of.code.day20;

import advent.of.code.ropeBridge.RopeBridgeGrid;
import advent.of.code.ropeBridge.StepInformation;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;

public class EncrypterCsvReader {

    public Encrypter readInput(String enyrptFilePAth) {
        String line = "";
        Encrypter encrypter = new Encrypter(new ArrayList<>());
        try {
            BufferedReader br = new BufferedReader(new FileReader(enyrptFilePAth));
            while ((line = br.readLine()) != null) {
                encrypter.addNumberToList(line);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return encrypter;
    }
}
