package advent.of.code.trees;

public class Tree {
    private final int height;
    private boolean visible = false;
    private final int row;
    private final int column;

    public Tree(int height, int row, int column) {
        this.height = height;
        this.row = row;
        this.column = column;
    }

    public int getHeight() {
        return height;
    }

    public boolean isVisible() {
        return visible;
    }

    public void setVisible(boolean visibility) {
        if (visibility){
            visible = true;
        }
    }

    public int getRow() {
        return row;
    }

    public int getColumn() {
        return column;
    }
}
