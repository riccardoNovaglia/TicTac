package ticsAndTacs.Game.Gameplay;

import ticsAndTacs.TicsTacs.Cell;

public class CellValueCalculator {

    public static final int TIC_VICTORY_VALUE = 3;
    public static final int TAC_VICTORY_VALUE = 30;

    public static int calculateCellsValue(Cell[] cells) {
        int cellsValue = 0;
        for (Cell cell : cells) {
            cellsValue += calculateCellValue(cell);
        }
        return cellsValue;
    }

    private static int calculateCellValue(Cell cell) {
        switch (cell.getType()) {
            case TIC:
                return 1;
            case TAC:
                return 10;
            default:
                return 0;
        }
    }
}
