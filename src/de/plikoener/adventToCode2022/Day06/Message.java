package de.plikoener.adventToCode2022.Day06;

import de.pliconer.utils.AdventToCodeInputLoader;

import java.io.IOException;

public class Message {
    String dataStream;

    public Message(String dataStream) {
        this.dataStream = dataStream;
    }
    public int findEndPositionOfMarker()
    {
        for (int inputCounter=MessageMarker.MARKERS_LENGTH;inputCounter<dataStream.length();inputCounter++) {
            MessageMarker messageMarker = new MessageMarker(dataStream.substring(inputCounter - MessageMarker.MARKERS_LENGTH,
                    inputCounter )
                    );
            if (messageMarker.isMarker()) {
                return inputCounter ;
            }
        }


        return -1;
    }

    public static void main(String[] args) {
         String[] input = AdventToCodeInputLoader.giveInPutFromFile("Day6Input.txt");
         Message messagePart1 = new Message(input[0]);
        System.out.println("Day04 Part 2: "+ messagePart1.findEndPositionOfMarker());
    }

}
