package advent.of.code.backpack;

import java.util.HashMap;

public class BackPackSorter {
    private HashMap<Character, Integer> alphabetMap;

    public BackPackSorter() {
        initMap();
    }

    public int getSharedItem(String inputString) throws Exception {
        String firstItemStorage = getFirstItemStorage(inputString);
        String secondItemStorage = getSecondItemStorage(inputString);
        for (int index = 0; index < firstItemStorage.length(); index++) {
            String substring = firstItemStorage.substring(index, index + 1);
            if (secondItemStorage.contains(substring)) {
                return alphabetMap.get(substring.charAt(0));
            }
        }
        throw new Exception("No double letter found");
    }

    private String getFirstItemStorage(String inputString) {
        return inputString.substring(0, inputString.length() / 2);
    }

    private String getSecondItemStorage(String inputString) {
        return inputString.substring(inputString.length() / 2);
    }

    public int getSharedItemGroup(String firstLine, String secondLine, String thirdLine) throws Exception {
        for (int i = 0; i < firstLine.length(); i++) {
            String substring = firstLine.substring(i, i + 1);
            if (secondLine.contains(substring) && thirdLine.contains(substring)) {
                return alphabetMap.get(substring.charAt(0));
            }
        }
        throw new Exception("No double letter found");
    }

    private void initMap() {
        alphabetMap = new HashMap<>();
        int index = 1;
        for (char alphabet = 'a'; alphabet <= 'z'; alphabet++) {
            alphabetMap.put(alphabet, index);
            index++;
        }
        for (char alphabet = 'A'; alphabet <= 'Z'; alphabet++) {
            alphabetMap.put(alphabet, index);
            index++;
        }
    }
}
