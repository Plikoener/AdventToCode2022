package de.plikoener.adventToCode2022.Day11;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class MonkeyInTheMiddleTest {

    private MonkeyInTheMiddle game;
    private MonkeyInTheMiddle game2;

    @BeforeEach
    void setUp() {
        game = new MonkeyInTheMiddle("Day11Example.txt");
        game2 = new MonkeyInTheMiddle("Day11Example.txt");
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
        assertEquals(2713310158L,game.getMonkeyBusiness());


    }

    /**
     * When I get the hint from another solution auf this challenge part, I do not understand why the use of
     * commonMultiply is implemented to avoid numbers from overflowing.
     * I made compared two instances of @MonkeyInTheMiddle . The first on did not manage overflowing
     * This is the reason I have to limit the round to 10 , because by using 20 round a long overflow Exception thrown
     * <hr>
     * <p><b>Lession learned</b> </p>
     * The number of inspecting item of each monkey is the same.
     * The result of a int-divide-check is the same, if you use the origin number or your shorten it by common multiply
     * <hr>
     */
    @Test
    void compareFirstSomeRoundsOfPartTwo()
    {
        for (Monkey monkey :game.player
             ) {
            monkey.setShouldKeepWorryLevelManageable(false);

        }
        game.changeParameterForPartTwo();
        game2.changeParameterForPartTwo();
        for (int i = 0; i < 10; i++) {
            game.playRounds(1);
            game2.playRounds(1);
            for ( int monkeyCounter=0; monkeyCounter<game.player.size();monkeyCounter++) {


                int inspectedItemsCounter = game.player.get(monkeyCounter).getInspectedItemsCounter();
                int inspectedItemsCounter2 = game2.player.get(monkeyCounter).getInspectedItemsCounter();
                System.out.println(i+ ". Round - " +game.player.get(monkeyCounter).getName()+ ":  \t" +inspectedItemsCounter +" \t "+ inspectedItemsCounter2);
                if (inspectedItemsCounter != inspectedItemsCounter2)
                {
                    System.out.println( "############################## Behavior Differs at round"+ i);
                }
            }


        }

    }


}