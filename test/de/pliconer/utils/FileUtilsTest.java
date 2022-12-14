package de.pliconer.utils;

import org.junit.jupiter.api.Test;

import java.io.File;
import java.io.IOException;

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

}