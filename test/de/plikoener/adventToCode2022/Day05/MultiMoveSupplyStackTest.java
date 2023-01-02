package de.plikoener.adventToCode2022.Day05;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.IOException;

import static org.junit.jupiter.api.Assertions.*;

class MultiMoveSupplyStackTest   {

    private MultiMoveSupplyStack multiMoveSupplyStack ;

    @BeforeEach
    void setUp() throws IOException {
        multiMoveSupplyStack = new MultiMoveSupplyStack("Day05Example.txt");

    }

    MultiMoveSupplyStackTest() {
    }

    @Test
    void getMessageAfterExecuteCommands() {
        assertArrayEquals("MCD".toCharArray(),multiMoveSupplyStack.getMessageAfterExecuteCommands().toCharArray());



    }
}