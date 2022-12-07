package de.plikoener.adventToCode2022.Day06;

import de.pliconer.utils.AdventToCodeInputLoader;
import de.pliconer.utils.PlikoenerUtils;

import java.io.IOException;
import java.util.*;

public class ElvesHandheld extends AdventToCodeInputLoader {
    private static final int MARKERS_LENGTH = 4;
     ArrayDeque<Character> markerQueue = new ArrayDeque<>(MARKERS_LENGTH);

    final static boolean DEBUG = true;
    public ElvesHandheld(String fileName) throws IOException {
        super(fileName);
    }
    ElvesHandheld(String[]input) throws IOException {
        super("");
        fileContent = input;
        PlikoenerUtils.debugLog(String.valueOf(fileContent.length),DEBUG);


    }
    int findPositionOfMarker()
    {
        return findPositionOfMarker(fileContent[0]);
    }

    public  int findPositionOfMarker(String input) {
        char[] inputAsArray= input.toCharArray();
        for(int charRead=0;charRead<inputAsArray.length;charRead++)
        {
            markerQueue.push(inputAsArray[charRead]);
            if (markerQueue.size()== MARKERS_LENGTH) {
//                Object[] objArray = markerQueue.toArray();
//                Character[] markerCandidate = new Character[objArray.length];
//                System.arraycopy(objArray,0,markerCandidate,0,objArray.length);
//                for (Character markerCharacter : markerCandidate) {
//                }
                Iterator<Character> markerChar = markerQueue.iterator();
                while (markerChar.hasNext())
                {
                    markerChar.next();
                    if (false)
                        return charRead;

                }
// TODO Implement the check if the queue has a marker , extract to extra method
            }
        }
        return -1;
    }

    String getFirstMessage()
    {

        return fileContent[0];
    }




}
