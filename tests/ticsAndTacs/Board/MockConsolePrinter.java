package ticsAndTacs.Board;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.junit.Assert.assertThat;

public class MockConsolePrinter implements ConsolePrinter {

    public String printed;

    public void print(String toPrint) {
        this.printed = toPrint;
    }

    public void hasPrinted(String expected) {
        assertThat(printed, equalTo(expected));
    }
}
