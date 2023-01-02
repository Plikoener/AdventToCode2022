package de.plikoener.adventToCode2022.Day06;

import de.pliconer.utils.AdventToCodeInputLoader;

public class Message {
    String dataStream;

    public Message(String dataStream) {
        this.dataStream = dataStream;
    }
    public int findEndPositionOfMarker(int markersLength)
    {
        for (int inputCounter = markersLength; inputCounter<dataStream.length(); inputCounter++) {
            MessageMarker messageMarker = new MessageMarker(dataStream.substring(inputCounter - markersLength,
                    inputCounter ),markersLength
                    );
            if (messageMarker.isMarker()) {
                return inputCounter ;
            }
        }



        return -1;
    }
    public int findEndPositionOfMarker()
    {
        return findEndPositionOfMarker(MessageMarker.PACKET_MARKERS_LENGTH);
    }

    public static void main(String[] args) {
         String[] input = AdventToCodeInputLoader.giveInPutFromFile("Day6Input.txt");
         Message messagePart1 = new Message(input[0]);
        System.out.println("Day04 Part 1: "+ messagePart1.findEndPositionOfMarker());
        System.out.println("Day04 Part 2: "+ messagePart1.findEndPositionOfMarker(MessageMarker.MESSAGE_MARKERS_LENGTH));
    }

}
