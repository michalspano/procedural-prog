import java.util.Locale;
import java.util.Arrays;

// TODO: add more comments and polish the code
public class Menu 
{
    static IOScanner input = new IOScanner();
    static int[] studentScores = new int[7];

    // constant values
    static final int NUMBER_OF_SCORES           = 7;
    static final int[] INTERVAL                 = { 0, 100 };
    static final String[] ORDINAL_INDICATORS    = { "st", "nd", "rd", "th" };

    public static void main(String[] args)
    {
        Locale.setDefault(Locale.ENGLISH); // a decimal place is indicated with a dot
        input.initializeScanner();
        
        int option;
        do {
            // TODO: the menu should only be printed once
            System.out.println("Welcome to the menu. Choose one of the options below: ");
            System.out.println("1. Register new scores for students.");
            System.out.println("2. Calculate the mean of the entered scores.");
            System.out.println("3. Find the two highest and two lowest scores.");
            System.out.println("4. Find the highest score and its position.");
            System.out.println("5. Collect hashtags from a post.");
            System.out.println("6. To exit.");

            option = input.readInt("Type your option");

            switch (option) 
            {
                case 1: 
                {
                    readScores(); 
                    System.out.println(joinedStudentScores());
                    break;
                }
                case 2: 
                {                    
                    System.out.printf("The mean of the numbers is %.02f\n", calculateMean());
                    break;
                } 
                case 3: 
                {
                    int[][] extremaScores = twoExtremaOfScores();
                    printExtrema(extremaScores);
                    break;
                } 
                case 4: 
                {
                    int[] highestScoreWithIndex = getHighestScoreWithIndex();
                    printHighestScoreWithIndex(highestScoreWithIndex);
                    break;
                }
                case 5: 
                {
                    collectHashtags();
                    break;
                }

                case 6: 
                {
                    System.out.println("Thank you for using our grading system. Have a nice day!");
                    break;
                }
                
                default: 
                {
                    System.out.println("Error - Invalid value. Please type between 1 and 6");
                    break;
                }
            }

        } while (option != 6);
        
        input.closeScanner();
    }
    
    // -----------------------------------------Subroutines-------------------------------------------//

    //-----------------------------------------Task 1-------------------------------------------//

    public static void readScores() 
    {
        int tempScore;                              // temporary variable to store the user input
        String currentOrdinalIndicator;             // store the current ordinal indicator

        int studentCounter = 0;                     // variable to keep track of the number of students (default value is 0)
        while (studentCounter < NUMBER_OF_SCORES) 
        {
            // obtain the ordinal indicator using the ternary operator
            currentOrdinalIndicator = (studentCounter < 3) ? ORDINAL_INDICATORS[studentCounter] : ORDINAL_INDICATORS[3];

            // prompt the user to enter the score, and store the value in the tempScore variable
            tempScore = input.readInt("Enter the " + (studentCounter + 1) + currentOrdinalIndicator + " number");

            // check if the value is within the INTERVAL
            if (tempScore >= INTERVAL[0] && tempScore <= INTERVAL[1]) 
            {
                // assign the value to the array, and increment the studentCounter
                studentScores[studentCounter++] = tempScore;

            } else 
            {
                // warn the user
                System.out.printf("Error - Input out of bound. Score can only be between %d and %d.\n", 
                                  INTERVAL[0], INTERVAL[1]);
            }
        }
    }

    /** 
     * @return String
     */
    public static String joinedStudentScores() 
    {
        String[] tempArray = new String[studentScores.length];
        for (int i = 0; i < studentScores.length; i++) 
        {
          tempArray[i] = String.valueOf(studentScores[i]);
        }
        return String.join(", ", tempArray);
    }
    
    //-----------------------------------------Task 2-------------------------------------------//
    
    /** 
     * @return double
     */
    public static double calculateMean()
    {   
        int scoreSum = 0;
        for (int i = 0; i < studentScores.length; i++) 
        { 
            scoreSum += studentScores[i];
        }
        return (double) scoreSum / NUMBER_OF_SCORES;
    } 

    //-----------------------------------------Task 3-------------------------------------------//    
    
    /** 
     * @return int[][]
     */
    public static int[][] twoExtremaOfScores() 
    {
        int highestScore = INTERVAL[0], secondHighestScore = INTERVAL[0];
        int lowestScore = INTERVAL[1], secondLowestScore = INTERVAL[1];

        for (int i = 0; i < studentScores.length; i++)
        {
            if (studentScores[i] > highestScore)
            {
                secondHighestScore = highestScore;
                highestScore = studentScores[i];                
            }
            else if (studentScores[i] > secondHighestScore)
            {
                secondHighestScore = studentScores[i];
            }

            if (studentScores[i] < lowestScore)
            {
                secondLowestScore = lowestScore;
                lowestScore = studentScores[i];
            }
            else if (studentScores[i] < secondLowestScore)
            {
                secondLowestScore = studentScores[i];
            }
        }

        return new int[][] { { highestScore, secondHighestScore }, { lowestScore, secondLowestScore } };
    }

    /** 
     * @param extremaScores
     */
    public static void printExtrema(int[][] extremaScores) 
    {
        int[] highestScores = extremaScores[0];
        int[] lowestScores = extremaScores[1];

        System.out.println("The two lowest scores provided are " 
                        + lowestScores[0] + ", and " + lowestScores[1]);

        System.out.println("The two highest scores provided are " 
                        + highestScores[0] + ", and " + highestScores[1]);
    }
        
    //-----------------------------------------Task 4-------------------------------------------//
        
    /** 
     * @return int[] 
     */
    public static int[] getHighestScoreWithIndex()
    {        
        int[] highestValueStruct = { 0, studentScores[0] }; // [value, index]

        for (int i = 1; i < NUMBER_OF_SCORES; i++)
        {
            if (studentScores[i] > highestValueStruct[1]) 
            {
                highestValueStruct[0] = i;
                highestValueStruct[1] = studentScores[i];
            }
        }
        return highestValueStruct;
    }
    
    /** 
     * @param highestValueStruct
     */
    public static void printHighestScoreWithIndex(int[] highestValueStruct)
    {
        int highestIdx = highestValueStruct[0];

        String ordinalIndicator = (highestIdx < 3) ? ORDINAL_INDICATORS[highestIdx] : ORDINAL_INDICATORS[3];
        
        System.out.printf("The highest score is %d and belongs to the %d%s student",
                            highestValueStruct[1], highestIdx + 1, ordinalIndicator);
        System.out.println(); // add new line
    }

    //-----------------------------------------Task 5-------------------------------------------//

    public static void collectHashtags()
    {
        input.cleanBuffer();
        String[] post = input.readFullStrSplit(" ", "Type your post");

        // TODO?: consider the case when there's only a single $ and nothing else via CodeGrade;
        // - test via CodeGrade; required to deduce the answer

        /*
         * Analysis:
         * If we suppose a post of size n, then there may be at most n hashtags;
         * Then, we initialise an array of size n, i.e, the length of the post.
         * The initial value assigned to each cell of the array is a type of null. 
         * Last accessed: 09-09-2022 */

        int hashtagCount = 0;
        String[] foundHashtags = new String[post.length];

        for (int i = 0; i < post.length; i++) {
            if (post[i].startsWith("#")) { // chech if the string begins with the '#' character
                foundHashtags[hashtagCount++] = post[i]; // this way, we also preserve the order of the hashtag
            }
        }

        /*
         * Analysis:
         * For the Arrays.copyOfRange() method, documentation from oracle.com:
         * https://docs.oracle.com/javase/6/docs/api/java/util/Arrays.html
         * By doing so, we remove all the null values from the array, i.e., create a
         * subset of the array.
         * Last accessed: 09-09-2022 */

        String[] foundHastagsSubset = Arrays.copyOfRange(foundHashtags, 0, hashtagCount);

        // check for the case when no hashtags are found, otherwise join all the hashtags per the instructions
        if (hashtagCount == 0) {
            System.out.println("No hashtags were typed.");
        } else {
            System.out.println("Hashtags found: " + String.join(" ", foundHastagsSubset));
        }
    }

    // -----------------------------------------Subroutines-------------------------------------------//
}
