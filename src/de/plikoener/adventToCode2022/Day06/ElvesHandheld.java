package de.plikoener.adventToCode2022.Day06;

import de.pliconer.utils.AdventToCodeInputLoader;
import de.pliconer.utils.PlikoenerUtils;

import java.io.IOException;
import java.util.*;

public class ElvesHandheld extends AdventToCodeInputLoader {
    private static final int MARKERS_LENGTH = 4;
     ArrayDeque<Character> markerQueue = new ArrayDeque<>(MARKERS_LENGTH);
    //TODO change to fixed size queue see https://www.baeldung.com/java-fixed-size-queue
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
        //TODO check if using String.substring is easier an isMarker(String markerCandidate,int markerSize)
        char[] inputAsArray= input.toCharArray();
        //markerQueue.clear();
        for(int charRead=0;charRead<inputAsArray.length;charRead++)
        {

            markerQueue.push(inputAsArray[charRead]);
            if (markerQueue.size()== MARKERS_LENGTH) {
                if (isMarker(convertArrayQueueToStack(markerQueue)))
                {
                    markerQueue.clear();
                    return charRead+1;
                }
                markerQueue.removeLast();
            }

        }
        return -1;
    }
    public int findPositionOfMarker2(String input)
    {
        for (int inputCounter=0;inputCounter<input.length()-MARKERS_LENGTH;inputCounter++)
        {
            if(isMarker(input.substring(inputCounter,inputCounter-MARKERS_LENGTH),MARKERS_LENGTH))
            {
                return  inputCounter+1;
            }
        }
        return -1;
    }

    private Stack<Character> convertArrayQueueToStack(ArrayDeque<Character> queue) {
        List list = Arrays.asList(queue);
        Stack<Character> markerCandidate =  new Stack<>();
        for (Character character : queue) {
            markerCandidate.push(character);
        }
        return markerCandidate;
    }
    public static boolean isMarker(String markerCandidate, int markerLength)
    {
        //TODO implement
        Stack<Character> stack = new Stack<>();
        for (char sign:markerCandidate.toCharArray()
             ) {
            stack.push(Character.valueOf(sign));

        }
        return false;
    }

    public static boolean isMarker(Stack<Character> markerCandidate) {
        while(!markerCandidate.isEmpty())
        {
            Character character = markerCandidate.pop();
            if(markerCandidate.contains(character))
            {
             return false;
            }


        }
        return true;
    }

    String getFirstMessage()
    {

        return fileContent[0];
    }




}
