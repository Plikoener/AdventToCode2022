package de.plikoener.adventToCode2022.Day01;

import de.pliconer.utils.FileUtils;

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
    public int getMaxCalorieCountFromOneElf()
    {
        int calorieSumOfOneElf=0;
        for (String fileInputLine:fileContents) {
            if (fileInputLine.length()==0)
            {
                maxCalorieSum= Integer.max(calorieSumOfOneElf,maxCalorieSum);
                calorieSumOfOneElf = 0;
            }else {
                int calorie = Integer.parseInt(fileInputLine);
                calorieSumOfOneElf = Math.addExact(calorieSumOfOneElf,calorie);
            }

        }

        return maxCalorieSum;
    }
}
