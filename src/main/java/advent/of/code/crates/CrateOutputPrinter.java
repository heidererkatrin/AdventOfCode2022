package advent.of.code.crates;

public class CrateOutputPrinter {

    public void print(CrateGrid crateGrid) {
        int columns = 9;
        int maxRows = crateGrid.getMaxRows();
        for (int row = 0; row <= maxRows; row++) {
            for (int column = 1; column <= columns; column++) {
                System.out.print("[");
                System.out.print(crateGrid.getValueAtIndex(column, row));
                System.out.print("] ");

            }
            System.out.print("\n");
        }
    }
}
