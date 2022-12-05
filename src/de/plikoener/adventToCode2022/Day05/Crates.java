package de.plikoener.adventToCode2022.Day05;

public class Crates {
    public String getName() {
        return name;
    }

    String name;
    Crates(String label)
    {
        label =label.replace('[',' ');
        label= label.replace(']',' ');
        name= label.trim();

    }
}
