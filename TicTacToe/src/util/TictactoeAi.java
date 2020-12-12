package src.util;

/**
 * TictactoeAi controls the computer player
 * @version 2020.1212
 */
public class TictactoeAi {

    /**
     * computerRandom randomizes a cell for "O" using util.Math.computerRandom
     * 
     * <p>used when the AI has no immident cells to put "O" to. 
     * 
     * @param array
     * @param size
     * @author Jaakko Saranpää
     * 
     */
    public static void computerRandom(String [][] array, int size) {
        boolean success = false;
        while(success == false) {
            int randomX = Math.getRandom(0, size - 1);
            int randomY = Math.getRandom(0, size - 1);
            if(array[randomY][randomX] == "[ ]") {
                array[randomY][randomX] = "[O]";
                success = true;
            }
        }
    }

    /**
     * AI method makes the Computer player make smart moves
     * @param array
     * @param size
     * @author Jaakko Saranpää
     * 
     * <p>The method first checks all methods it can defend, then if there's no defending needed, it checks all possible ways to win, and if there are none at the moment, 
     * it calls computerRandom -method
     */

    public static void AI(String [][] array, int size) {
        boolean moveDone = false;
        for(int Ai = 0; moveDone == false && Ai < 2; Ai++){
            String player = "";
            if(Ai == 0) {
                player = "[X]";
            } else if(Ai == 1) {
                player = "[O]";
            }
            for (int i = 0; i < size; i++) {
                for (int j = 0; j < size; j++) {

                    //[X][X][ ]
                    if(j >= 1 && moveDone == false) {
                        if(array[i][j] == player && array[i][j-1] == player) {
                            if(j < size - 1) {
                                if(array[i][j+1] == "[ ]") {
                                    array[i][j+1] = "[O]";
                                    moveDone = true;
                                } 
                            }  
                        }
                    }
                    //[ ][X][X]
                    if(j < size - 1 && moveDone == false) {
                        if(array[i][j] == player && array[i][j+1] == player) {
                            if(j >= 1) {
                                if(array[i][j-1] == "[ ]") {
                                    array[i][j-1] = "[O]";
                                    moveDone = true;
                                } 
                            }  
                        }
                    }
                    //[X]
                    //[X]
                    //[ ]
                    if(i >= 1 && moveDone == false) {
                        if(array[i][j] == player && array[i-1][j] == player) {
                            if(i < size - 1) {
                                if(array[i+1][j] == "[ ]") {
                                    array[i+1][j] = "[O]";
                                    moveDone = true;
                                } 
                            }
                        }
                    }
                    //[ ]
                    //[X]
                    //[X]
                    if(i < size - 1 && moveDone == false) {
                        if(array[i][j] == player && array[i+1][j] == player) {
                            if(i >= 1) {
                                if(array[i-1][j] == "[ ]") {
                                    array[i-1][j] = "[O]";
                                    moveDone = true;
                                } 
                            }
                        }
                    }
                    //[X][ ][X]
                    if(j < size - 2 && moveDone == false) {
                        if(array[i][j] == player && array[i][j+2] == player) {
                            if(array[i][j + 1] == "[ ]") {
                                array[i][j + 1] = "[O]";
                                moveDone = true;
                            } 
                        }
                    }
                    //[X]
                    //[ ]
                    //[X]
                    if(i < size - 2 && moveDone == false) {
                        if(array[i][j] == player && array[i + 2][j] == player) {
                            if(array[i + 1][j] == "[ ]") {
                                array[i + 1][j] = "[O]";
                                moveDone = true;
                            } 
                        }
                    }
                    //[X]
                    //   [X]
                    //      [ ]
                    if(i < size - 2 && j < size - 2 && moveDone == false) {
                        if(array[i][j] == player && array[i + 1][j + 1] == player) {
                            if(array[i + 2][j + 2] == "[ ]") {
                                array[i + 2][j + 2] = "[O]";
                                moveDone = true;
                            } 
                        }
                    }
                    //[ ]
                    //   [X]
                    //      [X]
                    if(i > 1 && j > 1 && moveDone == false) {
                        if(array[i][j] == player && array[i - 1][j - 1] == player) {
                            if(array[i - 2][j - 2] == "[ ]") {
                                array[i - 2][j - 2] = "[O]";
                                moveDone = true;
                            } 
                        }
                    }
                    //[X]
                    //   [ ]
                    //      [X]
                    if(i < size - 2 && j < size - 2 && moveDone == false) {
                        if(array[i][j] == player && array[i + 2][j + 2] == player) {
                            if(array[i + 1][j + 1] == "[ ]") {
                                array[i + 1][j + 1] = "[O]";
                                moveDone = true;
                            } 
                        }
                    }
                    //      [ ]
                    //   [X]
                    //[X]
                    if(i > 1 && j < size - 2 && moveDone == false) {
                        if(array[i][j] == player && array[i - 1][j + 1] == player) {
                            if(array[i - 2][j + 2] == "[ ]") {
                                array[i - 2][j + 2] = "[O]";
                                moveDone = true;
                            } 
                        }
                    }
                    //      [X]
                    //   [X]
                    //[ ]
                    if(i < size - 2 && j > 1 && moveDone == false) {
                        if(array[i][j] == player && array[i + 1][j - 1] == player) {
                            if(array[i + 2][j - 2] == "[ ]") {
                                array[i + 2][j - 2] = "[O]";
                                moveDone = true;
                            } 
                        }
                    }
                    //      [X]
                    //   [ ]
                    //[X]
                    if(i < size - 2 && j > 1 && moveDone == false) {
                        if(array[i][j] == player && array[i + 2][j - 2] == player) {
                            if(array[i + 1][j - 1] == "[ ]") {
                                array[i + 1][j - 1] = "[O]";
                                moveDone = true;
                            } 
                        }
                    }
                }
            }
        }
        if(moveDone == false) {
            computerRandom(array, size);
            moveDone = true;
        }
    }
}

//End of file