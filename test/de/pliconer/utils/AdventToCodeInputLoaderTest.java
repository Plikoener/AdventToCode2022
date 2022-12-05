package de.pliconer.utils;

import org.junit.jupiter.api.Test;

import java.io.File;
import java.io.IOException;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;

class AdventToCodeInputLoaderTest {
    @Test
    void AdventToCodeInputLoader() throws IOException {
        AdventToCodeInputLoader adventToCodeInputLoader = new AdventToCodeInputLoader("FileUtilTest.loadLineFromFile.txt");
        assertArrayEquals("First".toCharArray(),adventToCodeInputLoader.fileContent[0].toCharArray());
        AdventToCodeInputLoader adventToCodeInputLoader1 = new AdventToCodeInputLoader("input"+ File.separator+"FileUtilTest.loadLineFromFile.txt");
        assertArrayEquals("First".toCharArray(),adventToCodeInputLoader1.fileContent[0].toCharArray());
    }
}