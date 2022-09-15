import java.util.Scanner;
import java.util.Locale;

class Task2 {
    public static void main(String[] args) {  
        // TODO: generalize the algorithm; for further application(s)

        // constant values
        final int NUMBER_OF_SCORES          = 7;
        final int[] INTERVAL                = { 0, 100 };
        final String[] ORDINAL_INDICATORS   = { "st", "nd", "rd", "th" };

        Scanner input = new Scanner(System.in);             // declare the scanner
        Locale.setDefault(Locale.ENGLISH);                  // a decimal place is indicated with a dot

        int tempScore;                                      // temporary variable to store the user input
        String currentOrdinalIndicator;                     // store the current ordinal indicator
        int[] studentScores = new int[NUMBER_OF_SCORES];    // array of size NUMBER_OF_SCORES to store the user input values
      
        /* Analysis: 
         * we'd like keep track of the sum of the scores, this value will be used to determine the mean of the scores.
         * we introduce it in the following loop, such that we don't have to iterate over the array again to calculate the mean.
         * resulting in more optimized code.
        */

        int scoreSum = 0;                               // variable to store the sum of the scores (default value is 0)
        int studentCounter = 0;                         // variable to keep track of the number of students (default value is 0)
        while (studentCounter < NUMBER_OF_SCORES) 
        {       
            // obtain the ordinal indicator using the ternary operator
            currentOrdinalIndicator = (studentCounter < 3) ? ORDINAL_INDICATORS[studentCounter] : ORDINAL_INDICATORS[3];

            // prompt the user to enter the score, and store the value in the tempScore variable
            System.out.printf("Enter the %d%s number: ", studentCounter + 1, currentOrdinalIndicator);
            tempScore = input.nextInt(); 
            
            // check if the value is within the INTERVAL
            if (tempScore >= INTERVAL[0] && tempScore <= INTERVAL[1])
            {
                // assign the value to the array, and increment the studentCounter and scoreSum
                studentScores[studentCounter] = tempScore;
                scoreSum += tempScore;
                studentCounter++;    
            }
            else
            {
                // warn the user
                System.out.printf("Error - Input out of bound. Score can only be between %d and %d.\n", INTERVAL[0], INTERVAL[1]);
            }
        }
        // close the scanner, no use for it anymore
        input.close();

        // exercise 2 output
        // the output is rounded to two decimal places, using the format specifier %.2f
        System.out.printf("The mean of the numbers is %.02f\n", (double) scoreSum / NUMBER_OF_SCORES);
    }
}