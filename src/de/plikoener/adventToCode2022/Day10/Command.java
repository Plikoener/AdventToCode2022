package de.plikoener.adventToCode2022.Day10;

import de.pliconer.utils.PlikoenerUtils;

import javax.swing.*;
import java.util.StringTokenizer;

public abstract class Command {
    protected final static boolean DEBUG = false;

    public enum PART_OF_COMMAND
    {
        COMMAND,
        VALUE
    }
    String name;
    int duration;
    int value;

    public Command(String name, int value,int duration) {
        this.name = name;
        this.duration = duration;
        this.value = value;
    }

    public Command(String name, int duration) {
        this.name = name;
        this.duration = duration;
        value =0;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getDuration() {
        return duration;
    }

    public void setDuration(int duration) {
        this.duration = duration;
    }

    public int getValue() {
        return value;
    }

    public void setValue(int value) {
        this.value = value;
    }
    public void setValue(String value)
    {
        if (value == null )
            return;
        setValue(Integer.parseInt(value));
    }
    public void execute(CPU cpu)
    {

        for(int tick=0;tick<duration;tick++)
            cpu.addClock();
        PlikoenerUtils.debugLog(this +" auf "+ cpu, DEBUG);

    }

    public static String parseCommand(String input, PART_OF_COMMAND choice) {
        StringTokenizer stringTokenizer = new StringTokenizer(input, " ");
        String output;
        if (stringTokenizer.hasMoreElements()) {
            output = stringTokenizer.nextToken();
            if (choice == PART_OF_COMMAND.COMMAND) {
                return output;
            }
            if (stringTokenizer.hasMoreElements()) {
                output = stringTokenizer.nextToken();
                if (choice == PART_OF_COMMAND.VALUE) {
                    return output;
                }
            }


        }
        return null;
    }

    @Override
    public String toString() {
        return "Command{" +
                "name='" + name + '\'' +
                ", duration=" + duration +
                ", value=" + value +
                '}';
    }
}
