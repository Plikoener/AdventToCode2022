package de.plikoener.adventToCode2022.Day04;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.*;

class CampCleanUpTest {

    private CampCleanUp campCleanUp;
    private CampCleanUp campCleanUpExample;

    @BeforeEach
    void setUp() throws IOException {
        campCleanUp = new CampCleanUp("");
        campCleanUpExample = new CampCleanUp("Day04Example.txt");
    }

    @Test
    void convertNotationToMap() {
        assertArrayEquals("1 2 ".toCharArray(), campCleanUp.convertNotationToMap("1-2").toCharArray());
        assertArrayEquals("2 3 4 ".toCharArray(), campCleanUp.convertNotationToMap("2-4").toCharArray());
        assertArrayEquals("6 7 8 ".toCharArray(), campCleanUp.convertNotationToMap("6-8").toCharArray());
        assertArrayEquals("3 4 5 6 7 ".toCharArray(), campCleanUp.convertNotationToMap("3-7").toCharArray());
        assertArrayEquals("64 65 66 ".toCharArray(), campCleanUp.convertNotationToMap("64-66").toCharArray());

    }

    @Test
    void countPairsWithFullyRangeEachOther() {
        assertEquals(2,campCleanUpExample.countPairsWithFullyRangeEachOther());


    }

    @Test
    void convertInputIntoRangeArray() {
        assertArrayEquals(new String[]{"2 3 4 ","6 7 8 "},campCleanUp.convertInputIntoRangeArray("2-4,6-8"));

    }

    @Test
    void convertInputIntoRangeArrayAsInt() {
        int [][] output = campCleanUp.convertInputIntoRangeArrayAsInt("1-2,3-4");
        System.out.println(Arrays.toString(output[0]));
        System.out.println(Arrays.toString(output[1]));
    }

    @Test
    void geMultiplyString() {
        assertArrayEquals("AAAAA".toCharArray(),campCleanUp.geMultiplyString("A",5).toCharArray());
    }
}