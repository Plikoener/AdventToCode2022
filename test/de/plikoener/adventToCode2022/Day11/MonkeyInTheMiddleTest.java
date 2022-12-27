package de.plikoener.adventToCode2022.Day11;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class MonkeyInTheMiddleTest {

    private MonkeyInTheMiddle game;

    @BeforeEach
    void setUp() {
        game = new MonkeyInTheMiddle("Day11Example.txt");
    }

    @Test
    void testToString() {
        System.out.println(game);
        assertEquals(("After round 0, the monkey are holding the items with these worry levels:" + System.lineSeparator()+
                "Monkey 0: 79, 98" + System.lineSeparator()+
                "Monkey 1: 54, 65, 75, 74" + System.lineSeparator()+
                "Monkey 2: 79, 60, 97" + System.lineSeparator()+
                "Monkey 3: 74"+System.lineSeparator()), game.toString());
    }

    @Test
    void playRounds() {
        game.playRounds();


    }

    @Test
    void getMonkeyBusiness() {
        game.playRounds();
        System.out.println(game.getMonkeyBusiness());
        assertEquals(10605,game.getMonkeyBusiness());
    }
    @Test
    void getMonkeyBusinessForPart2(){
        game.changeParameterForPartTwo();
        game.playRounds(10000);

    }
}