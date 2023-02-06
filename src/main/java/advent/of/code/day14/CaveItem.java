package advent.of.code.day14;

public class CaveItem {
    private final int x;
    private final int y;
    private CaveItemType type;

    public CaveItem(int x, int y, CaveItemType type) {
        this.x = x;
        this.y = y;
        this.type = type;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public CaveItemType getType() {
        return type;
    }

    public void setType(CaveItemType type) {
        this.type = type;
    }
}
