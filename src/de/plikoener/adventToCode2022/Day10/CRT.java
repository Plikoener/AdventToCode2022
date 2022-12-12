package de.plikoener.adventToCode2022.Day10;

import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;

public class CRT implements PropertyChangeListener {

    public static final int CRT_HEIGHT = 6;
    public static final int CRT_WIDTH = 40;
    private static final char CHAR_LIT = '#';
    private static final char CHAR_DARK = '.';
    public static final int SPRITE_WIDTH = 3;
    char[][] crtScreen = new char[CRT_HEIGHT][CRT_WIDTH];
    CRTPosition position;

    public CRT() {
        for (int y=0;y<CRT_HEIGHT;y++)
        {
            for (int x=0;x<CRT_WIDTH;x++)
            {
                crtScreen[y][x]= '.';
            }
        }
        position = new CRTPosition(0,0);
    }
    public void drawNextPixel(boolean lit)
    {
        drawPixel(position,lit);
        if(++position.x % CRT_WIDTH == 0 ) {
            position.x = 0;
            position.y++;
        }
        if(position.y % CRT_HEIGHT == 0)
        {
            position.y = 0;
        }


    }
    public void drawPixel(CRTPosition pos,boolean lit)
    {
        drawPixel(pos.x, pos.y,lit);
    }
    public void drawPixel(int x, int y, boolean lit)
    {
        crtScreen[y][x] = (lit)? CHAR_LIT:CHAR_DARK;
    }
    String ArrayToString(Object input, String delimiter){

        StringBuilder output = new StringBuilder();
        if(input instanceof String [][])
        {
            for(String[]subArray:(String[][]) input)
            {
                output.append(ArrayToString(subArray, delimiter));
                output.append(System.lineSeparator());
            }

        } else if (input instanceof String[]) {
            for(String subString:(String[])input)
            {
                output.append(subString);
                output.append(delimiter);
            }
            output.trimToSize();

        }


        return output.toString();
    }
    String charArrayToString(Object input, String elementsDelimiter, String arrayDelimiter){

        StringBuilder output = new StringBuilder();
        if(input instanceof char [][])
        {
            for(char[]subArray:(char[][]) input)
            {
                output.append(charArrayToString(subArray, elementsDelimiter, arrayDelimiter));
                output.append(arrayDelimiter);
            }

        } else if (input instanceof char[]) {
            for(char subString:(char[])input)
            {
                output.append(subString);
                output.append(elementsDelimiter);
            }
            output.trimToSize();

        }


        return output.toString();
    }

    @Override
    public String toString() {
        return
                charArrayToString(crtScreen,"",System.lineSeparator());
    }

    /**
     * This method gets called when a bound property is changed.
     *
     * @param evt A PropertyChangeEvent object describing the event source
     *            and the property that has changed.
     */
    @Override
    public void propertyChange(PropertyChangeEvent evt) {
        System.out.println("CRT.propertyChange...");
        if (evt.getPropertyName().equals(Handheld.DRAW_CRT))
        {
            System.out.println("clock: "+evt.getOldValue()+ " x: "+ evt.getNewValue());
            System.out.println(this);
            int registerX = ((CPU)evt.getNewValue()).getRegisterX();
            boolean isList =  isXinSprite(registerX,position.x);
//            drawNextPixel(((CPU)evt.getNewValue()).getRegisterX() == position.x);
            drawNextPixel(isXinSprite(registerX, position.x));
//            if (((CPU)evt.getNewValue()).getRegisterX() == position.x)
//            {
//                drawNextPixel(true);
//            }else {
//                drawNextPixel(false);
//            }

        }

    }

    public static boolean isXinSprite(int middleXofSprite, int x) {
        return middleXofSprite-(SPRITE_WIDTH/2) <= x && x <= middleXofSprite+(SPRITE_WIDTH/2);
    }


}
