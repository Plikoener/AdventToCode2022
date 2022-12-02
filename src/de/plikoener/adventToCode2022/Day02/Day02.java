package de.plikoener.adventToCode2022.Day02;

import java.io.File;
import java.io.IOException;

public class Day02 {
    public static void main(String[] args) throws IOException {
        RockPaperScissorsGame game;
        String filename = "input" + File.separator + "Day02Input.txt";
        game = new RockPaperScissorsGame(filename);
        System.out.println("Day02 Part 1:"+ game.getScoreOfStrategyGuide());
        PartTwoRockPaperScissorGame gamePartTwo = new PartTwoRockPaperScissorGame(filename);
        System.out.println("Day02 Part 1:"+ gamePartTwo.getScoreOfStrategyGuide());
    }
}
