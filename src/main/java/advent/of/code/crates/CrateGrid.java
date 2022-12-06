package advent.of.code.crates;

import java.util.HashMap;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class CrateGrid {
    private final HashMap<Integer, List<String>> map;

    public CrateGrid() {
        this.map = new HashMap<>();
    }

    public void moveCrate(int quantityOfCratesMoved, int initialColumn, int destinationColumn) {
        List<String> initialColumnList = map.get(initialColumn);
        List<String> destinationColumnList = map.get(destinationColumn);
        for (int i = 0; i < quantityOfCratesMoved; i++) {
            destinationColumnList.add(0, initialColumnList.get(0));
            initialColumnList.remove(0);
        }
    }

    public void moveCrateInBundle(int quantityOfCratesMoved, int initialColumn, int destinationColumn) {
        List<String> initialColumnList = map.get(initialColumn);
        List<String> destinationColumnList = map.get(destinationColumn);
        List<String> subListToSplit = initialColumnList.subList(0, quantityOfCratesMoved );

        destinationColumnList.addAll(0, subListToSplit);

        if (quantityOfCratesMoved > 0) {
            initialColumnList.subList(0, quantityOfCratesMoved).clear();
        }
    }

    public void addColumn(int columnIndex, List<String> crateNames) {
        map.put(columnIndex, crateNames);
    }

    public List<String> getColumn(int columnIndex) {
        return map.get(columnIndex);
    }

    public String getValueAtIndex(int columnIndex, int rowIndex) {
        try {
            return getColumn(columnIndex).get(rowIndex);
        } catch (IndexOutOfBoundsException | NullPointerException e) {
            return " ";
        }
    }

    public String getHighestValueInColumn(int columnIndex) {
        return map.get(columnIndex).get(0);
    }

    public void addInput(int columnIndex, String substring) {
        if (!substring.isEmpty() && !substring.equals(" ")) {
            if (map.containsKey(columnIndex)) {
                List<String> strings = map.get(columnIndex);
                strings.add(substring);
            } else {
                map.put(columnIndex, Stream.of(substring).collect(Collectors.toList()));
            }
        }
    }

    public int getMaxRows() {
        int maxRows = 0;
        for (int i = 1; i < 10; i++) {
            if (map.get(i).size() > maxRows) {
                maxRows = map.get(i).size();
            }
        }
        return maxRows;
    }
}
