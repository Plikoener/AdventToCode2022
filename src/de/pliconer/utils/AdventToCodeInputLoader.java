package de.pliconer.utils;

import java.io.File;
import java.io.IOException;
import java.util.Arrays;

public class AdventToCodeInputLoader {
    protected String[] fileContent;

    public AdventToCodeInputLoader(String fileName) throws IOException {
        if (fileName.isBlank())
        {
            return;
        }
        if( !fileName.contains(File.separator))
        {
            fileName = "input"+File.separator+fileName;
        }
        fileContent = FileUtils.loadLineFromFile(fileName);
    }
    public static String[] giveInPutFromFile(String fileNameStatic)
    {
        String[] output;

        try {
            AdventToCodeInputLoader loader = new AdventToCodeInputLoader(fileNameStatic);
            return loader.fileContent;
        } catch (IOException e) {
            System.err.println("File not found a minimal example is given back...");
            output = new String[]{""};

        }
        return output;
    }

}
