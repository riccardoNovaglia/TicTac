package ticsAndTacs.Game.Gameplay;

import ticsAndTacs.Board.Board;
import ticsAndTacs.Board.BoardUtil;
import ticsAndTacs.TicsTacs.Cell;

import static ticsAndTacs.Game.Gameplay.CellValueCalculator.*;

public class VictoryReporter {
    private Board board;

    public VictoryReporter(Board board) {
        this.board = board;
    }

    public boolean someoneHasWon() {
        for (Cell[] line : board.getCells()) {
            if (cellsContainVictory(line)) {
                return true;
            }
        }
        for (Cell[] column : BoardUtil.linesToColumns(board.getCells())) {
            if (cellsContainVictory(column)) {
                return true;
            }
        }
        for (Cell[] diagonal : BoardUtil.linesToDiagonals(board.getCells())) {
            if (cellsContainVictory(diagonal)) {
                return true;
            }
        }
        return false;
    }

    private boolean cellsContainVictory(Cell[] cells) {
        int cellsValue = calculateCellsValue(cells);
        return cellsValue == TIC_VICTORY_VALUE || cellsValue == TAC_VICTORY_VALUE;
    }


}
