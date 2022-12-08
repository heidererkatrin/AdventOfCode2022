package advent.of.code.trees;

public class Tree {
    private final int height;
    private boolean visible = false;

    public Tree(int height) {
        this.height = height;
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
}
