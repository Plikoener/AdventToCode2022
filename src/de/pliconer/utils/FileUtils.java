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
        return output.toArray(new String[output.size()]);
    }
}
