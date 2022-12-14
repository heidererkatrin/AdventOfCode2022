package advent.of.code.ropeBridge;

public class StepInformation {
    public static final String DELIMITER = ";";
    int x;
    int y;
    private boolean headTouched;
    private boolean tailTouched;

    public StepInformation(int x, int y) {
        this.x = x;
        this.y = y;
        headTouched = true;
    }

    public String getCoordinates() {
        return x + DELIMITER + y;
    }

    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }

    public void setTailTouched(boolean tailTouched) {
        this.tailTouched = tailTouched;
    }

    public boolean isTailTouched() {
        return tailTouched;
    }
}
