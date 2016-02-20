package ticsAndTacs.TicsTacs;

public class Cell {
    private Types type;

    public Cell() {
        this.type = Types.EMPTY;
    }

    public boolean isTac() {
        return this.type == Types.TAC;
    }

    public boolean isTic() {
        return this.type == Types.TIC;
    }

    public void to(Types type) throws CellNotEmptyException {
        if (this.type != Types.EMPTY) {
            throw new CellNotEmptyException(String.format("Cell not empty, is %s, cannot change type", this.type));
        }
        this.type = type;
    }

    public Types getType() {
        return type;
    }

    public void reset() {
        this.type = Types.EMPTY;
    }

    public enum Types {
        TIC, EMPTY, TAC
    }
}
