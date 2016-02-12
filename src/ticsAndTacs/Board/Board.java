package ticsAndTacs.Board;

public class Board {
    private final int[][] lines = new int[3][3];

    public int[][] getLines() {
        return lines;
    }

    public void setCell(int x, int y, int value) {
        lines[x][y] = value;
    }

}
