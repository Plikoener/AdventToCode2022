package de.plikoener.adventToCode2022.Day03;

import java.io.File;
import java.io.IOException;

public class Day03 {
    public static void main(String[] args) throws IOException {
        ElvesRucksack rucksack = new ElvesRucksack("input"+ File.separator+"Day03Input.txt");
        System.out.println("Day03 Part 1:"+ rucksack.getPrioritySumOfDoubleItems());
        System.out.println("Day03 Part 2:"+ rucksack.getPrioritySumOfBadges());
    }
}
