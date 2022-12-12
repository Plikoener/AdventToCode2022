package de.pliconer.utils;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class FileUtils {
    public static String[] loadLineFromFile(String fileName) throws IOException {
        BufferedReader br;
        br = new BufferedReader(new FileReader(fileName));
        String inputLine;
        ArrayList<String> input = new ArrayList<>();
        while ((inputLine = br.readLine()) != null) {
//            StringTokenizer st = new StringTokenizer(inputLine, ",");
//            while (st.hasMoreTokens()) {
//                String inputString = st.nextToken();
//                input.add(inputLine);
            input.add(inputLine);

        }

        String[]returnValue = new String[input.size()];
        input.toArray(returnValue);
        return returnValue;

    }
    public static String[] splitInToken(String input, String delim)
    {
        ArrayList<String>output = new ArrayList<>();
        StringTokenizer st = new StringTokenizer(input,delim);
        while (st.hasMoreTokens())
        {
            output.add(st.nextToken());
        }
        return output.toArray(new String[0]);
    }

    /**
     * Combine line to an Array of line identified by <code>startPattern</code> and <code>stopPattern</code>
     *<p>
     *
     *     {}Usage: In AdventToCode Day 11 there is an input file with some related line repeated like
     * </p>
     * <pre>
     *     ...
     * Monkey 0:
     *   Starting items: 79, 98
     *   Operation: new = old * 19
     *   Test: divisible by 23
     *     If true: throw to monkey 2
     *     If false: throw to monkey 3
     *
     *  Monkey 1:
     *  ...
     * </pre>
     * @param input an Array of Strings with repeating structure of lines
     * @param startPattern  the first line of  related lines as regex Pattern
     * @param stopPattern  the last line of  related lines as regex Pattern
     * @return Array of the combined lines given as Array in the Array
     */
    public static String[][] combineLines(String[]input,String startPattern, String stopPattern)
    {
        ArrayList<String[]> output = new ArrayList<>();
        ArrayList<String> combineLines = new ArrayList<>();
        for (String inputLine:input
             ) {
            if(inputLine.matches(startPattern))
            {
                combineLines.clear();
                combineLines.add(inputLine);
            } else if (inputLine.matches(stopPattern)) {
                combineLines.add(inputLine);

                String[] outputEntry =  combineLines.toArray(new String[0]);
                output.add(outputEntry);
            }else
            {
                combineLines.add(inputLine);
            }

        }
        //return (String[][]) output.toArray();
        return  output.toArray(new String[output.size()][output.get(0).length]);
    }
}
