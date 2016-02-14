package ticsAndTacs.TicsTacs;

import java.util.Optional;

public class Cell {
    protected Optional<Boolean> value = Optional.empty();

    public boolean isTac() {
        return value.isPresent() && value.get();
    }

    public boolean isTic() {
        return value.isPresent() && !value.get();
    }
}
