package de.plikoener.adventToCode2022.Day02;

public class HandShape {
    String friendlyName;

    public char getShortcode() {
        return shortcode;
    }

    public int getSelectPoint() {
        return selectPoint;
    }

    char shortcode;
    int selectPoint;

    public void setBetterShape(HandShape betterShape) {
        this.betterShape = betterShape;
    }

    public void setShabbierShape(HandShape shabbierShape) {
        this.shabbierShape = shabbierShape;
    }

    HandShape betterShape;
    HandShape shabbierShape;

    public HandShape(String friendlyName, char shortcode, int selectPoint) {
        this.friendlyName = friendlyName;
        this.shortcode = shortcode;
        this.selectPoint = selectPoint;
    }

    public HandShape getBetterShape() {
        return betterShape;
    }

    public HandShape getShabbierShape() {
        return shabbierShape;
    }

    public int getScoreOfDuel(char opponentShapeShort) {
        if (opponentShapeShort == shabbierShape.getShortcode())
        {
            return getSelectPoint() + RockPaperScissorsGame.WIN_SCORE;
        }else if (opponentShapeShort == betterShape.getShortcode())
        {
            return getSelectPoint() + RockPaperScissorsGame.LOOSE_SCORE;
        }else
        {
            return getSelectPoint() + RockPaperScissorsGame.DRAW_SCORE;
        }
    }
}
