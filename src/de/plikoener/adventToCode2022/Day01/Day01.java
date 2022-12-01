package de.plikoener.adventToCode2022.Day01;

import java.io.File;
import java.io.IOException;

public class Day01 {
    public static void main(String[] args) throws IOException {
        CalorieCounter calorieCounter = new CalorieCounter("input"+ File.separator+"Day01Input.txt");
        System.out.println("Day 01 Part 1 :"+calorieCounter.getMaxCalorieCountFromOneElf());


    }
}
