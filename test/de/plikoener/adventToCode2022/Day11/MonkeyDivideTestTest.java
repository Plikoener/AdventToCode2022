package de.plikoener.adventToCode2022.Day11;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class MonkeyDivideTestTest {

    private String[] input;

    @BeforeEach
    void setUp() {
        input = new String[]{
                "Test: divisible by 23",
                "  If true: throw to monkey 2",
                "  If false: throw to monkey 3"

        };
    }
    @Test
    void testConstructor()
    {
        MonkeyDivideTest monkeyDivideTest = new MonkeyDivideTest(input);
        assertEquals(23, monkeyDivideTest.divisor);
        assertArrayEquals("monkey 2".toCharArray(),monkeyDivideTest.trueMonkeyReceiverString.toCharArray());
        assertArrayEquals("monkey 3".toCharArray(),monkeyDivideTest.falseMonkeyReceiverString.toCharArray());

    }
    @Test
    void isValidTest() {
        assertTrue(MonkeyDivideTest.isValidTest(input));
    }
}