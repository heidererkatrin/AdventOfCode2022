package advent.of.code.day14;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class CaveMap {
   private final HashMap<Coordinates, CaveItem> caveMap = new HashMap<>();

    public void addCaveItem(CaveItem caveItem) {
        if (!checkForDuplicate(caveItem)) {
            caveMap.put(new Coordinates(caveItem.getX(), caveItem.getY()), caveItem);
        }
    }

    public CaveItem getCaveItemByCoordinates(int x, int y) {
        for (Map.Entry<Coordinates, CaveItem> entry : caveMap.entrySet()) {
            Coordinates coordinates = entry.getKey();
            if (coordinates.getX() == x && coordinates.getY() == y) {
                return entry.getValue();
            }
        }
        return null;
    }

    private boolean checkForDuplicate(CaveItem caveItem) {
        return getCaveItemByCoordinates(caveItem.getX(), caveItem.getY()) != null;
    }

    public void fillWithAir(List<String> inputLines) {
        for (int i = RockUtil.getSmallestX(inputLines); i <= RockUtil.getLargestX(inputLines); i++) {
            for (int j = 0; j <= RockUtil.getLargestY(inputLines); j++) {
                addCaveItem(new CaveItem(i, j, CaveItemType.AIR));
            }
        }
    }

    public void print(List<String> inputLines) {
            for (int j = 0; j <= RockUtil.getLargestY(inputLines); j++) {
                for (int i = RockUtil.getSmallestX(inputLines); i <= RockUtil.getLargestX(inputLines); i++) {
                System.out.print(getCaveItemByCoordinates(i, j).getType().code);
            }
            System.out.println();
        }
    }
}
