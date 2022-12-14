package de.plikoener.adventToCode2022.Day11;

public class MonkeyOperation {
    public MonkeyOperation() {
    }
    public static  boolean isValidCommand(String operationLine){
        String regex = "Operation:\snew\s=\s(old|new|\\d+)\s([*+])\s(old|new|\\d+)";


        return operationLine.trim().matches(regex);

    }
}
