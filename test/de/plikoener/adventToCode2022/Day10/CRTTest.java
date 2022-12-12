package de.plikoener.adventToCode2022.Day10;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.*;

class CRTTest {

    private CRT crt;

    @BeforeEach
    void setUp() {
        crt = new CRT();
    }

    @Test
    void testToString(){
        //CRT crt = new CRT();
        System.out.println(crt.toString());
    }

    @Test
    void arrayToString() {
        String[][] inputString = {{"1","2"},{"3","4"}};
        String expectedString =
                inputString[0][0]+" "+
                inputString[0][1]+" "+System.lineSeparator()+
                inputString[1][0]+" "+
                inputString[1][1]+" "+System.lineSeparator();
        CRT crt = new CRT();

        String actualString = crt.ArrayToString(inputString, " ");
        System.out.println(actualString);
        assertArrayEquals(expectedString.toCharArray(), actualString.toCharArray());
        actualString = crt.ArrayToString(inputString,"");
        expectedString =
                inputString[0][0]+
                        inputString[0][1]+System.lineSeparator()+
                        inputString[1][0]+
                        inputString[1][1]+System.lineSeparator();
        System.out.println(expectedString.length() + " , " + actualString.length());
        assertArrayEquals(expectedString.toCharArray(), actualString.toCharArray());

    }

    @Test
    void charArrayToString() {
        String line = "********************";
        char[][] input = {line.toCharArray(),line.toCharArray()};
        String expectedString =
                line + System.lineSeparator()+
                line + System.lineSeparator();
        String output = crt.charArrayToString(input,"",System.lineSeparator());
        System.out.println(output);
        assertArrayEquals(expectedString.toCharArray(),output.toCharArray());


    }

    @Test
    void drawPixel() {
        System.out.println(crt);
        crt.drawPixel(1,2,true);
        System.out.println(crt);
    }

    @Test
    void drawNextPixel() {
        for(int i=0;i<CRT.CRT_HEIGHT*CRT.CRT_WIDTH;i++)
        {
            crt.drawNextPixel(true);
            System.out.println(crt);
        }
        crt.drawNextPixel(false);
        System.out.println(crt);

    }

    @Test
    void isXinSprite() {
        assertTrue(CRT.isXinSprite(1,1));
        assertTrue(CRT.isXinSprite(2,1));
        assertTrue(CRT.isXinSprite(2,3));
        assertFalse(CRT.isXinSprite(1,5));
    }
}
