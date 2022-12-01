package de.plikoener.adventToCode2022.Day01;

import de.pliconer.utils.FileUtils;
import de.pliconer.utils.PlikoenerUtils;

import java.io.IOException;

public class CalorieCounter {
    String filename;
    String[] fileContents;
    int maxCalorieSum;

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
}
