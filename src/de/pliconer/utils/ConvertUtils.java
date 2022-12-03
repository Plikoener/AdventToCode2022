package de.pliconer.utils;

public class ConvertUtils {
    public static int[] convertStringOfDigitsToIntArray(String input) throws NumberFormatException
    {
        char[] cI= input.toCharArray();
        int[] values = new int[cI.length];
        for (int i=0;i< cI.length;i++)
        {
            values[i] = Integer.parseInt(String.valueOf(cI[i]));

        }

        return values;
    }

    /***
     *  You need to halves of a string with same size
     * This method was implemented for AdventToCode2022 Day3 Part 2
     * @param input A string that is to be split
     * @return An array of size 2 containing the halves of the input
     */
    public static String[]splitStringInTheMiddle(String input)
    {
        String[] output = new String[2];
        output[0] = input.substring(0,(input.length()/2));
        output[1] = input.substring(input.length()/2);
        return output;
    }
}
