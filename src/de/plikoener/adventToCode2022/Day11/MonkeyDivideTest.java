package de.plikoener.adventToCode2022.Day11;

public class MonkeyDivideTest {
     public static boolean isValidTest(String[] inputLines)
    {
        if (inputLines.length != 3)
            return false;
        boolean result;
        result = inputLines[0].trim().matches("Test:\sdivisible\sby\s\\d+");
        result = result &&  (inputLines[1].trim()).matches("If\strue:\sthrow\sto\smonkey\s\\d+");
        //                                   "If\strue:\sthrow\sto\smonkey\s\\d+"
        result = result &&  (inputLines[2].trim()).matches( "If\sfalse:\sthrow\sto\smonkey\s\\d+");

        return result;
    }
}
