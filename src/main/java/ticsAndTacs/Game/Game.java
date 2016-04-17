package ticsAndTacs.Game;

import ticsAndTacs.Board.Board;
import ticsAndTacs.Game.Gameplay.VictoryReporter;
import ticsAndTacs.IO.BoardPrinter;
import ticsAndTacs.IO.InputListener;
import ticsAndTacs.IO.Move;
import ticsAndTacs.TicsTacs.Cell;

public class Game {

    private Board playingBoard;
    private InputListener reader;
    private BoardPrinter writer;
    private int badMoveCounter;
    private boolean gameTerminated;
    private boolean gameWon;
    private Cell.Types moveType;


    public Game(Board playingBoard, InputListener reader, BoardPrinter writer) {
        this.playingBoard = playingBoard;
        this.reader = reader;
        this.writer = writer;
        badMoveCounter = 0;
        gameTerminated = false;
        gameWon = false;
    }

    public void start() {
        writer.print(playingBoard);

        for (int i = 0; i < 9 && !gameTerminated || gameWon; i++) {
            move(i);
            writer.print(playingBoard);
            badMoveCounter = 0;
            if (new VictoryReporter(playingBoard).someoneHasWon()) {
                writer.printVictoryMessage(moveType);
                break;
            }
        }
    }

    private void move(int turn) {
        writer.promptForInput();

        Move selectedMove = reader.waitForInput();

        moveType = turn % 2 == 0 ? Cell.Types.TAC : Cell.Types.TIC;

        try {
            playingBoard.setCell(selectedMove.getX(), selectedMove.getY(), moveType);
        } catch (IllegalMoveException e) {
            writer.printIllegalMoveMessage();
            badMoveCounter++;
            if (badMoveCounter < 3) {
                move(turn);
            } else {
                terminate();
            }
        }
    }

    private void terminate() {
        writer.printGameTerminatedMessage();
        gameTerminated = true;
    }
}
