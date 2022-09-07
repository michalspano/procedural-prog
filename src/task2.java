import java.util.Scanner;

class Task2 {
    public static void main(String[] agrs) {

        // TODO: generalize the algorithm

        // constants
        final int numberOfScores = 7;
        final int[] INTERVAL = {0, 100};
        final String[] ordinalIndicators = { "st", "nd", "rd", "th" };

        // scanner for the user input
        Scanner input = new Scanner(System.in);

        int[] studentScores = new int[numberOfScores];

        String currentOrdinalIndicator;
    
        int tempScore;

        int scoreSum = 0;
    
        int studentCounter = 1;
        while (studentCounter <= numberOfScores)
        {  
            currentOrdinalIndicator = (studentCounter <= 3) ? ordinalIndicators[studentCounter - 1] : ordinalIndicators[3];
            System.out.printf("Enter the %d%s number: ", studentCounter, currentOrdinalIndicator);
            tempScore = input.nextInt(); 
            
            if (tempScore >= INTERVAL[0] && tempScore <= INTERVAL[1])
            {
                studentScores[studentCounter - 1] = tempScore;
                scoreSum += tempScore;
                studentCounter++;    
            }
            else
            {
                System.out.printf("Error - Input out of bound. Score can only be between %d and %d.", INTERVAL[0], INTERVAL[1]);
            }
        }


        // we may close the scanner now, since we don't want to get any more values from the user.
        input.close();

        System.out.printf("Thank you for your input. Your entered scores are:\n");
        // for (int i = 0; i < numberOfScores; i++) 
        // {
        //     String valueDivider = (i == numberOfScores - 1) ? "" : ", ";
        //     System.out.print(studentScores[i] + valueDivider);
        // }

        System.out.println(joinedStudentScores(", ", studentScores));

        // String.join(sep, arr);
        // arr - int[];
        // we need to cast each value int -> String
        // String.join(sep, arr [only Strings!]);

        // print a new line
        // System.out.println();

        // create the mean; round to 2 decimal places
        System.out.printf("The mean of the numbers is %.02f\n", (double) scoreSum / numberOfScores);

    }

    // Note: we need to parse each value from int to String, such that we may use the .join() method
    public static String joinedStudentScores(String separator, int[] arr)
    {
        String[] temp = new String[arr.length];
        for (int i = 0; i < arr.length; i++)
        {
            temp[i] = String.valueOf(arr[i]);
        }
        return String.join(separator, temp);
    }
}