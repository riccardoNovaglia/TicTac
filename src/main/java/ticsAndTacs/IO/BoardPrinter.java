package ticsAndTacs.IO;

import ticsAndTacs.Board.Board;
import ticsAndTacs.TicsTacs.Cell;

public interface BoardPrinter {

    void print(Board board);

    void printIllegalMoveMessage();

    void promptForInput();

    void printVictoryMessage(Cell.Types lastMoveType);

    void printGameTerminatedMessage();
}
