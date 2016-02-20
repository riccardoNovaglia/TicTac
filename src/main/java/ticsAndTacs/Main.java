package ticsAndTacs;

import ticsAndTacs.Board.Board;
import ticsAndTacs.Game.Game;
import ticsAndTacs.IO.Console.BoardConsolePrinter;
import ticsAndTacs.IO.Console.ConsoleInputListener;
import ticsAndTacs.IO.Console.ConsolePrinterImp;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {

    static BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

    public static void main(String[] args) {
        Game game = new Game(
                new Board(),
                new ConsoleInputListener(bufferedReader),
                new BoardConsolePrinter(new ConsolePrinterImp()));
        game.start();
    }
}
