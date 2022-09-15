import java.util.Arrays;
import java.util.Scanner;

class Task5 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in); // declare the scanner

        System.out.print("Type your post: ");
        String[] post = input.nextLine().split(" "); // split the String by the spaces to String[]

        // TODO?: consider the case when there's only a single $ and nothing else
        // - test via CodeGrade; required to deduce the answer

        /*
         * Analysis:
         * If we suppose a post of size n, then there may be at most n hashtags;
         * Then, we initialise an array of size n, i.e, the length of the post.
         * The initial value assigned to each cell of the array is a type of null. */

        int hashtagCount = 0;
        String[] foundHashtags = new String[post.length];

        for (int i = 0; i < post.length; i++) 
        {
            if (post[i].startsWith("#")) 
            {                                               // chech if the string begins with the '#' character
                foundHashtags[hashtagCount++] = post[i];    // this way, we also preserve the order of the hashtag
            }
        }

        /*
         * Analysis:
         * For the Arrays.copyOfRange() method, documentation from oracle.com:
         * https://docs.oracle.com/javase/6/docs/api/java/util/Arrays.html
         * By doing so, we remove all the null values from the array, i.e., create a subset of the array.
         * Last accessed: 09-09-2022 */

        String[] foundHastagsSubset = Arrays.copyOfRange(foundHashtags, 0, hashtagCount);

        // check for the case when no hashtags are found, otherwise join all the hashtags per the instructions
        if (hashtagCount == 0) 
        {
            System.out.println("No hashtags were typed.");
        } else 
        {
            System.out.println("Hashtags found: " + String.join(" ", foundHastagsSubset));
        }

        // close the input
        input.close();
    }
}
