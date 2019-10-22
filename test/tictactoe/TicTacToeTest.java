/*
 * Project: Tic Tac Toe Test
 * Date Last Edited: 10/22/2019
 */
package tictactoe;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Michael Wilcox
 */
public class TicTacToeTest {
    
    // two boolean constants to represent a player
    public static final boolean X_PLAYER = true;                           
    public static final boolean O_PLAYER = false;
    
    public TicTacToeTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }

    /**
     * Test of createBoard method, of class TicTacToe.
     * Asserts that the board has 9 active fields
     */
    @Test
    public void testCreateBoard() {
        System.out.println("createBoard");
        
        char[] expResult = new char[9]; // test board with 9 active fields
        
        // fill the board with 9 active fields
        for (int i = 0; i < expResult.length; i++) {
            expResult[i] = 'E';             
        }
        
        char[] result = TicTacToe.createBoard();
        //assertArrayEquals(falseResult, result);
        assertArrayEquals(expResult, result);
    }

    /**
     * Test of currentPlayer method, of class TicTacToe.
     * Asserts that the current player is X
     */
    @Test
    public void testXCurrentPlayer() {
        System.out.println("currentPlayer (X)");
        char[] board = new char[9];         // board that is expected to return X as the next player
        
        // fill most of the board with unoccupied spaces
        for (int i = 1; i < board.length; i++) {           
            board[i] = 'E';
        }
        // O went first
        board[0] = 'O';        
        // if O goes first, X goes next
        boolean expXResult = X_PLAYER;
        boolean resultX = TicTacToe.currentPlayer(board);
        
        assertEquals(expXResult, resultX);
    }
    /**
     * Test of currentPlayer method, of class TicTacToe.
     * Asserts that the current player is O
     */
    @Test
    public void testOCurrentPlayer() {
        System.out.println("currentPlayer (O)");
        char[] board = new char[9];         // board that is expected to return O as the next player
        
        // fill most of the board with unoccupied spaces
        for (int i = 1; i < board.length; i++) {           
            board[i] = 'E';
        }
        // X went first
        board[0] = 'X';
        // if X goes first, O goes next
        boolean expOResult = O_PLAYER;
        boolean resultO = TicTacToe.currentPlayer(board);
        
        assertEquals(expOResult, resultO);
    }

    /**
     * Test of makeMove method, of class TicTacToe.
     * Asserts that the current player places an X on the board
     */
    @Test
    public void testXMakeMove() {
        System.out.println("makeMove (X)");
        char[] board = new char[9];                 // board that is expected to have an X
        // creates a default board
        for (int i = 0; i < board.length; i++) {           
            board[i] = 'E';
        }
        char[] expResult = board;                   // first step of the expected board
        
        int index = 1;                              // upper left corner of the board
        boolean playerX = X_PLAYER;
        // if the current player is X, the player should place an X in the given index
        expResult[0] = 'X'; 
        char[] resultX = TicTacToe.makeMove(board, index, playerX);
        assertArrayEquals(expResult, resultX);

    }
    
    /**
     * Test of makeMove method, of class TicTacToe.
     * Asserts that the current player places an O on the board
     */
    @Test
    public void testOMakeMove() {
        System.out.println("makeMove (O)");
        char[] board = new char[9];                 // board that is expected to have an O
        // creates a default board
        for (int i = 0; i < board.length; i++) {           
            board[i] = 'E';
        }
        
        char[] expResult = board;                  // first step of the expected board
        
        int index = 1;                              // upper left corner of the board
        boolean playerO = O_PLAYER;
        // if the current player is O, the player should place an O in the given index
        expResult[0] = 'O';
        char[] resultO = TicTacToe.makeMove(board, index, playerO);
        assertArrayEquals(expResult, resultO);

    }

    /**
     * Test of spaceInUse method, of class TicTacToe.
     * Asserts that placement of an X or O is in an unoccupied spot
     */
    @Test
    public void testSpaceInUse() {
        System.out.println("spaceInUse");
        char[] board = new char[9];                 // board to test whether a given space is in use
        // creates a board with mostly occupied spaces
        for (int i = 0; i < board.length -1; i++) {           
            board[i] = 'X';
        }
        // add a space not in use  
        board[8] = 'E';
        // index of the space not in use
        int index = 9;              
        // space expected not to be in use
        boolean expResult = false;  
        boolean result = TicTacToe.spaceInUse(board, index);
        assertEquals(expResult, result);
    }
    
}
