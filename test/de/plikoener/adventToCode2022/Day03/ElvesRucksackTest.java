package de.plikoener.adventToCode2022.Day03;

import de.pliconer.utils.ConvertUtils;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.File;
import java.io.IOException;

import static org.junit.jupiter.api.Assertions.assertEquals;

class ElvesRucksackTest {

    private ElvesRucksack rucksack1;

    @BeforeEach
    void setUp() throws IOException {
        rucksack1 = new ElvesRucksack("input"+ File.separator+"Day03Example.txt");
    }

    @Test
    void getPriorityOfItem() {
        ElvesRucksack rucksack = new ElvesRucksack();
        assertEquals(16,rucksack.getPriorityOfItem('p'));
        assertEquals(38,rucksack.getPriorityOfItem('L'));
        assertEquals(42,rucksack.getPriorityOfItem('P'));
        assertEquals(22,rucksack.getPriorityOfItem('v'));
        assertEquals(20,rucksack.getPriorityOfItem('t'));
        assertEquals(19,rucksack.getPriorityOfItem('s'));
    }

    @Test
    void getDoubleItem() {
        ElvesRucksack rucksack = new ElvesRucksack();
        String[]input = {
                "abcd",
                "defg"};
        assertEquals('d',rucksack.getDoubleItem(input));
        char[]expectedChar = {'p','L','P','v','t','s'};
        for (int counter = 0; counter< rucksack1.fileContent.length; counter++)
        {
            assertEquals(expectedChar[counter], rucksack1.getDoubleItem(ConvertUtils.splitStringInTheMiddle(rucksack1.fileContent[counter])));
        }


    }

    @Test
    void getPrioritySumOfDoubleItems() {
        assertEquals(157,rucksack1.getPrioritySumOfDoubleItems());
    }

    @Test
    void getCommonItemOfGroup() {
        ElvesRucksack rucksack = new ElvesRucksack();
        String[] input={
                "abcefgfFdjygydfj",
                "hziuwhFkzsDhkaz",
                "ewhfksdhfdjfkljsdlfjdsljfFlsaj"
        };
        assertEquals('F',rucksack.getCommonItemOfGroup(input));
        assertEquals('r',rucksack1.getCommonItemOfGroup(new String[]{
                rucksack1.fileContent[0]
                , rucksack1.fileContent[1]
                , rucksack1.fileContent[2]
        }));        assertEquals('Z',rucksack1.getCommonItemOfGroup(new String[]{
                rucksack1.fileContent[3]
                , rucksack1.fileContent[4]
                , rucksack1.fileContent[5]
        }));
    }

    @Test
    void getPrioritySumOfBadges() {
        assertEquals(70,rucksack1.getPrioritySumOfBadges());
    }
}