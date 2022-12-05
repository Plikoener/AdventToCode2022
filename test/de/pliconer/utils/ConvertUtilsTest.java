package de.pliconer.utils;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertEquals;

class ConvertUtilsTest {

    @Test
    void convertStringToIntArray() {
        String input1 ="12432344333";
        int [] output = ConvertUtils.convertStringOfDigitsToIntArray(input1);
        StringBuilder strB = new StringBuilder() ;// = output.toString();
        for (int j : output) {
            strB.append(j);
        }
        assertEquals(input1, strB.toString());

        String errorInput ="abcdef";
        NumberFormatException nfE = Assertions.assertThrows(NumberFormatException.class,()->
                ConvertUtils.convertStringOfDigitsToIntArray(errorInput), "NumberFormatException was expected"
        );
        assertEquals("For input string: \""+errorInput.toCharArray()[0] +"\"",nfE.getMessage());
        //int [] errorOutput = ConvertUtils.convertStringToIntArray(errorInput);
    }

    @Test
    void splitStringInTheMiddle() {
        String subStringA = "AAAA";
        String subStringB = "BBBB";
        String[] output = ConvertUtils.splitStringInTheMiddle(subStringA+subStringB);
        assertArrayEquals( subStringA.toCharArray(),output[0].toCharArray());
        assertArrayEquals( subStringB.toCharArray(),output[1].toCharArray());
    }
}