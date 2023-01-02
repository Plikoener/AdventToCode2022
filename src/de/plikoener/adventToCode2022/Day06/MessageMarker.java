package de.plikoener.adventToCode2022.Day06;

import de.pliconer.utils.PlikoenerUtils;

import java.util.Stack;

public class MessageMarker {
    public static final int PACKET_MARKERS_LENGTH = 4;
    public static final int MESSAGE_MARKERS_LENGTH = 14;

    int markerLength;
    final  static boolean DEBUG = false;
    String markerCandidate;

    public MessageMarker(String markerCandidate) {
        this.markerCandidate = markerCandidate;
        PlikoenerUtils.debugLog(markerCandidate,DEBUG);
        markerLength = PACKET_MARKERS_LENGTH;
    }
    public MessageMarker(String markerCandidate,int markersLength)
    {
        this(markerCandidate);
        this.markerLength = markersLength;
    }
    public boolean isMarker() {

        if (!isCorrectMarkerLength()) {

            return false;
        }
            Stack<Character> stack = new Stack<>();
            for (char sign : markerCandidate.toCharArray()
            ) {
                if (stack.contains(sign)) {
                    return false;
                }
                stack.push(sign);

            }

        return true;

    }
    boolean isCorrectMarkerLength()
    {
        return markerLength == markerCandidate.length();
    }
}
