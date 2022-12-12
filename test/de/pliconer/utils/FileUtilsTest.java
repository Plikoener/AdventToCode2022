package de.pliconer.utils;

import org.junit.jupiter.api.Test;

import java.io.File;
import java.io.IOException;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertEquals;

class FileUtilsTest {

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
        String[]input={
                "<book>",
                "<title>Der Junge aus London</title>",
                "<author>Noah Gordon</author>",
                "</book>",
                "<book>",
                "<title>Die Brüder Löwenherz</title>",
                "<author>Astrid Lindgren</author>",
                "</book>"


        };
        String[][] output = FileUtils.combineLines(input,"<book>","</book>");
        System.out.println(output.length);
        int inputLineCounter=0;
        for (String[] strings : output) {
            for (int lineCounter = 0; lineCounter < output[0].length; lineCounter++) {
                assertArrayEquals(input[inputLineCounter++].toCharArray(), strings[lineCounter].toCharArray());
            }
        }


    }
}