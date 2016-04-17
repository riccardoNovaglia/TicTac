package ticsAndTacs.Board;

import org.junit.Before;
import org.junit.Test;
import ticsAndTacs.TicsTacs.Cell;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;
import static ticsAndTacs.TicsTacs.Cell.Types.TAC;
import static ticsAndTacs.TicsTacs.Cell.Types.TIC;

public class BoardUtilTest {

    private Cell[][] someLines;

    @Before
    public void setUp() throws Exception {
        someLines = new Cell[][]{
                {new Cell(), new Cell(), new Cell()},
                {new Cell(TIC), new Cell(TIC), new Cell(TIC)},
                {new Cell(TAC), new Cell(TAC), new Cell(TAC)}
        };
    }

    @Test
    public void
    should_take_the_board_lines_and_return_them_as_columns() {
        // when
        Cell[][] columns = BoardUtil.linesToColumns(someLines);

        // then
        assertThat(columns, equalTo(new Cell[][]{
                {new Cell(), new Cell(TIC), new Cell(TAC)},
                {new Cell(), new Cell(TIC), new Cell(TAC)},
                {new Cell(), new Cell(TIC), new Cell(TAC)}
        }));
    }

    @Test
    public void
    should_return_the_diagonals_of_some_cells() {
        // when
        Cell[][] diagonals = BoardUtil.linesToDiagonals(someLines);

        // then
        assertThat(diagonals, equalTo(new Cell[][]{
                {new Cell(), new Cell(TIC), new Cell(TAC)},
                {new Cell(), new Cell(TIC), new Cell(TAC)}
        }));

    }
}
