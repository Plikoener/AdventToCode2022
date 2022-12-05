package de.plikoener.adventToCode2022.Day05;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.IOException;

import static org.junit.jupiter.api.Assertions.*;

class SupplyStackTest {

    private SupplyStack supplyStack;

    @BeforeEach
    void setUp() throws IOException {
        supplyStack = new SupplyStack("Day05Example.txt");
    }

    @Test
    void isStackLine()
    {
        assertTrue(SupplyStack.isStackLine("[D]"));
        assertTrue(SupplyStack.isStackLine("   [D]   "));
        assertTrue(SupplyStack.isStackLine("   [D] [E]  "));
    }
    @Test
    void isStackBottomLine()
    {
        assertTrue(SupplyStack.isStackBottomLine("  2  "));
        assertTrue(SupplyStack.isStackBottomLine("  1   2  "));
        assertTrue(SupplyStack.isStackBottomLine("  1   2    3      "));
        assertFalse(SupplyStack.isStackBottomLine("  1   2 A   3      "));

    }

    @Test
    void fillStackOfCreates() {

    }

    @Test
    void splitStackLineIntoStackContent() {
        String[] expected = {"A","D","_","F"};
        String input = "[A] [D]    [F]";
        assertArrayEquals(expected,SupplyStack.splitStackLineIntoStackContent(input));
        String[] expected2 = {"_","A","D","F"};
        String input2 = "    [A]   [D]   [F]";
        assertArrayEquals(expected2,SupplyStack.splitStackLineIntoStackContent(input2));
    }
    @Test
    void ConstructorTest() {
        for (int i = 0; i< supplyStack.stackOfCrates.size(); i++)
            {
                System.out.println("Stack"+i+"has"+ supplyStack.stackOfCrates.get(i).size());
            }

    }

    @Test
    void getMessageAfterExecuteCommands() {
        assertArrayEquals("CMZ".toCharArray(),supplyStack.getMessageAfterExecuteCommands().toCharArray());
    }
}