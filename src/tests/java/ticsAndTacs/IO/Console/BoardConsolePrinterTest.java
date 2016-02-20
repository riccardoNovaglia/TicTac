package ticsAndTacs.IO.Console;

import org.junit.Before;
import org.junit.Test;
import ticsAndTacs.Board.Board;
import ticsAndTacs.Board.BoardBuilder;
import ticsAndTacs.Board.IndexOutOfBoardException;
import ticsAndTacs.Game.IllegalMoveException;
import ticsAndTacs.TicsTacs.Cell;

public class BoardConsolePrinterTest {

    private final String BLANK_ROW_STRING = "   |   |   \n";
    private final String DASHY_ROW_STRING = "--- --- ---\n";

    private Board board;
    private BoardConsolePrinter boardConsolePrinter;
    private MockConsolePrinter mockConsole;

    @Before
    public void setup() {
        mockConsole = new MockConsolePrinter();
        boardConsolePrinter = new BoardConsolePrinter(mockConsole);
    }

    @Test
    public void
    should_print_an_empty_board() {
        // given
        anEmptyBoard();

        // when
        theBoardGetsPrinted();

        // then
        mockConsole.hasPrinted(anEmptyBoardString());
    }

    @Test
    public void
    should_print_a_board_with_a_tic() throws IndexOutOfBoardException, IllegalMoveException {
        // given
        board = aBoard().withA(tic()).at(0, 0).build();

        // when
        theBoardGetsPrinted();

        // then
        mockConsole.hasPrinted(zeroZeroTic());
    }

    @Test
    public void
    should_print_a_board_with_a_tac() throws IndexOutOfBoardException, IllegalMoveException {
        // given
        board = aBoard().withA(tac()).at(1, 1).build();

        // when
        theBoardGetsPrinted();

        // then
        mockConsole.hasPrinted(oneOneTac());
    }

    @Test
    public void
    should_print_a_board_with_tic_and_tac() throws IndexOutOfBoardException, IllegalMoveException {
        // given
        board = aBoard().withA(tic()).at(0, 1)
                .and().withA(tac()).at(2, 0).build();

        // when
        theBoardGetsPrinted();

        // then
        mockConsole.hasPrinted(someBoard());
    }

    private Cell.Types tac() {
        return Cell.Types.TAC;
    }

    private Cell.Types tic() {
        return Cell.Types.TIC;
    }

    private BoardBuilder aBoard() {
        return new BoardBuilder();
    }

    private void theBoardGetsPrinted() {
        boardConsolePrinter.print(board);
    }

    private String zeroZeroTic() {
        return " x |   |   \n" +
               DASHY_ROW_STRING +
               BLANK_ROW_STRING +
               DASHY_ROW_STRING +
               BLANK_ROW_STRING;
    }

    private String oneOneTac() {
        return BLANK_ROW_STRING +
               DASHY_ROW_STRING +
               "   | o |   \n" +
               DASHY_ROW_STRING +
               BLANK_ROW_STRING;
    }

    private String someBoard() {
        return "   | x |   \n" +
               DASHY_ROW_STRING +
               BLANK_ROW_STRING +
               DASHY_ROW_STRING +
               " o |   |   \n";
    }

    private String anEmptyBoardString() {
        return BLANK_ROW_STRING +
                DASHY_ROW_STRING +
                BLANK_ROW_STRING +
                DASHY_ROW_STRING +
                BLANK_ROW_STRING;
    }

    private void anEmptyBoard() {
        board = new BoardBuilder().build();
    }
}
