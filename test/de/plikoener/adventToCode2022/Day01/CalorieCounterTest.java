package de.plikoener.adventToCode2022.Day01;

import de.pliconer.utils.PlikoenerUtils;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.File;
import java.io.IOException;

import static org.junit.jupiter.api.Assertions.*;

class CalorieCounterTest {
    boolean DEBUG=true;
    private String filename;

    @BeforeEach
    void setUp() {
        filename = "input" + File.separator + "Day01Example.txt";
    }

    @Test
    void getMaxCalorieCountFromOneElf() throws IOException {
        CalorieCounter cc = new CalorieCounter(filename);
        assertEquals(24000,cc.getMaxCalorieCountFromOneElf());
    }

    @Test
    void getSumOfTopThreeCalorieCount() throws IOException {
        CalorieCounter cc = new CalorieCounter(filename);
        PlikoenerUtils.debugLog(cc.printAcualMaxThreeSums(),DEBUG);
        assertEquals(45000,cc.getSumOfTopThreeCalorieCount());


    }
}