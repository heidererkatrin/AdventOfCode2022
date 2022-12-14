package advent.of.code.trees;

import java.util.ArrayList;
import java.util.Arrays;

public class Grid {
    private Tree[][] trees;
    private int gridRows;
    private int girdColumns;

    public void initForrest(int xSize, int ySize) {
        this.trees = new Tree[xSize][ySize];
        this.gridRows = xSize;
        this.girdColumns = ySize;
    }

    public void addTree(int row, int column, int height) {
        trees[row][column] = new Tree(height, row, column);
    }

    public int calculateHighestAllScenticScores() {
        int highestScenticView = 0;
        for (int row = 0; row < gridRows; row++) {
            for (int column = 0; column < girdColumns; column++) {
                int score = calculateSingleScenticScore(row, column);
                if (score > highestScenticView) {
                    highestScenticView = score;
                }
                System.out.print("[" + score + "]");
            }
            System.out.println();
        }
        return highestScenticView;
    }

    public int calculateAllScenticScores() {
        int highestScenticView = 0;
        for (int row = 0; row < gridRows; row++) {
            for (int column = 0; column < girdColumns; column++) {
                int score = calculateSingleScenticScore(row, column);
                System.out.print("[" + score + "]");
            }
            System.out.println();
        }
        return highestScenticView;
    }

    public int calculateVisibleTrees() {
        int sum = 0;
        for (int row = 0; row < gridRows; row++) {
            for (int column = 0; column < girdColumns; column++) {
                boolean isVisible = calculateSingleTree(row, column);
                sum = sum + (isVisible ? 1 : 0);
                System.out.print("[" + (isVisible ? "V" : "H") + "]");
            }
            System.out.println();
        }
        return sum;
    }

    public boolean calculateSingleTree(int row, int column) {
        Tree tree = trees[row][column];
        tree.setVisible(isCornerTree(row, column));
        for (DIRECTION direction : DIRECTION.values()) {
            tree.setVisible(compareTrees(tree, findTreesToCompare(direction, row, column)));
        }
        return tree.isVisible();
    }

    private ArrayList<Tree> findTreesToCompare(DIRECTION directionToSearch, int row, int column) {
        ArrayList<Tree> treesToCompare = new ArrayList<>();
        switch (directionToSearch) {
            case UP -> {
                for (int index = 0; index < row; index++) {
                    treesToCompare.add(trees[index][column]);
                }
            }
            case DOWN -> {
                for (int index = gridRows - 1; index > row; index--) {
                    treesToCompare.add(trees[index][column]);
                }
            }
            case LEFT -> treesToCompare.addAll(Arrays.asList(trees[row]).subList(0, column));
            case RIGHT -> {
                for (int index = girdColumns - 1; index > column; index--) {
                    treesToCompare.add(trees[row][index]);
                }
            }
        }
        return treesToCompare;
    }

    private boolean compareTrees(Tree tree, ArrayList<Tree> treesToCompare) {
        return treesToCompare
                .stream()
                .filter(e -> e.getHeight() >= tree.getHeight())
                .findAny().isEmpty();
    }

    private boolean isCornerTree(int row, int column) {
        return row == 0 || row == gridRows - 1 || column == 0 || column == girdColumns - 1;
    }

    public int calculateSingleScenticScore(int row, int column) {
        int scenticScore = 1;
        for (DIRECTION direction : DIRECTION.values()) {
            scenticScore *= getScenticScore(trees[row][column], findTreesToCompare(direction, row, column));
        }
        return scenticScore;
    }

    private int getScenticScore(Tree tree, ArrayList<Tree> treesToCompare) {
        int scenticScore = 1;
        for (int index = treesToCompare.size() - 1; index >= 0; index--) {
            Tree neighborTree = treesToCompare.get(index);
            if (tree.getHeight() > neighborTree.getHeight()
                    && !isCornerTree(neighborTree.getRow(), neighborTree.getColumn())) {
                scenticScore++;
            } else {
                break;
            }
        }
        return scenticScore;
    }
}
