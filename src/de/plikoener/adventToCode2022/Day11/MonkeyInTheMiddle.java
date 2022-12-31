package de.plikoener.adventToCode2022.Day11;

import de.pliconer.utils.AdventToCodeInputLoader;
import de.pliconer.utils.FileUtils;
import de.pliconer.utils.OnlyTestCase;

import java.util.*;

public class MonkeyInTheMiddle {

    private static final int NUMBER_OF_ROUNDS = 20;
    //    Monkey[] player;
    ArrayList<Monkey> player;
    ArrayList<ThrownItem> thrownItems;
    long commonMultiple;
    int round;
    public MonkeyInTheMiddle()
    {
        round=0;
        commonMultiple=1;

    }
    public MonkeyInTheMiddle(String loadPlayerFile)
    {
        this();
        String[] inPutFromFile= AdventToCodeInputLoader.giveInPutFromFile(loadPlayerFile);
        String[][]monkeysData = FileUtils.combineLines(inPutFromFile,"Monkey\s\\d+:","");

        player = new ArrayList<>(monkeysData.length);

        for (String[] monkeyData : monkeysData) {
            if (Monkey.isValidMonkeyConfiguration(monkeyData)) {
                Monkey monkey = new Monkey(monkeyData);
                commonMultiple = Math.multiplyExact(commonMultiple,monkey.getDivideTestDivisor());
                player.add(monkey);
            }
        }
        System.out.println("CommonMultiple "+ commonMultiple);
        for (Monkey monkey:player
             ) {
            monkey.setCommonMultiple(commonMultiple);

        }
    }

    public void playRounds(int numberOfRounds)
    {

        @OnlyTestCase
        List<Integer> roundPrintValue=  Arrays.asList(1,2,3,4,5,6,7,18,19,20,21);

        for (int roundCounter = 0; roundCounter <  numberOfRounds; roundCounter++) {
            //            long startTime = System.nanoTime();
//            if (roundCounter % 1000 == 0)
//            {
//                roundPrint = false;
//            }

            for (Monkey monkey : player) {
                ThrownItem[] thrownItems = monkey.doTurn();

                for (ThrownItem thrownItem :
                        thrownItems)
                {
                    int index = player.indexOf(new Monkey(thrownItem.receiverName));
                    Monkey targetMonkey = player.get(index);
                    targetMonkey.catchItem(thrownItem.getValue());
                }
            }
            round++;
            if(numberOfRounds<= 20 )
                System.out.println(this);
            else if (roundPrintValue.contains(round)||round == 1 || round == 20 || round %1000 ==0 ) {
                System.out.println("== After round "+round+" ==");
                for (Monkey monkey :
                        player) {
                    System.out.println(monkey.getName()+" inspects items "+monkey.getInspectedItemsCounter()+" times.");
                }
            }
//            if(false) {
//
//                System.out.print("playRound :" + roundCounter + " duration ");
//                System.out.format("%,9d%n",(System.nanoTime() - startTime));
//                System.out.println();
//                }
            }
    }
    public void playRounds()
    {
        playRounds(NUMBER_OF_ROUNDS);
    }
    public long getMonkeyBusiness()
    {
        player.sort(Collections.reverseOrder());
        return Math.multiplyExact(player.get(0).getInspectedItemsCounter(),Long.valueOf(player.get(1).getInspectedItemsCounter()));
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
