package src.util;

import java.io.Console;  
/**
 * MyConsole class has methods used for reading input from the console
 * @author Jaakko Saranpää
 * @version 2020.1212
 */
public class MyConsole {
    /**
     * readInt method reads if given value is an integer or not, you can give it an errormessage, 
     * that it will print if given value is not an integer
     * @param errorMessage a string containing an errormessage for if the input is not an integer
     * @return return the input if it is contained between the minimum and maximum values
     */
    public static int readInt(String errorMessage, String promptText) {
        Console c = System.console(); 
        int input = 0;
        boolean inputIsInteger = false;
        while(inputIsInteger == false) {
            inputIsInteger = true;
            System.out.print(promptText);
            try {
            input += Integer.parseInt(c.readLine());
            } catch(NumberFormatException e) {
            System.out.println(errorMessage);
            inputIsInteger = false;
            }
        }
        return input;
        
    }

    /**
     * readIntMinMax checks if the inputted value is an integer, and then is the value between the given minimum and maximum 
     * 
     * @param min this is the minimum value
     * @param max this is the maximum value
     * @param errorMessageNonNumeric a string containing an errormessage for if the input is not an int
     * @param errorMessageNonMinAndMax a string containing an errormessage for if the input is not between the minimum and maximum values
     * @return return the value that user gave if it is contained between the minimum and maximum values
     */
    public static int readIntMinMax(int min, int max, String errorMessageNonNumeric, String errorMessageNonMinAndMax, String promptText) {
        int value = 0;
        boolean inputIsValid = false;
        while(inputIsValid == false) {
            value = readInt(errorMessageNonNumeric, promptText);
            if(value >= min && value <= max) {
                return value;
            } else {
                System.out.println(errorMessageNonMinAndMax);
                
            }
        }
        return value;
    }
}

//End of file