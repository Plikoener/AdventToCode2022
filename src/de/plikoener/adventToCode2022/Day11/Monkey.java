package de.plikoener.adventToCode2022.Day11;

import de.pliconer.utils.FileUtils;
import de.pliconer.utils.OnlyTestCase;

import java.util.LinkedList;
import java.util.Locale;

/**
Monkey 0:
  Starting items: 79, 98
  Operation: new = old * 19
  Test: divisible by 23
    If true: throw to monkey 2
    If false: throw to monkey 3
*/
public class Monkey implements Comparable<Monkey> // , PropertyChangeListener
{
    private static final int BORED_DIVISOR = 3;
    int boredDivisor;
    @OnlyTestCase
    public void setShouldKeepWorryLevelManageable(boolean shouldKeepWorryLevelManageable) {
        this.shouldKeepWorryLevelManageable = shouldKeepWorryLevelManageable;
    }

    /**
     * It is only use for MonkeyInTheMiddleTest.compareFirstSomeRoundsOfPartTwo
     */
    @OnlyTestCase
    private boolean shouldKeepWorryLevelManageable;

    public LinkedList<Long> getItems() {
        return items;
    }

    public String getName() {
        return name;
    }

    String name;
    LinkedList<Long> items ;
    MonkeyOperation operation;
    MonkeyDivideTest divideTest;
    int inspectedItemsCounter;

    public void setCommonMultiple(long commonMultiple) {
        this.commonMultiple = commonMultiple;
    }

    long commonMultiple;
    LinkedList<ThrownItem>allThrownItems;
//    private final PropertyChangeSupport support;

    public int getInspectedItemsCounter() {
        return inspectedItemsCounter;
    }

    Monkey(String[] konfiguration)
    {

        this((konfiguration[0].split(":"))[0]);
        this.name = (konfiguration[0].split(":"))[0];
//        items = new ArrayList<>();
        items = new LinkedList<>();
        setItems(konfiguration[1]);
        operation= new MonkeyOperation(konfiguration[2]);
         divideTest = new MonkeyDivideTest(new String[]{konfiguration[3],konfiguration[4],konfiguration[5]});

         inspectedItemsCounter=0;





        
        
    }
//    public void addPropertiesChangeListeners(Monkey[]monkeys)
//    {
//        for (Monkey monkey:monkeys) {
//            this.addPropertyChangeListener(monkey);
//        }
//    }
    void setItems(String itemsLine)
    {
        String valuePart = FileUtils.splitInToken(itemsLine,":")[1];
        String[]values = FileUtils.splitInToken(valuePart,",");
        for (String value:values
             ) {
            long l = Long.parseLong(value.trim());
            items.addLast(l);

        }

        //String valuesPart = itemsLine.substring(itemsLine.indexOf(":"));

    }
    public void catchItem(long item)
    {
        items.addLast(item);
    }
    public static boolean isValidName(String inputName)
    {
        return (inputName.trim()).matches("Monkey\s\\d+:");
    }
    public static boolean isValidStartItems(String inputItems)
    {
        return (inputItems.trim()).matches("Starting\sitems:\s(\\d+,\s)*\\d+");
                                                // "Starting\sitems:\s(\\d+,\s)*\\d+"
    }
    public static boolean isValidMonkeyConfiguration(String[] inputLines)
    {
        if (inputLines.length != 6 && inputLines.length != 7)
            return false;
        boolean result = Monkey.isValidName(inputLines[0]);
        result = result && Monkey.isValidStartItems(inputLines[1]);
        result = result && MonkeyOperation.isValidCommand(inputLines[2]);
        result = result && MonkeyDivideTest.isValidTest(new String[]{inputLines[3],inputLines[4],inputLines[5]});
        return result;
    }
    public String getIdentifierName()
    {
        return name.toLowerCase(Locale.ROOT);
    }

    public ThrownItem[] doTurn()
    {
        ThrownItem[] thrownItems = new ThrownItem[items.size()];
        int itemCount=0;
        while (!items.isEmpty())
        {
            long item = items.pop();
//            item = operation.execute(item);
            item = operation.execute(item);


            if (boredDivisor == BORED_DIVISOR) {

                item = item / boredDivisor;
                //item = Math.floorDiv(item,boredDivisor);

            }else
            {
                item = keepWorryLevelManageable(item);
            }
            thrownItems[itemCount++] = new ThrownItem(item,divideTest.execute(item));
//            System.out.println(thrownItems[itemCount-1].toSuperString());
            inspectedItemsCounter++;
        }
       return thrownItems;

    }

    /**
     *
     * @see <a href="https://github.com/JeremyX9/adventofcode-22/blob/ff96f2a1bf2b5bebd2c0e99a4ddbbca9bbecad5c/Day-11/java/stebach/Day11.java#L211">Day11 Solution in Java from stebach</a>
     * @param item the value of the item
     * @return the value of the item after manipulation
     */
    private long keepWorryLevelManageable(long item) {
        //                int divisor = Integer.MAX_VALUE; //divideTest.getDivisor();
        if (!shouldKeepWorryLevelManageable)
            return item;
        long beforeCheckItem = item;

        if(item % commonMultiple == 0) //item.mod(BigInteger.valueOf(divisor)).equals(BigInteger.valueOf(0)))
        {
            item = commonMultiple;//BigInteger.valueOf(divisor);
        }else {
            item = item % commonMultiple;
            //item.mod(BigInteger.valueOf(divisor));
        }
        if (!(beforeCheckItem == item))
        {
            System.out.println(name+ " item value has changed from "+beforeCheckItem+" to "+ item);
        }
        return item;
    }

    public String[] getKeyOfRelatedMonkeys()
    {
        Item item ;
        return divideTest.getReceiverString();
    }

    @Override
    public String toString() {
        StringBuilder itemStrings = new StringBuilder();
        if(items.size()== 0)
        {
            return name+": ";
        }

        for (long item:items
             ) {
            itemStrings.append(item).append(", ");

        }

        return name+": "+ itemStrings.deleteCharAt(itemStrings.length()-2).toString().trim();

    }

    /**
     * Compares this object with the specified object for order.  Returns a
     * negative integer, zero, or a positive integer as this object is less
     * than, equal to, or greater than the specified object.
     *
     * <p>The implementor must ensure {@link Integer#signum
     * signum}{@code (x.compareTo(y)) == -signum(y.compareTo(x))} for
     * all {@code x} and {@code y}.  (This implies that {@code
     * x.compareTo(y)} must throw an exception if and only if {@code
     * y.compareTo(x)} throws an exception.)
     *
     * <p>The implementor must also ensure that the relation is transitive:
     * {@code (x.compareTo(y) > 0 && y.compareTo(z) > 0)} implies
     * {@code x.compareTo(z) > 0}.
     *
     * <p>Finally, the implementor must ensure that {@code
     * x.compareTo(y)==0} implies that {@code signum(x.compareTo(z))
     * == signum(y.compareTo(z))}, for all {@code z}.
     *
     * @param o the object to be compared.
     * @return a negative integer, zero, or a positive integer as this object
     * is less than, equal to, or greater than the specified object.
     * @throws NullPointerException if the specified object is null
     * @throws ClassCastException   if the specified object's type prevents it
     *                              from being compared to this object.
     * @apiNote It is strongly recommended, but <i>not</i> strictly required that
     * {@code (x.compareTo(y)==0) == (x.equals(y))}.  Generally speaking, any
     * class that implements the {@code Comparable} interface and violates
     * this condition should clearly indicate this fact.  The recommended
     * language is "Note: this class has a natural ordering that is
     * inconsistent with equals."
     */
    @Override
    public int compareTo(Monkey o) {
        return Integer.compare(inspectedItemsCounter, o.inspectedItemsCounter);
    }

    public void setBoredDivisor(int boredDivisor) {
        this.boredDivisor = boredDivisor;
    }

    public Monkey(String name) {
        this.name = name;
//         support = new PropertyChangeSupport(this);
        boredDivisor = BORED_DIVISOR;
        shouldKeepWorryLevelManageable=true;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj instanceof Monkey)
        {
            return((Monkey)obj).getIdentifierName().equals(this.getIdentifierName());
        }
        return false;
    }
    public int getDivideTestDivisor()
    {
        return divideTest.getDivisor();
    }
}
