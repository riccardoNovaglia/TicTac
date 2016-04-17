package ticsAndTacs.Game.Gameplay;

import org.junit.Before;
import org.junit.Test;
import ticsAndTacs.Board.Board;
import ticsAndTacs.Game.IllegalMoveException;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;
import static ticsAndTacs.TicsTacs.Cell.Types.TAC;
import static ticsAndTacs.TicsTacs.Cell.Types.TIC;

public class VictoryReporterTest {


    private Board board;
    private VictoryReporter reporter;

    @Before
    public void setUp() throws Exception {
        board = new Board();
        reporter = new VictoryReporter(board);
    }

    @Test
    public void
    should_not_report_victory_if_there_is_not_one() throws IllegalMoveException {
        // given
        aBoardWithNoWinners();

        // when
        boolean result = reporter.someoneHasWon();

        // then
        assertThat(result, is(false));
    }

    @Test
    public void
    should_report_victory_if_horizontal_victory() throws IllegalMoveException {
        // given
        aBoardWithHorizontalVictory();

        // when
        boolean result = reporter.someoneHasWon();

        // then
        assertThat(result, is(true));
    }

    @Test
    public void
    should_report_victory_if_vertical_victory() throws IllegalMoveException {
        // given
        aBoardWithVerticalVictory();

        // when
        boolean result = reporter.someoneHasWon();

        // then
        assertThat(result, is(true));
    }

    @Test
    public void
    should_report_victory_if_diagonal_victory() throws IllegalMoveException {
        // given
        aBoardWithDiagonalVictory();

        // when
        boolean result = reporter.someoneHasWon();

        // then
        assertThat(result, is(true));
    }

    private void aBoardWithNoWinners() throws IllegalMoveException {
        board.setCell(0, 0, TAC);
        board.setCell(0, 1, TIC);
        board.setCell(0, 2, TAC);
        board.setCell(1, 0, TIC);
    }

    private void aBoardWithHorizontalVictory() throws IllegalMoveException {
        board.setCell(0, 0, TAC);
        board.setCell(0, 1, TAC);
        board.setCell(0, 2, TAC);
    }

    private void aBoardWithVerticalVictory() throws IllegalMoveException {
        board.setCell(0, 0, TIC);
        board.setCell(1, 0, TIC);
        board.setCell(2, 0, TIC);
    }

    private void aBoardWithDiagonalVictory() throws IllegalMoveException {
        board.setCell(0, 0, TIC);
        board.setCell(1, 1, TIC);
        board.setCell(2, 2, TIC);
    }
}
