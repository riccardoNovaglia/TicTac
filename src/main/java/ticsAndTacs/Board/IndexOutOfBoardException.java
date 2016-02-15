package ticsAndTacs.Board;

public class IndexOutOfBoardException extends Exception {

    public IndexOutOfBoardException(ArrayIndexOutOfBoundsException cause) {
        super("Index out of bound of board. Index must be between 0 and 3", cause);
    }
}
