package de.plikoener.adventToCode2022.Day06;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class MessageTest {

    @Test
    void findPositionOfMarker() {
        assertEquals(7,new Message("mjqjpqmgbljsphdztnvjfqwrcgsmlb").findEndPositionOfMarker());
        assertEquals(5,new Message("bvwbjplbgvbhsrlpgdmjqwftvncz").findEndPositionOfMarker());
        assertEquals(6,new Message("nppdvjthqldpwncqszvftbrmjlhg").findEndPositionOfMarker());
        assertEquals(10,new Message("nznrnfrfntjfmvfwmzdfjlvtqnbhcprsg").findEndPositionOfMarker());
        assertEquals(11,new Message("zcfzfwzzqfrljwzlrfnpqdbhtmscgvjw").findEndPositionOfMarker());
    }
}