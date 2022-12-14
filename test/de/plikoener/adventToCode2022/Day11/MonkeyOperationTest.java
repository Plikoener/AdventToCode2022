package de.plikoener.adventToCode2022.Day11;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class MonkeyOperationTest {

    @Test
    void isValidCommand() {

        assertTrue(MonkeyOperation.isValidCommand("  Operation: new = old * 19"));
        assertTrue(MonkeyOperation.isValidCommand("  Operation: new = old + 6"));
        assertTrue(MonkeyOperation.isValidCommand("  Operation: new = old * old"));
        assertFalse(MonkeyOperation.isValidCommand("  Operation: new = old * "));
        assertFalse(MonkeyOperation.isValidCommand("  Operation: new = * old"));
        assertFalse(MonkeyOperation.isValidCommand("Monkey 0:"));
    }
}