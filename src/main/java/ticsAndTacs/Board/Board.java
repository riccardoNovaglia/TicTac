package ticsAndTacs.Board;

import ticsAndTacs.Game.IllegalMoveException;
import ticsAndTacs.TicsTacs.Cell;
import ticsAndTacs.TicsTacs.CellNotEmptyException;

import java.util.Arrays;

public class Board {
    private Cell[][] cells = new Cell[3][3];

    public Board() {
        for (Cell[] line : cells) {
            Arrays.setAll(line, x -> new Cell());
        }
    }

    public Cell[][] getCells() {
        return cells;
    }

    public void setCell(int x, int y, Cell.Types type) throws IllegalMoveException {
        try {
            cells[y][x].to(type);
        } catch (ArrayIndexOutOfBoundsException ex) {
            throw new IllegalMoveException(new IndexOutOfBoardException(ex));
        } catch (CellNotEmptyException e) {
            throw new IllegalMoveException(
                    String.format("Cell (%d,%d) already occupied by %s", y, x, cells[y][x].getType()),
                    e);
        }

    }

    public Cell getCellAt(int x, int y) throws IndexOutOfBoardException {
        try {
            return cells[y][x];
        } catch (ArrayIndexOutOfBoundsException ex) {
            throw new IndexOutOfBoardException(ex);
        }
    }
}
