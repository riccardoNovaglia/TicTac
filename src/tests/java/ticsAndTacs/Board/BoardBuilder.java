package ticsAndTacs.Board;


import ticsAndTacs.Game.IllegalMoveException;
import ticsAndTacs.TicsTacs.Cell;

public class BoardBuilder {

    private Board board = new Board();

    public CellPlacer withA(Cell.Types cellType) {
        return new CellPlacer(board, cellType);
    }

    public Board build() {
        return board;
    }

    public BoardBuilder and() {
        return this;
    }

    protected BoardBuilder thisBuilder() { return this; }

    public class CellPlacer {
        private final Board board;
        private final Cell.Types cell;

        public CellPlacer(Board newBoard, Cell.Types cell) {
            this.board = newBoard;
            this.cell = cell;
        }

        public BoardBuilder at(int x, int y) throws IllegalMoveException {
            board.setCell(x, y, cell);
            return thisBuilder();
        }
    }
}
