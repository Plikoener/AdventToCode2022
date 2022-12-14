package de.plikoener.adventToCode2022.Day11;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class MonkeyTest {

    @Test
    void isValidName() {
        assertTrue(Monkey.isValidName("Monkey 1:"));
        assertTrue(Monkey.isValidName("Monkey 581:"));
        assertFalse(Monkey.isValidName("Monkey :"));
        assertFalse(Monkey.isValidName("Monkey a:"));
    }

    @Test
    void isValidStartItems() {
        assertTrue(Monkey.isValidStartItems("  Starting items: 79, 98"));
        assertTrue(Monkey.isValidStartItems("  Starting items: 79, 98"));
        assertTrue(Monkey.isValidStartItems("  Starting items: 79, 98, 10254"));
        assertTrue(Monkey.isValidStartItems("  Starting items: 79  "));
    }

    @Test
    void isValidMonkeyConfiguration() {
        String[] inputLines ={
                "Monkey 0:",
                "  Starting items: 79, 98",
                "  Operation: new = old * 19",
                "  Test: divisible by 23",
                "    If true: throw to monkey 2",
                "    If false: throw to monkey 3"
        };
        assertTrue(Monkey.isValidMonkeyConfiguration(inputLines));

    }

    @Test
    void setItems() {
        String input = "  Starting items: 79, 98";
        Monkey monkey = new Monkey(new String[]{input, input});
        monkey.setItems(input);
        assertEquals(79,monkey.items.get(0));
    }
}