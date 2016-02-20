package ticsAndTacs.IO;

import ticsAndTacs.TicsTacs.Cell;

public class Move {
    public int x;
    public int y;
    public Cell.Types type;

    public Move(int x, int y) {
        this.x = x;
        this.y = y;
    }
}
