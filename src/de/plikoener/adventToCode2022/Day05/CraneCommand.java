package de.plikoener.adventToCode2022.Day05;

public class CraneCommand {
    int numberofCrates;
    int sourceStack;
    int targetStack;

    public int getNumberofCrates() {
        return numberofCrates;
    }

    public int getSourceStack() {
        return sourceStack;
    }

    public int getTargetStack() {
        return targetStack;
    }

    CraneCommand(String input)
    {
        numberofCrates = extractFromCommand( input, "move", "from");
        sourceStack = extractFromCommand( input, "from", "to");
        targetStack = extractFromCommand( input, "to", "");

    }

    public  static int extractFromCommand(String input, String startPattern, String stopPattern) {
        if (!correctCommand(input))
            throw new IllegalArgumentException("CraneCommand.extractFromCommand is call with not command String ("+input+")");

        int startIndex = input.indexOf(startPattern)+startPattern.length();
        int stopIndex =  (stopPattern.length()==0) ? input.length() : input.indexOf(stopPattern);
        String output= input.substring(startIndex,stopIndex);
        return Integer.parseInt(output.trim());

    }

    public static boolean correctCommand(String input)
    {
       return  input.trim().matches("move\s[0-9]{1,2}\sfrom\s[0-9]\sto\s[0-9]");

    }

    @Override
    public String toString() {
        return "CraneCommand{" +
                "numberofCrates=" + numberofCrates +
                ", sourceStack=" + sourceStack +
                ", targetStack=" + targetStack +
                '}';
    }
}
