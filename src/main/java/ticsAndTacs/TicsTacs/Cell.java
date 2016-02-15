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

    public void to(Types type) {
        this.type = type;
    }

    public Types getType() {
        return type;
    }

    public enum Types {
        TIC, EMPTY, TAC
    }
}
