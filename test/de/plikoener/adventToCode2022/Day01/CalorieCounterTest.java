package de.plikoener.adventToCode2022.Day01;

import org.junit.jupiter.api.Test;

import java.io.File;
import java.io.IOException;

import static org.junit.jupiter.api.Assertions.*;

class CalorieCounterTest {

    @Test
    void getMaxCalorieCountFromOneElf() throws IOException {
        CalorieCounter cc = new CalorieCounter("input"+ File.separator+"Day01Example.txt");
        assertEquals(24000,cc.getMaxCalorieCountFromOneElf());
    }
}