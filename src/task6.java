import java.util.Scanner;

public class task6 {
    public static void main(String[] args)
    {
        // TODO: new need Scanner class
        Scanner input = new Scanner(System.in);
        int option;
        
        do {
            System.out.println("Welcome to the menu. Choose one of the options below: ");
            System.out.println("\t1. Register new scores for students.");
            System.out.println("\t2. Calculate the mean of thet entered scores.");
            System.out.println("\t3. Find the two highest and two lowest scores.");
            System.out.println("\t4. Find the highest score and its position.");
            System.out.println("\t5. Collect hashstags from a post.");
            System.out.println("\t6. To exit.");
            System.out.println();
            System.out.print("Type your option: ");

            option = input.nextInt();

            switch (option) {
                
                // TODO: replace cases
                case 1: {
                    "".isEmpty(); 
                    break;
                }
                case 2: {
                    "".isEmpty();
                    break;
                } 
                case 3: {
                    "".isEmpty();
                    break;
                } 
                case 4: {
                    "".isEmpty();
                    break;
                }
                case 5: {
                    "".isEmpty();
                    break;
                }

                case 6: {
                    System.out.println("Thank you for using our grading system. Have a nice day!");
                    break;
                }
                
                default: {
                    System.out.println("Error - Invalid value. Please type between 1 and 6");
                    break;
                }
            }

        } while (option != 6);
        input.close();
    }
    
    // -----------------------------------------Subroutines-------------------------------------------//

    //-----------------------------------------Task 1-------------------------------------------//

    public static int[] readScores() {
        return new int[0];
    }

    public static void printScores(int[] scores)
    {
        System.out.println("Scores");
    }
    
    //-----------------------------------------Task 2-------------------------------------------//

    public static int[] calculateMean(int[] scores)
    {
        return new int[0];
    } 

    //-----------------------------------------Task 3-------------------------------------------//    
    
    public static int[] twoExtremaOfScores(int scores) 
    {
        return new int[0];    
    }

    //-----------------------------------------Task 4-------------------------------------------//

    public static int[] highestScoreWithIndex(int score)
    {
        return new int[0];
    }

    //-----------------------------------------Task 5-------------------------------------------//


    public static String collectHashtags()
    {
        return "";
    }

    // -----------------------------------------Subroutines-------------------------------------------//
}