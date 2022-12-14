package de.plikoener.adventToCode2022.Day11;

import de.pliconer.utils.FileUtils;

import java.util.ArrayList;

/**
Monkey 0:
  Starting items: 79, 98
  Operation: new = old * 19
  Test: divisible by 23
    If true: throw to monkey 2
    If false: throw to monkey 3
*/
public class Monkey
{
    String name;
    ArrayList<Integer> items ;
    MonkeyOperation operation;
    MonkeyDivideTest divideTest;
    
    Monkey(String[] konfiguration)
    {

        this.name = konfiguration[0].split("Monkey\s\\d+")[0];
        items = new ArrayList<>();
        //TODO call setItems
        //TODO implement MonkeyOperation(String)
        //TODO implement MonkeyDivideTest(String[])
        
        
    }
    void setItems(String itemsLine)
    {
        String valuePart = FileUtils.splitInToken(itemsLine,":")[1];
        String[]values = FileUtils.splitInToken(valuePart,",");
        for (String value:values
             ) {
            items.add(Integer.parseInt(value.trim()));

        }

        //String valuesPart = itemsLine.substring(itemsLine.indexOf(":"));

    }
    public static boolean isValidName(String inputName)
    {
        return (inputName.trim()).matches("Monkey\s\\d+:");
    }
    public static boolean isValidStartItems(String inputItems)
    {
        return (inputItems.trim()).matches("Starting\sitems:\s(\\d+,\s)*\\d+");
                                                // "Starting\sitems:\s(\\d+,\s)*\\d+"
    }
    public static boolean isValidMonkeyConfiguration(String[] inputLines)
    {
        if (inputLines.length != 6 && inputLines.length != 7)
            return false;
        boolean result = Monkey.isValidName(inputLines[0]);
        result = result && Monkey.isValidStartItems(inputLines[1]);
        result = result && MonkeyOperation.isValidCommand(inputLines[2]);
        result = result && MonkeyDivideTest.isValidTest(new String[]{inputLines[3],inputLines[4],inputLines[5]});
        return result;
    }
  
   
}
