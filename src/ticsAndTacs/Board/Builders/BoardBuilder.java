package ticsAndTacs.Board.Builders;

import ticsAndTacs.Board.Board;
import ticsAndTacs.TicsTacs.Cell;

public class BoardBuilder {

    private Board board = new Board();

    public TickPositioner withA(Cell tick) {
        return new TickPositioner(board, tick, this);
    }

    public Board build() {
        return board;
    }

    public BoardBuilder and() {
        return this;
    }
}
