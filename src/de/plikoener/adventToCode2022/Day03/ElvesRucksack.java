package de.plikoener.adventToCode2022.Day03;

import de.pliconer.utils.ConvertUtils;
import de.pliconer.utils.FileUtils;

import java.io.IOException;
import java.util.Arrays;
import java.util.Comparator;

public class ElvesRucksack {
    String[] fileContent;
    ElvesRucksack()
    {

    }
    ElvesRucksack(String filename) throws IOException {
        fileContent = FileUtils.loadLineFromFile(filename);
    }
    int getPriorityOfItem(char item)
    {
        if(item >= 'a' && item <= 'z' )
        {
            return (int)item-96;

        }else if(item >= 'A' && item <= 'Z' )
        {
            return (int)item-38;

        }
        return -1;
    }
    char getDoubleItem(String[] compartmentsContent)
    {
        for (int charCounter=0;charCounter<compartmentsContent[0].length();charCounter++)
        {
            char searchChar =compartmentsContent[0].charAt(charCounter);
            if(compartmentsContent[1].indexOf(searchChar) != -1)
                return searchChar;
        }
        return ' ';
    }
    public int getPrioritySumOfDoubleItems()
    {
        int sumOfPriorities =0;
        for (String fileInputLine:fileContent
             ) {
            sumOfPriorities= Math.addExact(sumOfPriorities,getPriorityOfItem(getDoubleItem(ConvertUtils.splitStringInTheMiddle(fileInputLine))));

        }

        return sumOfPriorities;
    }
    public int getPrioritySumOfBadges()
    {
        int sumOfPriorities=0;
        for (int groupCounter=0;groupCounter<fileContent.length;groupCounter+=3)
        {
            sumOfPriorities = Math.addExact(sumOfPriorities,getPriorityOfItem(getCommonItemOfGroup(
                    new String[]{
                            fileContent[groupCounter]
                            ,fileContent[groupCounter+1]
                            ,fileContent[groupCounter+2]
                    }
            )));

        }
        return sumOfPriorities;
    }
    char getCommonItemOfGroup(String[] groupLine)
    {
        Arrays.sort(groupLine, Comparator.comparingInt(String::length).reversed());
        for(int counter=0;counter<groupLine[0].length();counter++)
        {
            char searchChar=groupLine[0].charAt(counter);
            if(
                    groupLine[1].indexOf(searchChar) != -1
                    && groupLine[2].indexOf(searchChar) != -1
                    )
            {
                return searchChar;
            }
        }


        return ' ';
    }

}
