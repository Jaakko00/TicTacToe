package src.util;

/**
 * TictactoeUtils has various methods used for checking states of the game
 * 
 * @author Jaakko Saranpää
 * @version 2020.1212
 */
public class TictactoeUtils {
    /**
     * checkTable checks if either one of the players have won the game, works with winSize of 3 and 5
     * @param array
     * @param size
     * @param winSize
     * @param player
     * @return boolean won or not
     * @author Jaakko Saranpää
     */
    public static boolean checkTable(String [][] array, int size, int winSize, String player) {
        int checkHorizontal = 0;
        int checkVertical = 0;
        boolean won = false;
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                //goes through every cell in the board

                //checks rows
                if(array[i][j] == player) { 
                    checkHorizontal++;
                    if(checkHorizontal == winSize) {
                        won = true;
                    }
                } else {
                    checkHorizontal = 0;
                }

                //checks columns
                if(array[j][i] == player) {
                    checkVertical++;
                    if(checkVertical == winSize) {
                        won = true;
                    }
                } else {
                    checkVertical = 0;
                }
            }
            checkVertical = 0;
            checkHorizontal = 0;
        }

        //loop for checking diagonal lines, separated from diagonal and horizontal for better readability
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                //goes through every cell in the board
                if(size < 10) { 
                    //for boards with a win requirement of 3 crosses
                    if(array[i][j] == player) { 
                        //if the current cell contains [X] or [O]
                        if(i < size - 2 && j < size - 2) { 
                            //stops checkTable from checking too close to the edge of the board to avoid errors
                            if(array[i][j] == player && array[i + 1][j + 1] == player && array[i + 2][j + 2] == player) {
                                //Checks up to down
                                won = true;
                            }
                        }
                        if(i > 1 && j < size - 2) { 
                            //stops checkTable from checking too close to the edge of the board to avoid errors
                            if(array[i][j] == player && array[i - 1][j + 1] == player && array[i - 2][j + 2] == player) {
                                //Check down to up
                                won = true;
                            }
                        }
                    }
                }
                if(size >= 10) { 
                    //for boards with a win requirement of 5 crosses
                    if(array[i][j] == player) { 
                        //if the current cell contains [X] or [O]
                        if(i < size - 4 && j < size - 4) { 
                            //stops checkTable from checking too close to the edge of the board to avoid errors
                            if(array[i][j] == player && array[i + 1][j + 1] == player && array[i + 2][j + 2] == player && array[i +3][j + 3] == player && array[i + 4][j + 4] == player) {
                                //Checks up to down
                                won = true;
                            }
                        }
                        if(i > 3 && j < size - 4) { 
                            //stops checkTable from checking too close to the edge of the board to avoid errors
                            if(array[i][j] == player && array[i - 1][j + 1] == player && array[i - 2][j + 2] == player && array[i - 3][j + 3] == player && array[i - 4][j + 4] == player) {
                                //Check down to up
                                won = true;
                            }
                        }
                    }
                }
            }
        }
        return won;
    }
    /**
     * checkForDraw checks all the cells and if it finds no empty cells on the board, it returns true.
     * @param array
     * @param size
     * @return boolean for draw
     * @author Jaakko Saranpää
     */
    public static boolean checkForDraw(String [][] array, int size) {
        int amountOfEmptyCells = 0;
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                if(array[i][j] == "[ ]") {
                    amountOfEmptyCells++;
                }
            }
        }
        if(amountOfEmptyCells == 0) {
            return true;
        } else {
            return false;
        }
    }
}

//End of file