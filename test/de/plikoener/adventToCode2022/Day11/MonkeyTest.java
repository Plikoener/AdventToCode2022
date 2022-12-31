package de.plikoener.adventToCode2022.Day11;

import de.pliconer.utils.AdventToCodeInputLoader;
import de.pliconer.utils.FileUtils;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class MonkeyTest {


    private String[][] monkeysData;

    @Test
    void isValidName() {
        assertTrue(Monkey.isValidName("Monkey 1:"));
        assertTrue(Monkey.isValidName("Monkey 581:"));
        assertFalse(Monkey.isValidName("Monkey :"));
        assertFalse(Monkey.isValidName("Monkey a:"));
    }

    @Test
    void isValidStartItems() {
        assertTrue(Monkey.isValidStartItems("  Starting items: 79, 98"));
        assertTrue(Monkey.isValidStartItems("  Starting items: 79, 98"));
        assertTrue(Monkey.isValidStartItems("  Starting items: 79, 98, 10254"));
        assertTrue(Monkey.isValidStartItems("  Starting items: 79  "));
    }

    @BeforeEach
    void setUp() {
        String[]inPutFromFile = AdventToCodeInputLoader.giveInPutFromFile("Day11Example.txt");
        monkeysData = FileUtils.combineLines(inPutFromFile,"Monkey\s\\d+:","");

    }

    @Test
    void isValidMonkeyConfiguration() {
        String[] inputLines ={
                "Monkey 0:",
                "  Starting items: 79, 98",
                "  Operation: new = old * 19",
                "  Test: divisible by 23",
                "    If true: throw to monkey 2",
                "    If false: throw to monkey 3"
        };
        assertTrue(Monkey.isValidMonkeyConfiguration(inputLines));

    }

    @Test
    void setItems() {
        String input = "  Starting items: 79, 98";
        Monkey monkey = new Monkey(monkeysData[0]);
        monkey.setItems(input);
        assertEquals(79,monkey.items.get(0));
    }
    @Test
    void generateMonkey()
    {


        for (String[] monkeyData: monkeysData
             ) {
            if(Monkey.isValidMonkeyConfiguration(monkeyData)){
                Monkey monkey = new Monkey(monkeyData);
                assertTrue(monkey.name.contains("Monkey"));
                assertTrue(monkey.items.size() > 0);
                StringBuilder expectData = new StringBuilder();
                for(String monkeyDataLine:monkeyData)
                {
                    expectData.append(monkeyDataLine);
                    expectData.append(System.lineSeparator());

                }
                System.out.println(expectData);
                StringBuilder actualData = new StringBuilder();
                actualData.append(monkey.name).append(":");
                actualData.append(System.lineSeparator());
                //items
                actualData.append(  "  Starting items: " );
                for (int itemCount=0;itemCount<monkey.items.size();itemCount++)
                {
                    actualData.append(monkey.items.get(itemCount));
                    if (itemCount+1<monkey.items.size())
                        actualData.append(", ");

                }
                actualData.append(System.lineSeparator());
                //operation
                actualData.append("  Operation: new = ");
                actualData.append(monkey.operation.operand1).append(" ").append(monkey.operation.operator).append(" ").append(monkey.operation.operand2).append(System.lineSeparator());
                //divideTest
                actualData.append("  Test: divisible by ").append(monkey.divideTest.divisor).append(System.lineSeparator());
                actualData.append("    If true: throw to ").append(monkey.divideTest.trueMonkeyReceiverString).append(System.lineSeparator());
                actualData.append("    If false: throw to ").append(monkey.divideTest.falseMonkeyReceiverString).append(System.lineSeparator());
                actualData.append(System.lineSeparator());

                System.out.println("Diff :\""+getDifferencesBetweenString(expectData.toString(),actualData.toString())+"\"");
                System.out.println(expectData.toString().toCharArray().length+ " length "+ actualData.toString().toCharArray().length);
                System.out.println("expected:"+System.lineSeparator()+expectData);
                System.out.println("actual:"+System.lineSeparator()+actualData);
                boolean equals = expectData.toString().trim().equals(actualData.toString().trim());
                System.out.println (equals);
                assertTrue (equals);
                 for (long item: monkey.items
                     ) {
                    System.out.println(item+ " of "+ monkey.name);



                }


                System.out.println();

            }
        }
    }
    String getDifferencesBetweenString(String input1, String input2)
    {
        StringBuilder compare = new StringBuilder();
        int minLength = Math.min(input1.length(),input2.length());
        int maxLength = Math.max(input1.length(),input2.length());

        for (int count = 0; count < minLength; count++) {
            if (!input1.substring(count,count+1).equals(input2.substring(count,count+1)) )
            {
                compare.append(input2.charAt(count));
            }
        }

        if (input1.length() > input2.length())
                compare.append(input1, minLength, maxLength);
            else if (input2.length() > input1.length()) {
                compare.append(input2, minLength, maxLength);

            }


        return compare.toString();

    }
    @Test
    void testGetDifferencesBetweenString()
    {
        assertEquals("", getDifferencesBetweenString("abc", "abc"));
        assertEquals("d", getDifferencesBetweenString("abcd", "abc"));
        assertEquals("cd", getDifferencesBetweenString("abcd", "acc"));
    }

    @Test
    void doTurn() {
        Monkey monkey = new Monkey(monkeysData[0]);
        ThrownItem[] thrownItems = monkey.doTurn();
        assertEquals("monkey 3", thrownItems[0].receiverName);
        assertEquals(500,thrownItems[0].getValue());

    }

    @Test
    void testToString() {
        Monkey monkey = new Monkey(monkeysData[0]);
        assertEquals("Monkey 0: 79, 98", monkey.toString());

    }

    @Test
    void compareTo() {
        Monkey monkey1 = new Monkey(monkeysData[0]);
        monkey1.inspectedItemsCounter = monkey1.items.size();
        Monkey monkey2 = new Monkey(monkeysData[1]);
        monkey2.inspectedItemsCounter = monkey2.items.size();
        assertTrue(monkey2.compareTo(monkey1)>0);


    }
}