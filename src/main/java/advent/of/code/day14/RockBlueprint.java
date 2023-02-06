package advent.of.code.day14;

import java.util.ArrayList;
import java.util.List;

public class RockBlueprint {
    private List<String> inputLines = new ArrayList<>();
    private CaveMap caveMap = new CaveMap();
    private boolean boarderNotReached = true;
    private int counter = 0;

    public void addLine(String inputLine) {
        inputLines.add(inputLine);
    }


    public void initMap() {
        caveMap.addCaveItem(new CaveItem(500, 0, CaveItemType.SAND_ORIGIN));
        for (String line : inputLines) {
            String[] firstParameter = line.split(" -> ");
            calculateLine(firstParameter, 0, 1);
        }
        caveMap.fillWithAir(inputLines);
        caveMap.print(inputLines);

        while (boarderNotReached) {
            addSand();
            counter++;
        }
        System.out.println("Counter was: " + counter);
    }

    private void calculateLine(String[] line, int index, int nextIndex) {
        drawLine(line[index], line[nextIndex]);
        if (line.length > nextIndex + 1) {
            calculateLine(line, nextIndex, nextIndex + 1);
        }
    }

    private void drawLine(String fromCoordinates, String toCoordinates) {
        String[] toCoordinatesSplit = toCoordinates.split(",");
        int fromX = Integer.parseInt(fromCoordinates.split(",")[0]);
        int fromY = Integer.parseInt(fromCoordinates.split(",")[1]);
        int toX = Integer.parseInt(toCoordinatesSplit[0]);
        int toY = Integer.parseInt(toCoordinatesSplit[1]);
        if (fromX == toX) {
            calculateY(fromY, toY, fromX);
        } else if (fromY == toY) {
            calculateX(fromX, fromY, toX);
        }
    }

    private void calculateX(int fromX, int fromY, int toX) {
        if (fromX > toX) {
            for (int xCoordinate = fromX; xCoordinate >= toX; xCoordinate--) {
                caveMap.addCaveItem(new CaveItem(xCoordinate, fromY, CaveItemType.STONE));
            }
        } else {
            for (int xCoordinate = fromX; xCoordinate <= toX; xCoordinate++) {
                caveMap.addCaveItem(new CaveItem(xCoordinate, fromY, CaveItemType.STONE));
            }
        }
    }

    private void calculateY(int fromY, int toY, int fromX) {
        if (fromY > toY) {
            for (int yCoordinate = fromY; yCoordinate >= toY; yCoordinate--) {
                caveMap.addCaveItem(new CaveItem(fromX, yCoordinate, CaveItemType.STONE));
            }
        } else {
            for (int yCoordinate = fromY; yCoordinate <= toY; yCoordinate++) {
                caveMap.addCaveItem(new CaveItem(fromX, yCoordinate, CaveItemType.STONE));
            }
        }
    }

    public List<String> getInputLines() {
        return inputLines;
    }

    public void addSand() {
        calculateNextTile(500, 0);
    }

    private void calculateNextTile(int x, int y) {
        if (checkNextTile(x, y)) {
            calculateNextTile(x, y + 1);
        } else if (checkNextTile(x - 1, y)) {
            calculateNextTile(x - 1, y + 1);
        } else if (checkNextTile(x + 1, y)) {
            calculateNextTile(x + 1, y + 1);
        } else {
            caveMap.getCaveItemByCoordinates(x, y).setType(CaveItemType.SAND);
        }
        caveMap.print(inputLines);
    }

    private boolean checkNextTile(int x, int y) {
        int nextY = y + 1;
        CaveItem nextCaveitemDown = caveMap.getCaveItemByCoordinates(x, nextY);
        if (nextCaveitemDown == null) {
            boarderNotReached = false;
            return false;
        }
        return nextCaveitemDown.getType() == CaveItemType.AIR;
    }

    public int getCounter() {
        return counter -1;
    }
}
