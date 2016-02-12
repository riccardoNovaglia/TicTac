package ticsAndTacs.Board.Builders;

import ticsAndTacs.Board.Board;
import ticsAndTacs.TicsTacs.Cell;
import ticsAndTacs.TicsTacs.Tick;

public class TickPositioner {
    private final Board board;
    private final Cell cell;
    private final BoardBuilder boardBuilder;

    public TickPositioner(Board newBoard, Cell tick, BoardBuilder boardBuilder) {
        this.board = newBoard;
        this.cell = tick;
        this.boardBuilder = boardBuilder;
    }

    public BoardBuilder at(int x, int y) {
        board.setCell(x, y, cell.getValue());
        return boardBuilder;
    }
}
