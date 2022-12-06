package de.plikoener.adventToCode2022.Day05;

import java.io.IOException;

public class Day05 {
    public static void main(String[] args) throws IOException {
        String fileName = "Day05Input.txt";
        SupplyStack supplyStackPart1 = new SupplyStack(fileName);
        System.out.println("Day04 Part 1: "+supplyStackPart1.getMessageAfterExecuteCommands());
        MultiMoveSupplyStack supplyStackPart2 = new MultiMoveSupplyStack(fileName);
        System.out.println("Day04 Part 2: "+supplyStackPart2.getMessageAfterExecuteCommands());

    }
}
