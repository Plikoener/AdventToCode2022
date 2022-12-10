package de.pliconer.utils;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.File;
import java.io.IOException;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;

class AdventToCodeInputLoaderTest {

    private String fileName;

    @BeforeEach
    void setUp() {
        fileName = "FileUtilTest.loadLineFromFile.txt";
    }

    @Test
    void AdventToCodeInputLoader() throws IOException {
        AdventToCodeInputLoader adventToCodeInputLoader = new AdventToCodeInputLoader(fileName);
        assertArrayEquals("First".toCharArray(),adventToCodeInputLoader.fileContent[0].toCharArray());
        AdventToCodeInputLoader adventToCodeInputLoader1 = new AdventToCodeInputLoader("input"+ File.separator+"FileUtilTest.loadLineFromFile.txt");
        assertArrayEquals("First".toCharArray(),adventToCodeInputLoader1.fileContent[0].toCharArray());
    }

    @Test
    void giveInPutFromFile() {
        String[] strings = AdventToCodeInputLoader.giveInPutFromFile(fileName);
        assertArrayEquals("First".toCharArray(), strings[0].toCharArray());
    }
}