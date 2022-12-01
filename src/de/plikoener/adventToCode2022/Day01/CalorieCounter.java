package de.plikoener.adventToCode2022.Day01;

import de.pliconer.utils.FileUtils;
import de.pliconer.utils.PlikoenerUtils;

import java.io.IOException;

public class CalorieCounter {
    String filename;
    String[] fileContents;
    int maxCalorieSum;
    int[]maxThreeCalorieSum = new int[3];
    private final boolean DEBUG= true;

    public CalorieCounter(String filename) throws IOException {
        this.filename = filename;

        fileContents = FileUtils.loadLineFromFile
                (filename);
    }

    // One elve
    public int getMaxCalorieCountFromOneElf() {
        int calorieSumOfOneElf = 0;
        for (int fileInputLine=0;fileInputLine<=fileContents.length;fileInputLine++) {
            if (fileInputLine== fileContents.length||fileContents[fileInputLine].length() == 0) {
                maxCalorieSum = Integer.max(calorieSumOfOneElf, maxCalorieSum);
                calorieSumOfOneElf = 0;
            } else {
                PlikoenerUtils.debugLog(fileContents[fileInputLine]);
                int calorie = Integer.parseInt(fileContents[fileInputLine]);
                calorieSumOfOneElf = Math.addExact(calorieSumOfOneElf, calorie);
            }


        }

        return maxCalorieSum;
    }

    public int getSumOfTopThreeCalorieCount() {
        int calorieSumOfOneElf = 0;
        for (int fileInputLine=0;fileInputLine<=fileContents.length;fileInputLine++) {// (String fileInputLine : fileContents) {
            if (fileInputLine == fileContents.length||fileContents[fileInputLine].length() == 0) {
                // maxCalorieSum = Integer.max(calorieSumOfOneElf, maxCalorieSum);
                addSumToTopThreeSums(calorieSumOfOneElf);
                calorieSumOfOneElf = 0;
            } else {
                int calorie = Integer.parseInt(fileContents[fileInputLine]);
                calorieSumOfOneElf = Math.addExact(calorieSumOfOneElf, calorie);
            }

        }
        int finalCalorieSum =0;
        for (int sum:maxThreeCalorieSum
             ) {
            finalCalorieSum = Math.addExact(finalCalorieSum,sum);

        }
        return finalCalorieSum;
    }
    public String printAcualMaxThreeSums()
    {
        StringBuilder output = new StringBuilder(" - ");
        for (int sum:maxThreeCalorieSum
             ) {
            output.append(sum);
            output.append(" - ");

        }
        return output.toString();
    }

    private void addSumToTopThreeSums(int calorieSumOfOneElf) {
        for (int counter=0;counter<maxThreeCalorieSum.length;counter++) {
            if(calorieSumOfOneElf > maxThreeCalorieSum[counter]){
                if (counter < maxThreeCalorieSum.length-2)
                {
                    maxThreeCalorieSum[counter+2] = maxThreeCalorieSum[counter+1];
                }
                if (counter < maxThreeCalorieSum.length-1)
                {
                    maxThreeCalorieSum[counter+1] = maxThreeCalorieSum[counter];
                }
                maxThreeCalorieSum[counter] = calorieSumOfOneElf;
                PlikoenerUtils.debugLog(printAcualMaxThreeSums(),DEBUG);
                return;
            }
        }

    }
}
