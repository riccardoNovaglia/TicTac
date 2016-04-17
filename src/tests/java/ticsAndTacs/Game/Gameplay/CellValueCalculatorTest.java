package ticsAndTacs.Game.Gameplay;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameters;
import ticsAndTacs.TicsTacs.Cell;

import java.util.Arrays;
import java.util.Collection;

import static org.junit.Assert.assertEquals;
import static ticsAndTacs.TicsTacs.Cell.Types.TAC;
import static ticsAndTacs.TicsTacs.Cell.Types.TIC;

@RunWith(Parameterized.class)
public class CellValueCalculatorTest {
    @Parameters
    public static Collection<Object[]> data() {
        Cell[] emptyCells = {new Cell(), new Cell(), new Cell(), new Cell()};
        Cell[] threeTics = {new Cell(TIC), new Cell(TIC), new Cell(TIC)};
        Cell[] threeTacs = {new Cell(TAC), new Cell(TAC), new Cell(TAC)};
        Cell[] mixed = {new Cell(TAC), new Cell(TIC), new Cell(TAC), new Cell(TIC), new Cell(TAC)};
        Cell[] mixedWithSpaces = {new Cell(), new Cell(), new Cell(TAC), new Cell(), new Cell(TIC)};
        return Arrays.asList(new Object[][]{
                {emptyCells, 0},
                {threeTics, 3},
                {threeTacs, 30},
                {mixed, 32},
                {mixedWithSpaces, 11}
        });
    }

    private Cell[] cells;

    private int cellValue;

    public CellValueCalculatorTest(Cell[] input, int expected) {
        cells = input;
        cellValue = expected;
    }

    @Test
    public void test() {
        assertEquals(cellValue, CellValueCalculator.calculateCellsValue(cells));
    }
}
