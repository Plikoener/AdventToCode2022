package de.plikoener.adventToCode2022.Day10;

import org.junit.jupiter.api.Test;

import java.util.Objects;

import static org.junit.jupiter.api.Assertions.*;

class CommandTest {

    @Test
    void parseCommand() {
        assertArrayEquals("addx".toCharArray(),
                Objects.requireNonNull(Command.parseCommand("addx 1", Command.PART_OF_COMMAND.COMMAND)).toCharArray());
        assertArrayEquals("1".toCharArray(),
                Objects.requireNonNull(Command.parseCommand("addx 1", Command.PART_OF_COMMAND.VALUE)).toCharArray());
    }
}