package ticsAndTacs.Game;

import org.junit.Before;
import org.junit.Test;
import org.mockito.verification.VerificationMode;
import ticsAndTacs.Board.Board;
import ticsAndTacs.IO.BoardPrinter;
import ticsAndTacs.IO.InputListener;
import ticsAndTacs.IO.Move;
import ticsAndTacs.TicsTacs.Cell;

import java.util.ArrayList;

import static org.mockito.BDDMockito.given;
import static org.mockito.Mockito.*;

public class GameTest {

    InputListener mockReader = mock(InputListener.class);
    BoardPrinter mockWriter = mock(BoardPrinter.class);
    private Board board;
    private Game game;
    private Move[] movesList;

    @Before
    public void setUp() throws Exception {
        board = new Board();
        game = new Game(board, mockReader, mockWriter);
    }

    @Test
    public void
    should_play_a_whole_game() {
        // given
        movesList = aFullGameMinusFirstMove();
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
        // given
        movesList = aFullGameWithThreeIllegalMoves();
        given(mockReader.waitForInput()).willReturn(new Move(0, 0), movesList);

        // when
        game.start();

        // then
        verify(mockReader, oncePer(movesList.length + 1)).waitForInput();
        verify(mockWriter, oncePer(movesList.length + 2 - 3)).print(board);
        verify(mockWriter, times(3)).printIllegalMoveMessage();
    }

    @Test
    public void
    should_terminate_the_game_and_print_a_message_if_an_illegal_move_is_played_3_times_in_a_row() {
        // given
        movesList = threeIllegalMovesInARow();
        given(mockReader.waitForInput()).willReturn(new Move(0, 0), movesList);

        // when
        game.start();

        // then
        verify(mockReader, oncePer(4)).waitForInput();
        verify(mockWriter, times(3)).printIllegalMoveMessage();
        verify(mockWriter, times(1)).printGameTerminatedMessage();
    }

    @Test
    public void
    should_end_the_game_if_a_player_wins() {
        // given
        movesList = aGameWhereTheFirstPlayerWins();
        given(mockReader.waitForInput()).willReturn(new Move(0, 0), movesList);

        // when
        game.start();

        // then
        verify(mockReader, times(5)).waitForInput();
        verify(mockWriter, times(6)).print(board);
        verify(mockWriter, times(1)).printVictoryMessage(Cell.Types.TAC);
    }

    private VerificationMode oncePer(int times) {
        return times(times);
    }

    private Move[] aFullGameWithThreeIllegalMoves() {
        ArrayList<Move> fullGame = getFullGameMovesArrayList();

        fullGame.add(0, new Move(0, 0));

        fullGame.add(2, new Move(4, 4));
        fullGame.add(4, new Move(-1, -1));

        return fullGame.toArray(new Move[11]);
    }

    private Move[] aFullGameMinusFirstMove() {
        ArrayList<Move> moves = getFullGameMovesArrayList();
//        moves.remove(0);
        return moves.toArray(new Move[7]);
    }

    private ArrayList<Move> getFullGameMovesArrayList() {
        ArrayList<Move> moves = new ArrayList<>();

        moves.add(new Move(1, 0));
        moves.add(new Move(2, 0));
        moves.add(new Move(1, 1));
        moves.add(new Move(0, 1));
        moves.add(new Move(0, 2));
        moves.add(new Move(1, 2));
        moves.add(new Move(2, 1));
        moves.add(new Move(2, 2));

        return moves;
    }

    private Move[] threeIllegalMovesInARow() {
        Move[] moves = new Move[3];
        for (int i = 0; i < 3; i++) {
            moves[i] = new Move(0, 0);
        }
        return moves;
    }

    private Move[] aGameWhereTheFirstPlayerWins() {
        Move[] moves = new Move[5];

        moves[0] = new Move(0, 1);
        moves[1] = new Move(1, 0);
        moves[2] = new Move(1, 1);
        moves[3] = new Move(2, 0);
        moves[4] = new Move(2, 1);

        return moves;
    }

}
