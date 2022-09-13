class Main{
    public static void main(String[] args) {
    }

    // ------------------------------------------------------------------------------------------------------------------------------------------------

    public static String GetSuffixOfNumber(byte number)
    {
        // Every "teen" number (10 - 19) ends with "th" - If a number ends with a "teen" number, its suffix will always be "th"
        // Examples: 12th, 111th, 113th, 1002th

        String numberString = String.valueOf(number);
        int potentialTeenNumber = GetConsecutiveDigitsInNumber(numberString, numberString.length() - 2, numberString.length());

        byte lastDigitInNumber = GetLastDigitInNumber(number);
        String suffix = "";

        if ((potentialTeenNumber >= 11 && potentialTeenNumber <= 19) || lastDigitInNumber >= 4 || lastDigitInNumber == 0)
            suffix = "th";
        else
        {
            if (lastDigitInNumber == 1)
                suffix = "st";
            else if (lastDigitInNumber == 2)
                suffix = "nd";
            else
                suffix = "rd";
        }

        return suffix;
    }

        // Gets the integer contained in a substring that is defined by start- and endIdx
    public static int GetConsecutiveDigitsInNumber(String number, int startIdx, int endIdx)
    {
        // The programmer set one or both of the last two parameters' to values to a value that's out of bounds
        if (startIdx < 0 || endIdx > number.length())
        {
            System.out.println("Error - 'startIdx' or 'endIdx' or both are out of bounds");
            return -1;
        }

        return Integer.parseInt(number.substring(startIdx, endIdx));
    }

    public static byte GetLastDigitInNumber(long number)
    {
        return (byte)(number % 10);
    }


    // ------------------------------------------------------------------------------------------------------------------------------------------------

    // Lines of codes that are coherent with the generalized function below

    // byte[] amountOfLowestAndHighestScores = new byte[] {100, 100};  // Displays the X lowest and Y highest scores (The boundaries of the input is 128, the maximal value a byte can store)
    // LimitValues(amountOfLowestAndHighestScores, amountOfStudentScoresToRegister); // IMPORTANT - Needs to be within boundaries

    // byte[] lowestScores = DeclareByteArrayWithInitialisedFields(amountOfLowestAndHighestScores[0], maximalBoundary);
    // byte[] highestScores = DeclareByteArrayWithInitialisedFields(amountOfLowestAndHighestScores[1], minimalBoundary);

    // In each iteration of the loop - Score of current student - Insert
    // InsertNumberInSpecifiedOrderArray(true, lowestScores, scoreOfCurrentStudent);
    // InsertNumberInSpecifiedOrderArray(false, highestScores, scoreOfCurrentStudent);

    // Insert an element in an array that either strives to fulfil the condition of being strictly increasing or decreasing
    // with its highest / lowest value stored at the first index of the array
    public static byte[] InsertNumberInSpecifiedOrderArray(boolean getLowest, byte[] specifiedOrderArray, byte numberToInsert)
    {
        for (byte i = 0; i < specifiedOrderArray.length; i++)
        {
            if (CheckIfInsertNumberAtCurrentIndex(getLowest, specifiedOrderArray[i], numberToInsert))
            {
                SwapPastElementsInArray(specifiedOrderArray, i);
                specifiedOrderArray[i] = numberToInsert;

                break;
            }
        }

        return specifiedOrderArray;
    }

    // Determines whether the value of the current element has found its position to be inserted
    // based on if the array are storing the highest or lowest values found
    public static boolean CheckIfInsertNumberAtCurrentIndex(boolean findLowest, byte currentValue, byte numberToInsert)
    {
        if (findLowest)
            return numberToInsert < currentValue;
        else
            return numberToInsert > currentValue;
    }

        // Swaps the values of elements between different indices in the array with respect to the value of 'i': the index the current value will be inserted at
    public static void SwapPastElementsInArray(byte[] specifiedOrderArray, byte i)
    {
        for (byte j = (byte)(specifiedOrderArray.length - 1); j > i; j--)
            specifiedOrderArray[j] = specifiedOrderArray[j - 1];
    }
}