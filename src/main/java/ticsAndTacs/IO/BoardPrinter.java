package ticsAndTacs.IO;

import ticsAndTacs.Board.Board;

public interface BoardPrinter {

    void print(Board board);

    void printIllegalMoveMessage();

    void promptForInput();
}
