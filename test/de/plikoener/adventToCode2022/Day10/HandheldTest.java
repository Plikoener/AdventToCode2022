package de.plikoener.adventToCode2022.Day10;

import de.pliconer.utils.AdventToCodeInputLoader;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class HandheldTest {

    @Test
    void executeProgramm() {
        String[] commandLines = {"noop","addx 3","addx -5"};
        executing(commandLines, 0);
        commandLines = AdventToCodeInputLoader.giveInPutFromFile("Day10Example.txt");
        executing(commandLines, 13140);


    }

    private void executing(String[] commandLines, int sumSignalStrength) {
        Handheld handheld = new Handheld();
        handheld.commandLines = commandLines.clone();
        handheld.executeProgramm();
        System.out.println(handheld.cpu);
        System.out.println(handheld.getSumOfSignalStrength());
        assertEquals(sumSignalStrength,handheld.getSumOfSignalStrength());
    }

    @Test
    void loadProgram() {
        Handheld handheld = new Handheld();
        handheld.loadProgram("Day10Example.txt");
        handheld.executeProgramm();
        assertEquals(13140, handheld.getSumOfSignalStrength());
    }
}