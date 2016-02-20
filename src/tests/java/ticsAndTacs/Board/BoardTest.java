package ticsAndTacs.Board;

import org.junit.Test;
import ticsAndTacs.Game.IllegalMoveException;
import ticsAndTacs.TicsTacs.Cell;

import static junit.framework.TestCase.fail;
import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;

public class BoardTest {

    private static final int EXPECTED_BOARD_SIZE = 3;
    private static final int EXPECTED_LINE_SIZE = 3;

    @Test
    public void
    should_be_an_empty_board_when_created() throws Exception {
        // given
        Board newBoard = new Board();

        // when
        Cell[][] lines = newBoard.getLines();

        // then
        assertThat(lines.length, equalTo(3));
        for (int i = 0; i < EXPECTED_BOARD_SIZE; i++) {
            for (int j = 0; j < EXPECTED_LINE_SIZE; j++) {
                assertThat("Cell should be empty",
                           lines[i][j].getType(),
                           equalTo(Cell.Types.EMPTY));
            }
        }
    }

    @Test
    public void
    should_return_a_given_cell_by_x_y() throws Exception {
        // given
        Board newBoard = new Board();

        // when
        Cell cell = newBoard.getCellAt(0, 0);

        // then
        assertThat(cell, equalTo(newBoard.getLines()[0][0]));
    }

    @Test(expected = IndexOutOfBoardException.class)
    public void
    should_throw_array_out_of_bounds_exception_if_given_unexpected_coordinates() throws Exception {
        // given
        Board newBoard = new Board();

        // when
        try {
            newBoard.getCellAt(-1, -1);
        } catch (IndexOutOfBoardException ex) {
            // then
            assertThat(ex.getCause().getClass(), equalTo(ArrayIndexOutOfBoundsException.class));
            assertThat(ex.getMessage(), equalTo("Index out of bound of board. Index must be between 0 and 3"));
            throw ex;
        }

        // when
        try {
            newBoard.getCellAt(4, 4);
        } catch (IndexOutOfBoardException ex) {
            // then
            assertThat(ex.getCause().getClass(), equalTo(ArrayIndexOutOfBoundsException.class));
            assertThat(ex.getMessage(), equalTo("Index out of bound of board. Index must be between 0 and 3"));
            throw ex;
        }
    }

    @Test
    public void
    should_set_cells_to_the_given_type() throws Exception {
        // given
        Board newBoard = new Board();

        // when
        newBoard.setCell(0, 0, Cell.Types.TIC);

        // then
        assertThat(newBoard.getCellAt(0, 0).getType(), equalTo(Cell.Types.TIC));
    }

    @Test
    public void
    should_not_allow_to_set_cells_types_multiple_times() throws Exception {
        // given
        Board newBoard = new Board();
        newBoard.setCell(1, 2, Cell.Types.TAC);

        try {
            // when
            newBoard.setCell(1, 2, Cell.Types.TIC);
            // then
            fail("Should have not allowed the cell being re-set");
        } catch (IllegalMoveException e) {
            assertThat(e.getMessage(), equalTo("Cell (1,2) already occupied by TAC"));
        }
    }

    @Test(expected = IllegalMoveException.class)
    public void
    should_throw_exception_if_set_cell_coordinates_are_out_of_bounds() throws Exception {
        // given
        Board newBoard = new Board();

        // when
        try {
            newBoard.setCell(-1, -1, Cell.Types.TAC);
        } catch (IllegalMoveException ex) {
            // then
            assertThat(ex.getCause().getCause().getClass(), equalTo(ArrayIndexOutOfBoundsException.class));
            assertThat(ex.getCause().getMessage(),
                       equalTo("Index out of bound of board. Index must be between 0 and 3"));
            throw ex;
        }

        // when
        try {
            newBoard.setCell(4, 4, Cell.Types.TIC);
        } catch (IllegalMoveException ex) {
            // then
            assertThat(ex.getCause().getClass(), equalTo(ArrayIndexOutOfBoundsException.class));
            assertThat(ex.getMessage(), equalTo("Index out of bound of board. Index must be between 0 and 3"));
            throw ex;
        }
    }
}
