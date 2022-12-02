package de.plikoener.adventToCode2022.Day02;

import de.pliconer.utils.FileUtils;

import java.io.IOException;
import java.util.HashMap;

public class RockPaperScissorsGame {
    HashMap<Character,HandShape> handShapes = new HashMap<>();
    String[] fileContent;
    final static int LOOSE_SCORE = 0;
    final static int DRAW_SCORE = 3;
    final static int WIN_SCORE = 6;

    public RockPaperScissorsGame() {
        HandShape rock = new HandShape("Rock",'A',1);
        HandShape paper = new HandShape("Paper",'B',2);
        HandShape scissors = new HandShape("Scissors",'C',3);
        rock.setShabbierShape(scissors);
        rock.setBetterShape(paper);
        paper.setShabbierShape(rock);
        paper.setBetterShape(scissors);
        scissors.setShabbierShape(paper);
        scissors.setBetterShape(rock);
        handShapes.put(rock.getShortcode(),rock);
        handShapes.put('X',rock);
        handShapes.put(paper.getShortcode(),paper);
        handShapes.put('Y',paper);
        handShapes.put(scissors.getShortcode(),scissors);
        handShapes.put('Z',scissors);


    }
    public RockPaperScissorsGame(String filename) throws IOException
    {
        this();
        fileContent = FileUtils.loadLineFromFile(filename);


    }
    int getScoreFromPlayingRound(char opponentShapeShort, char yourShapeShort)
    {
        HandShape yourShape = handShapes.get(yourShapeShort);
        return yourShape.getScoreOfDuel(opponentShapeShort);
        //return -1;
    }
    public int getScoreOfStrategyGuide()
    {
        int sumOfScore=0;
        for (String fileLine:fileContent)
             {
                 char opponentShapeChar = fileLine.charAt(0);
                 char yourShapeChar = fileLine.charAt(2);
                 sumOfScore= Math.addExact(sumOfScore,handShapes.get(yourShapeChar).getScoreOfDuel(opponentShapeChar));
             }





        return sumOfScore;
    }

}
