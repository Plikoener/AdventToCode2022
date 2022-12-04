package de.pliconer.utils;

import java.io.File;
import java.io.IOException;

public class AdventToCodeInputLoader {
    protected String[] fileContent;

    public AdventToCodeInputLoader(String fileName) throws IOException {
        if( !fileName.contains(File.separator))
        {
            fileName = "input"+File.separator+fileName;
        }
        fileContent = FileUtils.loadLineFromFile(fileName);
    }
}
