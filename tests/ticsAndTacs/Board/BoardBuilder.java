package ticsAndTacs.Board;

import ticsAndTacs.TicsTacs.Cell;

public class BoardBuilder {

    private Board board = new Board();

    public CellPlacer withA(Cell cell) {
        return new CellPlacer(board, cell);
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
        private final Cell cell;

        public CellPlacer(Board newBoard, Cell cell) {
            this.board = newBoard;
            this.cell = cell;
        }

        public BoardBuilder at(int x, int y) {
            board.setCell(x, y, cell.getValue());
            return thisBuilder();
        }
    }
}
