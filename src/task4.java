import java.util.Scanner;

class Task4 {
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

        /* Exercise 4:
         * TODO: supervision of comments
         * 
         * Expexted output: The highest score is <value> and belongs to the <position> st/nd/rd/th student
         * We declare a structure that will hold the value with its corresponding index. Then, we search for 
         * the absolute maximum and assign it's index to it. We start by assigning the first value (and the index)
         * to the structure. With this construct, we don't need to iterate through the array twice. */

        int[] highestValueStruct = { studentScores[0], 0 }; // [value, index]

        for (int i = 1; i < NUMBER_OF_SCORES; i++)
        {
            if (studentScores[i] > highestValueStruct[0]) 
            {
                highestValueStruct[0] = studentScores[i];
                highestValueStruct[1] = i;
            }
        }
        
        // display the result per the given instructions; we use the highestIdx variable for readability
        int highestIdx = highestValueStruct[1];
        String ordinalIndicator = (highestIdx < 3) ? ORDINAL_INDICATORS[highestIdx]: ORDINAL_INDICATORS[3];
        
        System.out.printf("The highest score is %d and belongs to the %d%s student", 
                          highestValueStruct[0], highestIdx + 1, ordinalIndicator);
        System.out.println(); // add new line
    }
}