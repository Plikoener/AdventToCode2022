package de.plikoener.adventToCode2022.Day06;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class MessageMarkerTest {

    @Test
    void isMarker() {
        assertTrue(new MessageMarker("abcd").isMarker());
        assertTrue(new MessageMarker("1234").isMarker());
        assertFalse(new MessageMarker("124").isMarker());
        assertFalse(new MessageMarker("aabc").isMarker());
    }

    @Test
    void isCorrectMarkerLength() {
        assertTrue( new MessageMarker("abcd").isCorrectMarkerLength());
        assertFalse( new MessageMarker("ab").isCorrectMarkerLength());
        assertFalse( new MessageMarker("absdhjf").isCorrectMarkerLength());
        assertFalse( new MessageMarker("").isCorrectMarkerLength());
    }
}