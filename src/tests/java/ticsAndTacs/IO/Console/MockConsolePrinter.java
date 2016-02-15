package ticsAndTacs.IO.Console;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;

public class MockConsolePrinter implements ConsolePrinter {

    public String printed;

    public void print(String toPrint) {
        this.printed = toPrint;
    }

    public void hasPrinted(String expected) {
        assertThat(printed, equalTo(expected));
    }
}
