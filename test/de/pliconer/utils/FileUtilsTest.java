package de.pliconer.utils;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.File;
import java.io.IOException;
import java.util.logging.*;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertEquals;

class FileUtilsTest {

    private static final Level loglevel = Level.FINE;
    private String[] combineLinesInput;
    private static final Logger logger = Logger.getLogger("de.plicoener.utils");

    @BeforeAll
    static void beforeAll() throws IOException {
        //System.setProperty("java.util.logging.SimpleFormatter.format",
         ///       "[%1$tF %1$tT] [%4$-7s] %5$s %n");
        Handler fh = new FileHandler("logs"+File.separator+"FileUtilsTest");
        fh.setFormatter(new SimpleFormatter());
        logger.addHandler(fh);
        logger.addHandler(new ConsoleHandler());
        logger.setLevel(loglevel);

    }

    @BeforeEach
    void setUp() {
        combineLinesInput = new String[]{
                "<book>",
                "<title>Der Junge aus London</title>",
                "<author>Noah Gordon</author>",
                "</book>",
                "<book>",
                "<title>Die Brüder Löwenherz</title>",
                "<author>Astrid Lindgren</author>",
                "</book>"


        };

    }

    @Test
    void loadLineFromFile() throws IOException {
        String content= "First\nSecound\nThird";
        String[] fileContents;
        fileContents = FileUtils.loadLineFromFile
                ("input"+ File.separator+"FileUtilTest.loadLineFromFile.txt");
        StringBuilder fileContent = new StringBuilder();
        for (int i=0;i<fileContents.length;i++)
              {
            fileContent.append(fileContents[i]);
            if(i<fileContents.length-1)
            {
                fileContent.append("\n");
            }



        }
        assertEquals(content,fileContent.toString());
    }

    @Test
    void splitInToken() {
        String tokenTest1="1,2,3";
        String delim1=",";
        String[] result1 = FileUtils.splitInToken(tokenTest1,delim1);
        assertEquals(result1[0],String.valueOf(tokenTest1.charAt(0)));
        assertEquals(result1[1],String.valueOf(tokenTest1.charAt(2)));
        assertEquals(result1[2],String.valueOf(tokenTest1.charAt(4)));


    }

    @Test
    void combineLines() {
        String[][] output = FileUtils.combineLines(combineLinesInput,"<book>","</book>");
        System.out.println(output.length);
        checkCombineLines(combineLinesInput, output);
        String[] fileInputDay11 = AdventToCodeInputLoader.giveInPutFromFile("Day11Example.txt");
        output = FileUtils.combineLines(fileInputDay11,"Monkey\\ [0-9]+:","");
        System.out.println(output.length);
        checkCombineLines(fileInputDay11,output);


    }

    private void checkCombineLines(String[] input, String[][] output) {
        int inputLineCounter=0;
        logger.fine("----"+System.lineSeparator()+"count of enties of input " + input.length +System.lineSeparator()+"----");
        int DEBUGlineOfOutput=0;
        for (String[] strings : output) {
            DEBUGlineOfOutput+=strings.length;
            logger.fine(DEBUGlineOfOutput +" : "+strings.length);

            for (int lineCounter = 0; lineCounter < strings.length ; lineCounter++) {
                logger.fine(input[inputLineCounter]+"("+inputLineCounter +") =? " +strings[lineCounter]+" ("+lineCounter+")" );
                assertArrayEquals(input[inputLineCounter++].toCharArray(), strings[lineCounter].toCharArray());
            }
        }
        logger.fine("----"+System.lineSeparator()+"count of enties of output " + DEBUGlineOfOutput +System.lineSeparator()+"----");
    }
}