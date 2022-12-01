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
}
