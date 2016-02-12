package ticsAndTacs.Board;

public class Main {

    public static void main(String[] args) {
        Board b = new Board();
        BoardConsolePrinter boardConsolePrinter = new BoardConsolePrinter(new ConsolePrinterImp());

        boardConsolePrinter.print(b);
    }
}
