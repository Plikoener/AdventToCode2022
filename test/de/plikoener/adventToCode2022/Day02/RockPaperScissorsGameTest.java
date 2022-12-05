package de.plikoener.adventToCode2022.Day02;

import org.junit.jupiter.api.Test;

import java.io.File;
import java.io.IOException;

import static org.junit.jupiter.api.Assertions.assertEquals;

class RockPaperScissorsGameTest {

    @Test
    void getScoreFromPlayingRound() {
        RockPaperScissorsGame game = new RockPaperScissorsGame();
        assertEquals(8,game.getScoreFromPlayingRound('A','Y'));
        assertEquals(1,game.getScoreFromPlayingRound('B','X'));
        assertEquals(6,game.getScoreFromPlayingRound('C','Z'));
    }

    @Test
    public void getScoreOfStrategyGuide() throws IOException {
        RockPaperScissorsGame game = new RockPaperScissorsGame("input"+File.separator+"Day02Example.txt");
        assertEquals(15,game.getScoreOfStrategyGuide());
    }
}