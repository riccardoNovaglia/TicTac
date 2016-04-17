package ticsAndTacs.Game;

import ticsAndTacs.Board.Board;
import ticsAndTacs.IO.BoardPrinter;
import ticsAndTacs.IO.InputListener;
import ticsAndTacs.IO.Move;
import ticsAndTacs.TicsTacs.Cell;

public class Game {

    Board playingBoard;
    InputListener reader;
    BoardPrinter writer;

    public Game(Board playingBoard, InputListener reader, BoardPrinter writer) {
        this.playingBoard = playingBoard;
        this.reader = reader;
        this.writer = writer;
    }

    public void start() {
        writer.print(playingBoard);

        for (int i = 0; i < 9; i++) {
            move(i);
            writer.print(playingBoard);
        }
    }

    private void move(int turn) {
        writer.promptForInput();

        Move selectedMove = reader.waitForInput();

        Cell.Types moveType = turn % 2 == 0 ? Cell.Types.TAC : Cell.Types.TIC;

        try {
            playingBoard.setCell(selectedMove.getX(), selectedMove.getY(), moveType);
        } catch (IllegalMoveException e) {
            writer.printIllegalMoveMessage();
            move(turn);
        }
    }
}
