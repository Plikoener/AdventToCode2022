package de.plikoener.adventToCode2022.Day05;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;

class CratesTest {

    @Test
    void getName() {

        String label = " [A] ";
        Crates crates = new Crates(label);
        assertArrayEquals("A".toCharArray(),crates.getName().toCharArray());
    }
}