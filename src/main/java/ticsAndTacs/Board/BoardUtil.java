package ticsAndTacs.Board;

import ticsAndTacs.TicsTacs.Cell;

public class BoardUtil {
    public static Cell[][] linesToColumns(Cell[][] someLines) {
        Cell[][] columns = new Cell[someLines.length][someLines[0].length];
        for (int i = 0; i < someLines.length; i++) {
            for (int j = 0; j < someLines[i].length; j++) {
                columns[j][i] = someLines[i][j];
            }
        }
        return columns;
    }

    public static Cell[][] linesToDiagonals(Cell[][] someLines) {
        Cell[][] diagonals = new Cell[2][someLines.length];
        int x = 0;
        int y = someLines.length - 1;
        for (int i = 0; i < someLines.length; i++) {
            diagonals[0][i] = someLines[x + i][x + i];
            diagonals[1][i] = someLines[x + i][y - i];
        }
        return diagonals;
    }
}
