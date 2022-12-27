package de.plikoener.adventToCode2022.Day11;

public class MonkeyDivideTest {
    int divisor;
    String trueMonkeyReceiverString ;
    String falseMonkeyReceiverString ;

    public MonkeyDivideTest(String[] strings) {
        String[]divisorValue =strings[0].split("Test:\sdivisible\sby\s");
//        System.out.println(divisorValue.length);
        divisor = Integer.parseInt(divisorValue[1]);
        trueMonkeyReceiverString =  (strings[1].trim()).split("If\strue:\sthrow\sto\s")[1];
        falseMonkeyReceiverString =  (strings[2].trim()).split("If\sfalse:\sthrow\sto\s")[1];


    }

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
    public String [] getReceiverString()
    {
        return new String[]{trueMonkeyReceiverString, falseMonkeyReceiverString};
    }

    public String execute(int item) {
        if(item % divisor == 0)
            return trueMonkeyReceiverString;
        else
            return falseMonkeyReceiverString;
    }
}
