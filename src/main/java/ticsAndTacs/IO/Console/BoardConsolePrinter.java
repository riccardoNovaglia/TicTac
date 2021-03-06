package ticsAndTacs.IO.Console;

import ticsAndTacs.Board.Board;
import ticsAndTacs.IO.BoardPrinter;
import ticsAndTacs.TicsTacs.Cell;

public class BoardConsolePrinter implements BoardPrinter {

    private static final String LINE_TEMPLATE = "%s|%s|%s%n";
    private static final String DASHY_LINE = "--- --- ---%n";
    private final ConsolePrinter consolePrinter;

    public BoardConsolePrinter(ConsolePrinter consolePrinter) {
        this.consolePrinter = consolePrinter;
    }

    public void print(Board board) {
        final String boardStringRepresentation = getBoardStringRepresentation(board);
        consolePrinter.print(boardStringRepresentation);
    }

    @Override
    public void printIllegalMoveMessage() {
        consolePrinter.print("Woops, try again!");
    }

    @Override
    public void promptForInput() {
        consolePrinter.print("Please input two numbers for your move (x, y)");
    }

    @Override
    public void printVictoryMessage(Cell.Types lastMoveType) {
        consolePrinter.print(String.format("Congratulation %ss, you won!", lastMoveType));
    }

    @Override
    public void printGameTerminatedMessage() {
        consolePrinter.print("That's enough, go read the instructions and try again later.");
    }

    private String getBoardStringRepresentation(Board board) {
        Cell[][] lines = board.getCells();
        return String.format(boardTemplate(),
                lineStringRepresentationFor(lines[0]),
                lineStringRepresentationFor(lines[1]),
                lineStringRepresentationFor(lines[2]));
    }

    private String lineStringRepresentationFor(Cell[] line) {
        return String.format(LINE_TEMPLATE,
                cellStringRepresentationFor(line[0]),
                cellStringRepresentationFor(line[1]),
                cellStringRepresentationFor(line[2]));
    }

    private String cellStringRepresentationFor(Cell cell) {
        if (cell.isTic()) {
            return " x ";
        } else if (cell.isTac()) {
            return " o ";
        } else {
            return "   ";
        }
    }

    private String boardTemplate() {
        return "%s" +
                DASHY_LINE +
                "%s" +
                DASHY_LINE +
                "%s";
    }


}
