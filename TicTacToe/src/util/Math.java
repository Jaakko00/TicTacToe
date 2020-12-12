package src.util;
/**
 * Math class has functions related to math
 * @author Jaakko Saranpää
 * @version 2020.1212
 */
public class Math {
    /**
     * getRandom method creates a random number between the given minimum and maximum values
     * 
     * @param min
     * @param max
     * @return int
     */
    public static int getRandom(int min, int max) {
        return min + (int) (java.lang.Math.random() * ((max - min) + 1));
    }
}

//End of file