package de.plikoener.adventToCode2022.Day02.Day02;

import de.plikoener.adventToCode2022.Day02.RockPaperScissorsGame;

import java.io.File;
import java.io.IOException;

public class Day02 {
    public static void main(String[] args) throws IOException {
        RockPaperScissorsGame game;
        game = new RockPaperScissorsGame("input"+ File.separator+"Day02Input.txt");
        System.out.println("Day02 Part 1:"+ game.getScoreOfStrategyGuide());
    }
}
