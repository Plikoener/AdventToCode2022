package de.plikoener.adventToCode2022.Day04;

import de.pliconer.utils.AdventToCodeInputLoader;
import de.pliconer.utils.FileUtils;
import org.geeksforgeeks.findOverlappingSumOfTwoArrays.GFG;


import java.io.IOException;
import java.util.Arrays;
import java.util.Comparator;

import static de.pliconer.utils.PlikoenerUtils.debugLog;

public class CampCleanUp extends AdventToCodeInputLoader {

    final static boolean DEBUG = false;


    public CampCleanUp(String fileName) throws IOException {
        super(fileName);
    }

    public int countPairsWithFullyRangeEachOther() {
        int countFullRangeEachOtherPairs = 0;
        int countAFullRangeComparedAsInt=0;
        int i=0;
        for (String inputLine : fileContent
        ) {
            debugLog("Line"+ ++i,DEBUG);
            String[] pairRange = convertInputIntoRangeArray(inputLine);
            //debugLog("count Pairs "+ ++countPairs,DEBUG);
            //debugLog(inputLine + " -> " + pairRange[0] + " , " + pairRange[1], DEBUG);
           // Arrays.sort(pairRange, Comparator.comparingInt(String::length).reversed());

            if (pairRange[0].contains(pairRange[1]) || pairRange[1].contains(pairRange[0])){//!pairRange[0].equals(pairRange[1])) {
                debugLog(pairRange[0],DEBUG);
                int multiplyingFactor = pairRange[0].indexOf(pairRange[1]);

                debugLog(geMultiplyString(" ",multiplyingFactor)+pairRange[1],DEBUG);


                debugLog(inputLine +" is full range contain :"+  countFullRangeEachOtherPairs, DEBUG);
                countFullRangeEachOtherPairs++;
//            } else if (pairRange[1].equals(pairRange[0])) {
////                System.out.println(inputLine);
//                System.out.println("ident "+ pairRange[0]);
//                System.out.println("ident "+ pairRange[1]);

            }else{debugLog("not full range "+ inputLine,DEBUG);}


            // compare with integers
            int[][] pairsIntRange = convertInputIntoRangeArrayAsInt(inputLine);
            if(
                    pairsIntRange[0][0] >= pairsIntRange[1][0] &&
                    pairsIntRange[0][1] <= pairsIntRange[1][1]
            )
            {
                debugLog(Arrays.toString(pairsIntRange[1])+" contains A "+Arrays.toString(pairsIntRange[0] ),DEBUG);
                countAFullRangeComparedAsInt++;
            }
            else if(
                    pairsIntRange[1][0] >= pairsIntRange[0][0] &&
                    pairsIntRange[1][1] <= pairsIntRange[0][1]
            )
            {
                countAFullRangeComparedAsInt++;
                debugLog(Arrays.toString(pairsIntRange[0])+" contains B "+Arrays.toString(pairsIntRange[1] ),DEBUG);

            }
            debugLog("---"+ countFullRangeEachOtherPairs+ " / "+ countAFullRangeComparedAsInt,DEBUG);
        }
        debugLog ("### Line-Sum"+i,DEBUG);
        debugLog("Compared as Strings "+ countFullRangeEachOtherPairs,DEBUG);
        debugLog("Compared as Integer "+ countAFullRangeComparedAsInt,DEBUG);
        return countAFullRangeComparedAsInt;
    }

    public  String geMultiplyString (String input,int muliplyFactor) {
        return String.valueOf(input).repeat(Math.max(0, muliplyFactor));
    }

    /**
     * expand an input with given start and end numbers of to ranges to announced ranges
     * @param inputLine the input with syntax
     *                  <pre> &lt;StartNumberOfFirstRange&gt;-&lt;StopNumberOfFirstRange&gt;,&lt;StartNumberOfSecondRange&gt;-&lt;StopNumberOfSecondRange&gt;,
     *                      </pre>
     * @return the announced two ranges as String Array
     */
    String[] convertInputIntoRangeArray(String inputLine) {
        String[] rangeNotation = FileUtils.splitInToken(inputLine, ",");

        String[] rangeMap = new String[rangeNotation.length];
        for (int rangeCounter = 0; rangeCounter < rangeNotation.length; rangeCounter++) {
            rangeMap[rangeCounter] = convertNotationToMap(rangeNotation[rangeCounter]);
        }

        return rangeMap;
    }
    /**
     * expand an input with given start and end numbers of to ranges to announced ranges
     * @param inputLine the input with syntax
     *                  <pre> &lt;StartNumberOfFirstRange&gt;-&lt;StopNumberOfFirstRange&gt;,&lt;StartNumberOfSecondRange&gt;-&lt;StopNumberOfSecondRange&gt;,
     *                      </pre>
     * @return the announced two ranges as int Array
     */
    int[][] convertInputIntoRangeArrayAsInt(String inputLine) {

        String[]partsOfLine = FileUtils.splitInToken(inputLine,",");
        String[]firstPartRange = FileUtils.splitInToken(partsOfLine[0],"-");
        String[]SecondPartRange = FileUtils.splitInToken(partsOfLine[1],"-");
        return new int[][]{
                {
                    Integer.parseInt(firstPartRange[0]),
                    Integer.parseInt(firstPartRange[1])
                },
                {
                    Integer.parseInt(SecondPartRange[0]),
                    Integer.parseInt(SecondPartRange[1])

                }
        };
    }


    String convertNotationToMap(String rangeNotation) {

        String[] rangeIndexes = FileUtils.splitInToken(rangeNotation, "-");
        int startIndex = Integer.parseInt(rangeIndexes[0]);
        int endIndex = Integer.parseInt(rangeIndexes[1]);
        if (startIndex == endIndex) debugLog("no range"+ rangeNotation,DEBUG);
        //String debugOutput = "Parsing : "+ startIndex + " , "+ endIndex;
        //debugLog(debugOutput,DEBUG);
        StringBuilder rangeMap = new StringBuilder();
        for (int rangeIndex = startIndex; rangeIndex <= endIndex; rangeIndex++) {
            rangeMap.append(rangeIndex);
            rangeMap.append(" ");
        }
        return rangeMap.toString();
    }


    public static void main(String[] args) throws IOException {
        CampCleanUp campCleanUpPart1 = new CampCleanUp("Day04Input.txt");
        System.out.println("Day04 Part 1: " + campCleanUpPart1.countPairsWithFullyRangeEachOther());
        System.out.println("Before write every number of a range in a String and compared them."
                 + "(I don't seen that for example a 3 contain in 30 31 32 ...)"
                + " ...with the result ");
        System.out.println("Day04 Part 2: " + campCleanUpPart1.countPairsDoTheRangeOverlap());
    }

    /**
     * This was the first try to solute part two
     *
     * @return number of founded pairs
     */
    public   int countPairsFullyRangeWithStringContains() {
        int countFullRangeEachOtherPairs = 0;
        for (String inputLine : fileContent
        ) {

            String[] pairRange = convertInputIntoRangeArray(inputLine);
             Arrays.sort(pairRange, Comparator.comparingInt(String::length).reversed());

            if (pairRange[0].contains(pairRange[1]) ) {
                debugLog(pairRange[0],DEBUG);
                for (int countBlanks=0;countBlanks<pairRange[0].indexOf(pairRange[1]);countBlanks++) System.out.print(" ");
                debugLog(pairRange[1],DEBUG);

                //debugLog(inputLine +" is full range contain :"+  countFullRangeEachOtherPairs, DEBUG);
                countFullRangeEachOtherPairs++;
            } else
            {
                debugLog("not full range "+ inputLine,DEBUG);}

        }
        return countFullRangeEachOtherPairs;
    }

    /**
     *
     * @return sum of Pairs, which have some numbers common
     */
    public int countPairsDoTheRangeOverlap()
    {
        int countPairsDoTheRangeOverlap = 0;
        for (String inputLine : fileContent)
        {
            int[][]pairsRange = convertInputIntoRangeArrayAsInt(inputLine);
            int[]fullRange0 = CampCleanUp.getNumberSeriesAsArrayFromRangeArray(pairsRange[0]);
            int[]fullRange1 = CampCleanUp.getNumberSeriesAsArrayFromRangeArray(pairsRange[1]);

           if(GFG.findSum(fullRange0,fullRange1,Math.max(fullRange0.length,fullRange1.length))>0)
               countPairsDoTheRangeOverlap++;


        }

        return countPairsDoTheRangeOverlap;
    }
    public static int[] getNumberSeriesAsArrayFromRangeArray(int[]range)
    {
        int[] output = new int[range[1]-range[0]+1];
        int count=0;

        for (int rangeNumber = range[0]; rangeNumber <= range[1]; rangeNumber++) {
            output[count++]=rangeNumber;
        }
        return output;
    }






}
