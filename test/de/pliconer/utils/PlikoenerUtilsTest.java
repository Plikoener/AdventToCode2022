package de.pliconer.utils;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

class PlikoenerUtilsTest {
    private final ByteArrayOutputStream outContent = new ByteArrayOutputStream();
    private final ByteArrayOutputStream errContent = new ByteArrayOutputStream();
    private final PrintStream originalOut = System.out;
    private final PrintStream originalErr = System.err;
    private String endString;

    @BeforeEach
    void setUp() {
        System.setOut(new PrintStream(outContent));
        System.setErr(new PrintStream(errContent));
        endString = System.lineSeparator();
    }

    @AfterEach
    void tearDown() {
        System.setOut(originalOut);
        System.setErr(originalErr);
    }

    @Test
    void debugLog() {
        var message="TestdebugLog";
        PlikoenerUtils.debugLog(message);
        //int beginIndex = outContent.toString().length()-1 - message.length()-1;
        //String substring = outContent.toString().substring(beginIndex,beginIndex+ message.length());
        //assertEquals(message, substring);

        // [2022-11-20T16:49:39.061212700Z][PlikoenerUtils]Test debugLog
        //TODO Why sometime PlikoenerUtils is printed instead of the correct class name.
        // I guess in case a call the debugLog from a method call from another method in the class


       String regex = "\\[\\d{4}-\\d{2}-\\d{2}T\\d{2}:\\d{2}:\\d{2}\\.\\d{6,9}Z]\\[PlikoenerUtils]" + message + endString;

        assertTrue(outContent.toString().matches(regex));

    }

    @Test
    void testDebugLog() {
        var message="TestdebugLog";
        PlikoenerUtils.debugLog(message,false);
//        String regex2 = "\\[\\d{4}-\\d{2}-\\d{2}T\\d{2}\\:\\d{2}:\\d{2}\\.\\d{9}Z\\]\\[PlikoenerUtils\\]" + endString.toString();
        assertEquals("", outContent.toString());
    }
}