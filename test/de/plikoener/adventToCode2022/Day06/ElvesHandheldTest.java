package de.plikoener.adventToCode2022.Day06;

import org.junit.jupiter.api.Test;

import java.io.IOException;

import static org.junit.jupiter.api.Assertions.*;

class ElvesHandheldTest {
    @Test
    void ConstructorTest() throws IOException {
        String message1 = "ABCDE";
        ElvesHandheld elvesHandheld = new ElvesHandheld(new String[]{message1});
       assertArrayEquals(message1.toCharArray(),elvesHandheld.getFirstMessage().toCharArray());

    }

    @Test
    void findPositionOfMarker() throws IOException {
        String input1 = "mjqjpqmgbljsphdztnvjfqwrcgsmlb";
        ElvesHandheld elvesHandheld = new ElvesHandheld("");
        assertEquals(7,elvesHandheld.findPositionOfMarker(input1));
    }
}