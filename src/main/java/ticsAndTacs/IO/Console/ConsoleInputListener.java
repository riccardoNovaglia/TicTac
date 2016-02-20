package ticsAndTacs.IO.Console;

import ticsAndTacs.IO.InputListener;
import ticsAndTacs.IO.Move;

import java.io.BufferedReader;
import java.io.IOException;

public class ConsoleInputListener implements InputListener {

    BufferedReader inputReader;

    public ConsoleInputListener(BufferedReader reader) {
        this.inputReader = reader;
    }

    public Move waitForInput() {
        int x = 0;
        int y = 0;
        try {
            x = getInputNumber();
            y = getInputNumber();
        } catch (IOException e) {
            e.printStackTrace();
        }

        return new Move(x, y);
    }

    private int getInputNumber() throws IOException {
        String inputString = inputReader.readLine();
        int inputNumber;
        try {
            inputNumber = Integer.parseInt(inputString);
        } catch (NumberFormatException e) {
            inputNumber = getInputNumber();
        }
        return inputNumber;
    }
}
