package de.plikoener.adventToCode2022.Day02;

import org.junit.jupiter.api.Test;

import java.io.File;
import java.io.IOException;

import static org.junit.jupiter.api.Assertions.*;

class PartTwoRockPaperScissorGameTest {

    @Test
    void getScoreOfStrategyGuide() throws IOException {
        PartTwoRockPaperScissorGame game = new PartTwoRockPaperScissorGame("input"+ File.separator+"Day02Example.txt");
        assertEquals(12,game.getScoreOfStrategyGuide());
    }
}