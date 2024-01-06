package test;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import main.TicTacToe;

import static org.junit.jupiter.api.Assertions.*;

class TicTacToeTest {

    private TicTacToe ticTacToe;

    @BeforeEach
    void setUp() {
        ticTacToe = new TicTacToe();
    }

    @AfterEach
    void tearDown() {
    }

    @Test
    void testInitialization() {
        assertNotNull(ticTacToe);
        Assertions.assertEquals("X", ticTacToe.board[0]);
        Assertions.assertTrue(ticTacToe.isXTurn);
    }

    @Test
    void testValidMove() {
        ticTacToe.initializeBoard();
        Assertions.assertTrue(ticTacToe.isValidMove(0));
        ticTacToe.board[0] = "X";
        Assertions.assertFalse(ticTacToe.isValidMove(0));
    }

    @Test
    void testGameResult() {
        ticTacToe.initializeBoard();
        Assertions.assertFalse(ticTacToe.isGameOver());

        ticTacToe.board[0] = ticTacToe.board[1] = ticTacToe.board[2] = "X";
        Assertions.assertTrue(ticTacToe.isGameOver());
        Assertions.assertTrue(ticTacToe.checkRowWin());

        ticTacToe.initializeBoard();
        ticTacToe.board[0] = ticTacToe.board[3] = ticTacToe.board[6] = "O";
        Assertions.assertTrue(ticTacToe.isGameOver());
        Assertions.assertTrue(ticTacToe.checkColumnWin());

        ticTacToe.initializeBoard();
        ticTacToe.board[0] = ticTacToe.board[4] = ticTacToe.board[8] = "X";
        Assertions.assertTrue(ticTacToe.isGameOver());
        Assertions.assertTrue(ticTacToe.checkDiagonalWin());
    }
}
