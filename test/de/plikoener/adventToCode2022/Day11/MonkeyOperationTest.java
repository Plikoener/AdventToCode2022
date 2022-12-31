package de.plikoener.adventToCode2022.Day11;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class MonkeyOperationTest {

    private String operationInputLine;
    private MonkeyOperation monkeyOperation;
    private  MonkeyOperation[]monkeyOperations;

    @BeforeEach
    void setUp() {
        String[] operationInputLines = {
                "new = old * 19",
                "new = 3 * old",
                "new = old + old"
        };
        monkeyOperations = new MonkeyOperation[operationInputLines.length];
        for (int i = 0; i < monkeyOperations.length; i++) {

            monkeyOperations[i] = new MonkeyOperation(" Operator: " + operationInputLines[i]);
        }
        operationInputLine = " Operation: new = old * 19";
        assertTrue(MonkeyOperation.isValidCommand(operationInputLine));
        monkeyOperation = new MonkeyOperation(operationInputLine);
    }

    @Test
    void isValidCommand() {

        assertTrue(MonkeyOperation.isValidCommand(operationInputLine));
        assertTrue(MonkeyOperation.isValidCommand("  Operation: new = old + 6"));
        assertTrue(MonkeyOperation.isValidCommand("  Operation: new = old * old"));
        assertFalse(MonkeyOperation.isValidCommand("  Operation: new = old * "));
        assertFalse(MonkeyOperation.isValidCommand("  Operation: new = * old"));
        assertFalse(MonkeyOperation.isValidCommand("Monkey 0:"));
    }
    @Test
    void isMonkeyOperatorConstructor()
    {


        assertEquals('*', monkeyOperation.operator.charAt(0));

    }


    @Test
    void execute() {
        assertEquals(190,monkeyOperation.execute(10));
        assertEquals(190,monkeyOperations[0].execute(10));
        assertEquals(30,monkeyOperations[1].execute(10));
        assertEquals(20,monkeyOperations[2].execute(10));


    }
    @Test
    void executeWithLongParameter()
    {
        long number =10L;
        assertEquals(190,monkeyOperation.execute(number));
        assertEquals(190,monkeyOperation.execute(10));
    }

    @Test
    void parseOperand() {
       assertEquals(79,MonkeyOperation.parseOperand("old",79));
       assertEquals(80,MonkeyOperation.parseOperand("80",79));

    }
}