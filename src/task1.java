import java.util.Scanner;

class Task1 {
    public static void main(String[] agrs) {  
        // TODO: generalize the algorithm; for further application(s)

        // constant values
        final int NUMBER_OF_SCORES          = 7;
        final int[] INTERVAL                = { 0, 100 };
        final String[] ORDINAL_INDICATORS   = { "st", "nd", "rd", "th" };

        Scanner input = new Scanner(System.in);             // declare the scanner

        int tempScore;                                      // temporary variable to store the user input
        String currentOrdinalIndicator;                     // store the current ordinal indicator
        int[] studentScores = new int[NUMBER_OF_SCORES];    // array of size NUMBER_OF_SCORES to store the user input values
      
        int studentCounter = 0;                             // variable to keep track of the number of students (default value is 0)
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
                // assign the value to the array, and increment the studentCounter
                studentScores[studentCounter] = tempScore;
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

        // exercise 1 output
        System.out.println(joinedStudentScores(studentScores));
    }

    /* Note: we need to parse each value from int to String, such that we may use the String.join(...) method.
     * we create a new array of the same size as the original array, 
     * and assign the values from the original array to the new array, where the values are parsed to String.
     * we then use the String.join() method to join the values of the new array, per the instructions.
     * String.join(...) docs: https://docs.oracle.com/javase/8/docs/api/java/lang/String.html
    */

    public static String joinedStudentScores(int[] inputArray) 
    {
        String[] tempArray = new String[inputArray.length];
        for (int i = 0; i < inputArray.length; i++) 
        {
          tempArray[i] = String.valueOf(inputArray[i]);
        }
        return String.join(", ", tempArray);
    }
}