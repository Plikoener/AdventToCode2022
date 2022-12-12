package de.plikoener.adventToCode2022.Day10;

public class Day10 {
    public static void main(String[] args) {
        Handheld handheld = new Handheld();
        if (handheld.loadProgram("Day10Input.txt"))
        {
            handheld.executeProgramm();
            System.out.println("Solution of Day10 Part One :" + handheld.getSumOfSignalStrength());
            System.out.println("Solutionof Day10 Part Two:");
            System.out.println(handheld.crt.toString());
        }
    }
}
