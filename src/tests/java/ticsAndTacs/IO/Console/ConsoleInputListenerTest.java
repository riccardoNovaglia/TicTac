package ticsAndTacs.IO.Console;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.mockito.Mockito;
import ticsAndTacs.IO.Move;

import java.io.BufferedReader;
import java.io.IOException;
import java.util.Arrays;
import java.util.Collection;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.mockito.Mockito.when;

@RunWith(Parameterized.class)
public class ConsoleInputListenerTest {

    private final String firstInput;
    private final String secondInput;
    private final int moveX;
    private final int moveY;
    BufferedReader mockReader;

    @Before
    public void setUp() throws Exception {
        mockReader = Mockito.mock(BufferedReader.class);
    }

    @Parameterized.Parameters
    public static Collection<Object[]> data() {
        return Arrays.asList(new Object[][]{
                {"0", "1", 0, 1}, {"1", "2", 1, 2}
        });
    }

    public ConsoleInputListenerTest(String firstInput, String secondInput, int moveX, int moveY) {
        this.firstInput = firstInput;
        this.secondInput = secondInput;
        this.moveX = moveX;
        this.moveY = moveY;
    }

    @Test
    public void
    should_return_the_corresponding_move_object_given_some_input() throws IOException {
        // given
        ConsoleInputListener reader = new ConsoleInputListener(mockReader);
        when(mockReader.readLine()).thenReturn(firstInput, secondInput);

        // when
        Move m = reader.waitForInput();

        // then
        assertThat(m.x, equalTo(moveX));
        assertThat(m.y, equalTo(moveY));
    }
}
