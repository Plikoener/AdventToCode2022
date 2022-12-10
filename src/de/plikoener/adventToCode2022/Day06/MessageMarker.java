package de.plikoener.adventToCode2022.Day06;

import de.pliconer.utils.PlikoenerUtils;

import java.util.Stack;

public class MessageMarker {
    public static final int MARKERS_LENGTH = 4;
    final  static boolean DEBUG = false;
    String markerCandidate;

    public MessageMarker(String markerCandidate) {
        this.markerCandidate = markerCandidate;
        PlikoenerUtils.debugLog(markerCandidate,DEBUG);
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
        return MARKERS_LENGTH == markerCandidate.length();
    }
}
