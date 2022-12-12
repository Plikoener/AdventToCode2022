package de.plikoener.adventToCode2022.Day10;

import de.pliconer.utils.AdventToCodeInputLoader;
import de.pliconer.utils.PlikoenerUtils;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class HandheldTest {

    private String executingReturn;

    @Test
    void executeProgramm() {
        String[] commandLines = {"noop","addx 3","addx -5"};
        executing(commandLines, 0);
        commandLines = AdventToCodeInputLoader.giveInPutFromFile("Day10Example.txt");
        executing(commandLines, 13140);
        String[] testInput = AdventToCodeInputLoader.giveInPutFromFile("Day10PartTwoTest.txt");
        String expected = new CRT().ArrayToString(testInput,System.lineSeparator());
        boolean partTwoCheck= (expected.length() == executingReturn.length());

        assertArrayEquals(expected.toCharArray(),executingReturn.toCharArray());


    }

    private void executing(String[] commandLines, int sumSignalStrength) {
        Handheld handheld = new Handheld();
        handheld.commandLines = commandLines.clone();
        handheld.executeProgramm();
        System.out.println(handheld.cpu);
        System.out.println(handheld.getSumOfSignalStrength());
        boolean partTwoCheck=false;
        assertEquals(sumSignalStrength,handheld.getSumOfSignalStrength());
        executingReturn = handheld.crt.toString();
    }

    @Test
    void loadProgram() {
        Handheld handheld = new Handheld();
        handheld.loadProgram("Day10Example.txt");
        handheld.executeProgramm();
        assertEquals(13140, handheld.getSumOfSignalStrength());
    }
}