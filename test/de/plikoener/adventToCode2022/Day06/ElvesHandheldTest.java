package de.plikoener.adventToCode2022.Day06;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.util.*;

import static org.junit.jupiter.api.Assertions.*;

class ElvesHandheldTest {

    private ElvesHandheld elvesHandheld;

    @BeforeEach
    void setUp() throws IOException {
        elvesHandheld = new ElvesHandheld("");
    }

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

    @Test
    void isMarker() {
        String[][]testDataArray ={
            {"true","abc"},
            {"false","abbc"},
            {"false","abcc"},
            {"false","aabc"}
             
        };
        for (String[] testData:testDataArray
             ) {
            Stack<Character> testStack = new Stack<>();
            for (char testC:testData[1].toCharArray()
                 ) {
                testStack.push(Character.valueOf(testC));
            }
            assertEquals(Boolean.valueOf(testData[0]),ElvesHandheld.isMarker(testStack));
        }

    }

    @Test
    void testFindPositionOfMarker() throws IOException {
        assertEquals(7, elvesHandheld.findPositionOfMarker("mjqjpqmgbljsphdztnvjfqwrcgsmlb"));
        assertEquals(5, elvesHandheld.findPositionOfMarker("bvwbjplbgvbhsrlpgdmjqwftvncz"));
        assertEquals(6, elvesHandheld.findPositionOfMarker("nppdvjthqldpwncqszvftbrmjlhg"));
        assertEquals(10, elvesHandheld.findPositionOfMarker("nznrnfrfntjfmvfwmzdfjlvtqnbhcprsg"));
        assertEquals(11, elvesHandheld.findPositionOfMarker("zcfzfwzzqfrljwzlrfnpqdbhtmscgvjw"));

    }

    @Test
    void testFindPositionOfMarker1() {
        //TODO implement this test with example from desciption
    }

    @Test
    void testIsMarker() {
        assertFalse(ElvesHandheld.isMarker("aabb",4));
    }
}