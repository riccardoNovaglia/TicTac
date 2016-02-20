package ticsAndTacs.Board;

import ticsAndTacs.Game.IllegalMoveException;
import ticsAndTacs.TicsTacs.Cell;
import ticsAndTacs.TicsTacs.CellNotEmptyException;

import java.util.Arrays;

public class Board {
    private Cell[][] lines = new Cell[3][3];

    public Board() {
        for (Cell[] line : lines) {
            Arrays.setAll(line, x -> new Cell());
        }
    }

    public Cell[][] getLines() {
        return lines;
    }

    public void setCell(int x, int y, Cell.Types type) throws IllegalMoveException {
        try {
            lines[x][y].to(type);
        } catch (ArrayIndexOutOfBoundsException ex) {
            throw new IllegalMoveException(new IndexOutOfBoardException(ex));
        } catch (CellNotEmptyException e) {
            throw new IllegalMoveException(
                    String.format("Cell (%d,%d) already occupied by %s", x, y, lines[x][y].getType()),
                    e);
        }

    }

    public Cell getCellAt(int x, int y) throws IndexOutOfBoardException {
        try {
            return lines[x][y];
        } catch (ArrayIndexOutOfBoundsException ex) {
            throw new IndexOutOfBoardException(ex);
        }
    }
}
