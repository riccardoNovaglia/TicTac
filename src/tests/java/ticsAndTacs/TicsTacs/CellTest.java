package ticsAndTacs.TicsTacs;

import org.junit.Test;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.junit.Assert.fail;

public class CellTest {

    @Test
    public void
    should_change_type_if_cell_is_empty() throws CellNotEmptyException {
        // given
        Cell cell = new Cell();

        // when
        cell.to(Cell.Types.TAC);

        // then
        assertThat(cell.getType(), equalTo(Cell.Types.TAC));
    }

    @Test
    public void
    should_not_change_type_if_cell_is_not_empty() throws CellNotEmptyException {
        // given
        Cell cell = new Cell();
        cell.to(Cell.Types.TAC);

        // when
        try {
            cell.to(Cell.Types.TIC);
            fail("Should have not changed type");
        } catch (CellNotEmptyException e) {
            assertThat(e.getMessage(), equalTo("Cell not empty, is TAC, cannot change type"));
        }
    }

    @Test
    public void
    should_go_back_to_empty_if_reset() throws CellNotEmptyException {
        // given
        Cell cell = new Cell();
        cell.to(Cell.Types.TIC);

        // when
        cell.reset();

        // then
        assertThat(cell.getType(), equalTo(Cell.Types.EMPTY));
    }
}
