package ticsAndTacs.Board;

public class BoardConsolePrinter implements BoardPrinter {

    private static final String LINE_TEMPLATE = "%s|%s|%s%n";
    private static final String DASHY_LINE = "---- --- ----%n";
    private final ConsolePrinter consolePrinter;

    public BoardConsolePrinter(ConsolePrinter consolePrinter) {
        this.consolePrinter = consolePrinter;
    }

    public void print(Board board) {
        final String boardStringRepresentation = getBoardStringRepresentation(board);
        consolePrinter.print(boardStringRepresentation);
    }

    private String getBoardStringRepresentation(Board board) {
        int[][] lines = board.getLines();
        return String.format(boardTemplate(),
                lineStringRepresentationFor(lines[0]),
                lineStringRepresentationFor(lines[1]),
                lineStringRepresentationFor(lines[2]));
    }

    private String lineStringRepresentationFor(int[] line) {
        return String.format(LINE_TEMPLATE,
                cellStringRepresentationFor(line[0]),
                cellStringRepresentationFor(line[1]),
                cellStringRepresentationFor(line[2]));
    }

    private String cellStringRepresentationFor(int cellValue) {
        if (cellValue == 1) {
            return " x ";
        } else if (cellValue == 10) {
            return " o ";
        } else {
            return "\t";
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
