package de.plikoener.adventToCode2022.Day05;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CraneCommandTest {

    @Test
    void correctCommand() {
        String command1 = "move 1 from 2 to 1";
        String incorrectCommand1 = "move";
        new CraneCommand(command1);

        assertFalse(CraneCommand.correctCommand(incorrectCommand1));
        assertTrue(CraneCommand.correctCommand(command1));
    }

    @Test
    void extractFromCommand() {
        String input = "move 1 from 3 to 2";
        assertEquals(1, CraneCommand.extractFromCommand(input,"move","from"));
        assertEquals(3, CraneCommand.extractFromCommand(input,"from","to"));
        assertEquals(2, CraneCommand.extractFromCommand(input,"to","")); 
        String input1 = "move A from 3 to 2";
        try {
             CraneCommand.extractFromCommand(input1,"move","from");
        } catch (IllegalArgumentException e) {
           assertTrue(true);
        }
        String input2 = "move 10 from 7 to 3";
        assertEquals(10, CraneCommand.extractFromCommand(input2,"move","from"));
        assertEquals(7, CraneCommand.extractFromCommand(input2,"from","to"));
        assertEquals(3, CraneCommand.extractFromCommand(input2,"to",""));



    }
}