package de.plikoener.adventToCode2022.Day11;

public class Day11 {
    public static void main(String[] args) {
        MonkeyInTheMiddle part1 = new MonkeyInTheMiddle("Day11Input.txt");
        part1.playRounds();
        System.out.println(part1.getMonkeyBusiness());
        System.out.println("############################################");
        MonkeyInTheMiddle part2 = new MonkeyInTheMiddle("Day11Input.txt");
        part2.changeParameterForPartTwo();
        part2.playRounds(1000);

    }
}
