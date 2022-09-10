import java.util.Scanner;

class Task3 {
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
            
            // check if the value is within the interval
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

        /* Analysis:
         * TODO: add explanations of the algorithm
         */

        int highestScore = INTERVAL[0], secondHighestScore = INTERVAL[0];
        int lowestScore = INTERVAL[1], secondLowestScore = INTERVAL[1];

        for (int i = 0; i < NUMBER_OF_SCORES; i++) 
        {
            int currentValue = studentScores[i];

            if (currentValue < lowestScore) 
            {
                secondLowestScore = lowestScore;
                lowestScore = currentValue;
            } else if (currentValue < secondLowestScore) 
            {
                secondLowestScore = currentValue;
            }

            if (currentValue > highestScore) 
            {
                secondHighestScore = highestScore;
                highestScore = currentValue;
            } else if (currentValue > secondHighestScore) 
            {
                secondHighestScore = currentValue;
            }
        }

        // exercise 3 output
        System.out.println("The two lowest scores provided are " + lowestScore + ", and " + secondLowestScore);
        System.out.println("The two highest scores provided are " + highestScore + ", and " + secondHighestScore);
    }
}