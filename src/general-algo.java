class Main{
    public static void main(String[] args) {
    }

    // ------------------------------------------------------------------------------------------------------------------------------------------------

    public static String GetSuffixOfNumber(int number)
    {
        // Every "teen" number (10 - 19) ends with "th" - If a number ends with a "teen" number, its suffix will always be "th"
        // Examples: 12th, 111th, 113th, 1002th

        String numberString = String.valueOf(number);
        int potentialTeenNumber = GetConsecutiveDigitsInNumber(numberString, numberString.length() - 2, numberString.length());

        int lastDigitInNumber = GetLastDigitInNumber(number);
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
        if (startIdx < 0 || endIdx > number.length())
        {
            return -1;
        }

        return Integer.parseInt(number.substring(startIdx, endIdx));
    }

    public static int GetLastDigitInNumber(long number)
    {
        return (int)(number % 10);
    }


    // ------------------------------------------------------------------------------------------------------------------------------------------------

    // Lines of codes that are coherent with the generalized function below:

    // int[] amountOfLowestAndHighestScores = new int[] {100, 100};  // Displays the X lowest andY highest scores (The boundaries of the input is 128, the maximal value a int can store)
    // LimitValues(amountOfLowestAndHighestScores, amountOfStudentScoresToRegister); // IMPORTANT: We can't get the 8 highest scores for the 7 student-scores

    // int[] lowestScores = DeclareArrayWithInitialisedFields(amountOfLowestAndHighestScores[0], maximalBoundary);
    // int[] highestScores = DeclareArrayWithInitialisedFields(amountOfLowestAndHighestScores[1], minimalBoundary);

    // In each iteration of the loop going through each score of the students:
    // InsertNumberInSpecifiedOrderArray(true, lowestScores, scoreOfCurrentStudent);
    // InsertNumberInSpecifiedOrderArray(false, highestScores, scoreOfCurrentStudent);

    // Insert an element in an array that either strives to fulfil the condition of being strictly increasing or decreasing
    // for each element when traversing from left to right
    public static int[] InsertNumberInSpecifiedOrderArray(boolean getLowest, int[] specifiedOrderArray, int numberToInsert)
    {
        for (int i = 0; i < specifiedOrderArray.length; i++)
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
    public static boolean CheckIfInsertNumberAtCurrentIndex(boolean findLowest, int currentValue, int numberToInsert)
    {
        if (findLowest)
            return numberToInsert < currentValue;
        else
            return numberToInsert > currentValue;
    }

    // Swaps the values of elements between different indices in the array with respect to the value of 'i': the index the current value will be inserted at
    public static void SwapPastElementsInArray(int[] specifiedOrderArray, int i)
    {
        for (int j = (int)(specifiedOrderArray.length - 1); j > i; j--)
            specifiedOrderArray[j] = specifiedOrderArray[j - 1];
    }

    public static void LimitValues(int[] values, int maximalAllowedValue)
    {
        for (int i = 0; i < values.length; i++)
        {
            if (values[i] > maximalAllowedValue)
                values[i] = maximalAllowedValue;
        }
    }

    public static int[] DeclareArrayWithInitialisedFields(int sizeOfArray, int value)
    {
        int[] array = new int[sizeOfArray];

        for (int i = 0; i < sizeOfArray; i++)
            array[i] = value;

        return array;
    }

    // ------------------------------------------------------------------------------------------------------------------------------------------------

    // Rounds 'X' decimals of a decimal number's decimals
    public static double RoundOffNumberWithXDecimals(double decimalNumber, int decimalsToRoundOff)
    {
        char[] factorCharacters = new char[decimalsToRoundOff + 1];
        factorCharacters[0] = '1';

        for (int i = 1; i <= decimalsToRoundOff; i++)
            factorCharacters[i] = '0';

        String factorString = new String(factorCharacters);
        short factor = Short.parseShort(factorString);

        double roundedNumberWithoutDecimal = Math.round(decimalNumber * factor);
        return roundedNumberWithoutDecimal / factor;
    }

    // ------------------------------------------------------------------------------------------------------------------------------------------------

    // The function below is a solution for finding every tag in a given string
    // DEFAULT PARAMETER VALUES (according to what is expected from task 5):
    // tag = '#', tagSeparator = ' ', minimalValidLengthOfTag = 0
    public static String IdentifyTags(String inputString, char tag, char tagSeparator, int minimalValidLengthOfTag)
    {
        boolean addToTag = false;
        int startIdx = 0;
        int endIdx = 0;

        int n = -1;
        while (GetAmountOfRequiredCharactersToFitNTags(n + 1, minimalValidLengthOfTag) <= inputString.length())
            n++;

        int maximalPossibleAmountOfTags = n + 1;

        if (maximalPossibleAmountOfTags == 0)
        {
            return "No hashtags were typed";
        }
        else
        {
            // Since we must use static arrays that requires us to specify their size we need this variable ('maximalPossibleAmountOfTags')
            // If we would be allowed to use dynamic arrays this variable would be completely useless, since we just
            // could have appended the next element to the end of the array storing the tags
            // without having to precalculate its size in advance

            int[][] startEndIdxTagIntervals = new int[maximalPossibleAmountOfTags][2];
            int currentStartEndInterval = 0;

            for (int i = 0; i < inputString.length(); i++)
            {
                char currentCharacter = inputString.charAt(i);

                if (currentCharacter == '#' && !addToTag)
                {
                    // If first '#' appears inside a word - Do not register it as a tag
                    if (i >= 1 && inputString.charAt(i - 1) != tagSeparator)
                        continue;

                    startIdx = i;
                    endIdx = i;
                    addToTag = true;
                }
                else if (currentCharacter == tagSeparator)
                {
                    if (CheckIfLengthOfTagIsValid(endIdx - startIdx, minimalValidLengthOfTag))
                    {
                        startEndIdxTagIntervals[currentStartEndInterval++] = RegisterCurrentTagSubstringIndexInterval(startIdx, endIdx);
                        startIdx = endIdx;
                    }

                    addToTag = false;
                }

                if (addToTag)
                    endIdx++;
            }

            if (CheckIfLengthOfTagIsValid(endIdx - startIdx, minimalValidLengthOfTag))
                startEndIdxTagIntervals[currentStartEndInterval++] = RegisterCurrentTagSubstringIndexInterval(startIdx, endIdx);

            if (startEndIdxTagIntervals[0][1] == startEndIdxTagIntervals[0][0])
                return "No hashtags were typed";
            else
            {
                String[] output = new String[currentStartEndInterval + 1];
                output[0] = "Hashtags found:";

                for (int i = 0; i < currentStartEndInterval; i++)
                    output[i + 1] = inputString.substring(startEndIdxTagIntervals[i][0], startEndIdxTagIntervals[i][1]);

                return String.join(" ", output);
            }
        }
    }

    // Number of characters required to fit 'n' space-separated tags in a string with the input string's length
    // mL = 'minimalValidLengthOfTag'  Example: mL = 2 tells us that every tag with 'mL' or more characters when excluding the first '#' is a valid tag
    // Formula:
    // (mL + 1) + ((mL + 2) * n) <= input.length(), where we want to find the maximal value for 'n'
    public static int GetAmountOfRequiredCharactersToFitNTags(int n, int minimalValidLengthOfTag)
    {
        return (minimalValidLengthOfTag + 1) + ((minimalValidLengthOfTag + 2) * n);
    }

    public static boolean CheckIfLengthOfTagIsValid(int lengthOfTag, int minimalValidLengthOfTag)
    {
        return lengthOfTag >= minimalValidLengthOfTag + 1;
    }

    public static int[] RegisterCurrentTagSubstringIndexInterval(int startIdx, int endIdx)
    {
        return new int[] {startIdx, endIdx};
    }
}