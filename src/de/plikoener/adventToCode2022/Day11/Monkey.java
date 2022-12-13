package de.plikoener.adventToCode2022.Day11;
/**
Monkey 0:
  Starting items: 79, 98
  Operation: new = old * 19
  Test: divisible by 23
    If true: throw to monkey 2
    If false: throw to monkey 3
*/
public class Monkey
{
    String name;
    Arraylist<Integer> items;
    MonkeyOperation operation;
    MonkeyDivideTest devideTest;
    
    Monkey(String[] konfiguration)
    {
        //line 0 is name
        this.name = konfiguration[0];
        
        
    }
  
   
}
