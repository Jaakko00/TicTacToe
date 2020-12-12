package src;

import src.util.Arrays;
import src.util.MyConsole;
import src.util.TictactoeUtils;
import src.util.TictactoeAi;

/**
 * The Main class houses the games basic functions
 */
public class TicTacToe{
    /**
     * the main method in Tictactoe is where the game runs by calling other classes/methods
     * @param args Command line parameters. Not used.
     * @author Jaakko Saranpää
     * @version 2020.1212
     */
    public static void main(String [] args) {
        System.out.println("____,*#@ TIC TAC TOE @#*,____");
        System.out.println("___Welcome to Tic Tac Toe!___");
        System.out.println("Determine the size of the board");
        
        int size = MyConsole.readIntMinMax(3, 9999, "Please give an integer value", "Size should be atleast 3x3", "Size: ");

        String [][] board = boardMaker(size);

        Arrays.printTwoDimArray(board, size);

        boolean gameOver = false;
        for(int i = 1; gameOver == false; i++) {

            //CHECKS FOR DRAW
            if(i >= 8) {
                if(TictactoeUtils.checkForDraw(board, size) == true) {
                    System.out.println("_______,*#@DRAW@#*,_______");
                    gameOver = true;
                    break; //Ends the game
                }
            }

            //COMPUTERS TURN
            if(i % 2 == 0) {
                System.out.println("___COMPUTER___");
                System.out.println("Round " + i);
                TictactoeAi.AI(board, size);
                Arrays.printTwoDimArray(board, size);
                if(TictactoeUtils.checkTable(board, size, determineWinSize(size), "[O]") == true) {
                    System.out.println("____,*#@COMPUTER WON@#*,____");
                    gameOver = true;
                }
            }

            //PLAYERS TURN
            if(i % 2 == 1) {
                System.out.println("____PLAYER____");
                System.out.println("Round " + i);

                
                int placementX = MyConsole.readIntMinMax(1, size, "Please give an integer value", "Invalid placement! Placement should be between 0 and " + size, "Placement on the X axis: ");

                int placementY = MyConsole.readIntMinMax(1, size, "Please give an integer value", "Invalid placement! Placement should be between 0 and " + size, "Placement on the Y axis: ");

                if(board[placementY-1][placementX-1] == "[ ]") {
                    boardFillerX(board, placementX, placementY, size);
                } else {
                    System.out.println("That spot is already used, please pick another one!");
                    i--;
                }
                if(TictactoeUtils.checkTable(board, size, determineWinSize(size), "[X]") == true) {
                    System.out.println("____,*#@PLAYER WON@#*,____");
                    gameOver = true;
                } 
            } 
        }
    }
    /**
     * boardMaker makes the tictactoe -board exist, only used in the beginning of the game
     * @param size
     * @return
     * @author Jaakko Saranpää
     */
    public static String [][] boardMaker(int size) {
        String [][] board = new String [size][size];
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                board[i][j] = "[ ]";
            }
        }
        return board;
    }
    /**
     * boardFillerX only purpose is to place the players "X" on the board and the call a print method
     * @param array
     * @param placementX
     * @param placementY
     * @param size
     * @author Jaakko Saranpää
     */
    public static void boardFillerX(String [][] array, int placementX, int placementY, int size) {
        array[placementY-1][placementX-1] = "[X]";
        Arrays.printTwoDimArray(array, size);
    }
    /**
     * determineWinSize determines the amount of crosses/circles needed next to each other to win
     * @param size
     * @return int win size
     * @author Jaakko Saranpää
     */
    public static int determineWinSize(int size) {
        if(size >= 10) {
            return 5;
        } else {
            return 3;
        }
    }
}

//End of file