package de.plikoener.adventToCode2022.Day02;

import java.io.IOException;

public class PartTwoRockPaperScissorGame extends RockPaperScissorsGame {
    public PartTwoRockPaperScissorGame(String filename) throws IOException {
        super(filename);
    }

    @Override
    public int getScoreOfStrategyGuide() {
        int sumOfScore = 0;

        for (String fileLine : fileContent) {
            char opponentShapeChar = fileLine.charAt(0);
            char yourStrategyChar = fileLine.charAt(2);
            char yourShapeChar = switch (yourStrategyChar) {
                case 'X' ->// you have to loose
                        handShapes.get(opponentShapeChar).getShabbierShape().getShortcode();
                case 'Y' ->// you have to draw
                        opponentShapeChar;
                case 'Z' ->// you have to win
                        handShapes.get(opponentShapeChar).getBetterShape().getShortcode();
                default -> ' ';
            };
            sumOfScore = Math.addExact(sumOfScore, handShapes.get(yourShapeChar).getScoreOfDuel(opponentShapeChar));
        }


        return sumOfScore;
        //return super.getScoreOfStrategyGuide();
    }
}
