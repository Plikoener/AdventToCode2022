package de.plikoener.adventToCode2022.Day11;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class MonkeyDivideTestTest {

    @Test
    void isValidTest() {
        String[]input =
                {
                        "Test: divisible by 23",
                        "  If true: throw to monkey 2",
                        "  If false: throw to monkey 3"

                };
        assertTrue(MonkeyDivideTest.isValidTest(input));
    }
}