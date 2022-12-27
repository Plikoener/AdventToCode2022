package de.plikoener.adventToCode2022.Day11;

import de.pliconer.utils.AdventToCodeInputLoader;
import de.pliconer.utils.FileUtils;

import java.util.ArrayList;
import java.util.Collections;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class MonkeyInTheMiddle {

    private static final int NUMBER_OF_ROUNDS = 20;
    //    Monkey[] player;
    ArrayList<Monkey> player;
    int round;
    public MonkeyInTheMiddle()
    {
        round=0;

    }
    public MonkeyInTheMiddle(String loadPlayerFile)
    {
        this();
        String[] inPutFromFile= AdventToCodeInputLoader.giveInPutFromFile(loadPlayerFile);
        String[][]monkeysData = FileUtils.combineLines(inPutFromFile,"Monkey\s\\d+:","");
//        player = new Monkey[monkeysData.length];
        player = new ArrayList<>(monkeysData.length);
        //for (String[] monkeyData: monkeysData)
        for (String[] monkeyData : monkeysData) {
            if (Monkey.isValidMonkeyConfiguration(monkeyData)) {
                Monkey monkey = new Monkey(monkeyData);
//                player[monkeyCounter] = monkey;
                player.add(monkey);
            }
        }
    }

    public void playRounds(int numberOfRounds)
    {
        for (int roundCounter = 0; roundCounter <  numberOfRounds; roundCounter++) {
            for (Monkey monkey : player) {
                ThrownItem[] thrownItems = monkey.doTurn();
                for (ThrownItem thrownItem :
                        thrownItems) {


                    int index = player.indexOf(new Monkey(thrownItem.receiverName));
                    Monkey targetMonkey = player.get(index);
                    targetMonkey.catchItem(thrownItem.getValue());
                }
            }
            round++;
            if(numberOfRounds<= 20 )//||round == 20 || round % 1000 == 0 ) {
                System.out.println(this);
            else if (round == 1 || round == 20 || round %1000 ==0 ) {
                System.out.println("== After round "+round+" ==");
                for (Monkey monkey :
                        player) {
                    System.out.println(monkey.getName()+" inspects items "+monkey.getInspectedItemsCounter()+" times.");
                }
            }
        }
    }
    public void playRounds()
    {
        playRounds(NUMBER_OF_ROUNDS);
    }
    public int getMonkeyBusiness()
    {
        player.sort(Collections.reverseOrder());
        return Math.multiplyExact(player.get(0).getInspectedItemsCounter(),player.get(1).getInspectedItemsCounter());
    }

    @Override
    public String toString() {
        StringBuilder stringOutput= new StringBuilder("After round "+round+", the monkey are holding the items with these worry levels:"+System.lineSeparator());
        for (Monkey monkey:player
             ) {
            stringOutput.append(monkey).append(System.lineSeparator());

        }

        return  stringOutput.toString();
    }
    public void changeParameterForPartTwo()
    {
        for (Monkey monkey :
                player) {
            monkey.setBoredDivisor(1);
        }
    }
}
