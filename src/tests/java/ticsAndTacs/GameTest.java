package ticsAndTacs;

import org.junit.Before;
import org.junit.Test;
import org.mockito.verification.VerificationMode;
import ticsAndTacs.Board.Board;
import ticsAndTacs.Game.Game;
import ticsAndTacs.IO.BoardPrinter;
import ticsAndTacs.IO.InputListener;
import ticsAndTacs.IO.Move;

import java.util.ArrayList;

import static org.mockito.BDDMockito.given;
import static org.mockito.Mockito.*;

public class GameTest {

    InputListener mockReader = mock(InputListener.class);
    BoardPrinter mockWriter = mock(BoardPrinter.class);
    private Board board;
    private Game game;

    @Before
    public void setUp() throws Exception {
        board = new Board();
        game = new Game(board, mockReader, mockWriter);
    }

    @Test
    public void
    should_play_a_whole_game() {
        // given
        Move[] movesList = aFullGameMinusFirstMove();
        given(mockReader.waitForInput()).willReturn(new Move(0, 0), movesList);

        // when
        game.start();

        // then
        verify(mockReader, oncePer(movesList.length + 1)).waitForInput();
        verify(mockWriter, oncePer(movesList.length + 1)).promptForInput();
        verify(mockWriter, oncePer(movesList.length + 2)).print(board);
    }

    @Test
    public void
    should_play_a_whole_game_and_print_error_messages_if_illegal_moves_are_made() {
        //
        Move[] movesList = aFullGameWithThreeIllegalMoves();
        given(mockReader.waitForInput()).willReturn(new Move(0, 0), movesList);

        // when
        game.start();

        // then
        verify(mockReader, oncePer(movesList.length + 1)).waitForInput();
        verify(mockWriter, oncePer(movesList.length + 2 - 3)).print(board);
        verify(mockWriter, times(3)).printIllegalMoveMessage();
    }

    private VerificationMode oncePer(int times) {
        return times(times);
    }

    private Move[] aFullGameWithThreeIllegalMoves() {
        ArrayList<Move> fullGame = getFullGameMovesArrayList();

        fullGame.add(0, new Move(0, 0));

        fullGame.add(0, new Move(4, 4));
        fullGame.add(0, new Move(-1, -1));

        return fullGame.toArray(new Move[11]);
    }

    private Move[] aFullGameMinusFirstMove() {
        ArrayList<Move> moves = getFullGameMovesArrayList();
        return moves.toArray(new Move[8]);
    }

    private ArrayList<Move> getFullGameMovesArrayList() {
        ArrayList<Move> moves = new ArrayList<>();
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                Move m = new Move(i, j);
                moves.add(m);
            }
        }
        moves.remove(0);
        return moves;
    }

}
