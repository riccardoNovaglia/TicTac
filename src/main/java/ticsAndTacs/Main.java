package ticsAndTacs;

import ticsAndTacs.Board.Board;
import ticsAndTacs.IO.Console.BoardConsolePrinter;
import ticsAndTacs.IO.Console.ConsolePrinterImp;

public class Main {

    public static void main(String[] args) {
        Board b = new Board();
        BoardConsolePrinter boardConsolePrinter = new BoardConsolePrinter(new ConsolePrinterImp());

        boardConsolePrinter.print(b);
    }
}
