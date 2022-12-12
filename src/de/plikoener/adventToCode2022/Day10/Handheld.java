package de.plikoener.adventToCode2022.Day10;

import de.pliconer.utils.AdventToCodeInputLoader;
import de.pliconer.utils.PlikoenerUtils;

import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;

public class Handheld implements PropertyChangeListener {
    public static final String SIGNAL_STRENGTH = "SignalStrength";
    public static final String DRAW_CRT = "DrawCRT";
    final static boolean DEBUG = false;
    public static final int CYCLE_FACTOR = 20;
    CPU cpu;
    CRT crt;
    String[] commandLines;

    public int getSumOfSignalStrength() {
        return sumOfSignalStrength;
    }

    int sumOfSignalStrength;

    public Handheld() {
        this.cpu = new CPU();
        sumOfSignalStrength=0;
        cpu.addPropertyChangeListener(this);

        crt = new CRT();
        cpu.addPropertyChangeListener(crt);

    }

    public boolean loadProgram(String filename) {
        commandLines = AdventToCodeInputLoader.giveInPutFromFile(filename);

        return commandLines.length != 1 && !commandLines[0].equals("");
    }

    public void executeProgramm() {
        if (commandLines == null) {
            System.err.println("no programm is loaded");
            return;
        }
        for (String commandLine : commandLines
        ) {

            String commandName = Command.parseCommand(commandLine, Command.PART_OF_COMMAND.COMMAND);
            String commandValue = Command.parseCommand(commandLine, Command.PART_OF_COMMAND.VALUE);
            Command command = cpu.knownCommand.get(commandName);
            command.setValue(commandValue);
            command.execute(cpu);


        }

    }

    @Override
    public void propertyChange(PropertyChangeEvent evt) {

        if (evt.getPropertyName().equals(SIGNAL_STRENGTH)) {
            Integer signalStrength = (Integer) evt.getNewValue();
            sumOfSignalStrength = sumOfSignalStrength + signalStrength;
        }
//        if (evt.getPropertyName().equals(DRAW_CRT))
//        {
//            System.out.println(evt.getOldValue()+ " /// "+ evt.getNewValue());
//            System.out.println(crt);
//        }
            System.out.println(evt.getPropertyName() + " get  " + evt.getNewValue());

    }
}

