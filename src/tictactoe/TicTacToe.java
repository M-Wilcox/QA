/*
 * Project: Tic Tac Toe
 * Date Last Edited: 10/22/2019
 */
package tictactoe;

/**
 *
 * @author Michael Wilcox
 */

public class TicTacToe {
    
    // two boolean constants to represent a player
    public static final boolean X_PLAYER = true;                           
    public static final boolean O_PLAYER = false;
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
    }
    
    /*
    
    */
    public static char[] createBoard() {
        
        char[] board = new char[9];     // tic tac toe board
                                        // each space is ordered from left to right, then up to down
        
        // all empty spaces will have the placeholder char 'E'                              
        for (int i = 0; i < board.length; i++) {
            board[i] = 'E';             
        }
        return board;
        
    }
    
    /*
    
    */
    public static boolean currentPlayer(char[] board) {
        
        char xPlayerIcon = 'X';     // icon that represents the X player in the board
        char oPlayerIcon = 'O';     // icon that represents the O player in the board
        int xTurns = 0;                 // iterates for every count of an X on the board
        int oTurns = 0;                 // iterates for every count of an O on the board
        
        for (int i = 0; i < board.length; i++) {
            if (board[i] == xPlayerIcon)
                xTurns++;
            else if (board[i] == oPlayerIcon)
                oTurns++;
        }
        
        // X always makes the first move
        if (xTurns == oTurns)
            return X_PLAYER;
        
        return (xTurns < oTurns) ? X_PLAYER : O_PLAYER;
    }
    
    /*
    
    */
    public static boolean changePlayer(boolean player) {
        
        // change the boolean value from true to false or vice versa
         return !player;   
    }
    
    /*
    
    */
    public static char[] makeMove(char[] board, int index, boolean player) {
        
        char playerIcon;
        
        if (player == X_PLAYER) {
            playerIcon = 'X';
        } else
            playerIcon = 'O';
        
        board[index - 1] = playerIcon;
        
        return board;
    }
    
    /*
    
    */
    public static boolean spaceInUse(char[] board, int index) {
        
        boolean inUse = false;  // true if the space corresponding to the given index is occupied by another player
                        
        // players are represented by either an X or an O
        if (board[index - 1] == 'X' || board[index - 1] == 'O')
            inUse = true;
        
        return inUse;
    }
}
