package de.plikoener.adventToCode2022.Day10;

import de.pliconer.utils.PlikoenerUtils;
import de.plikoener.adventToCode2022.Day10.Commands.AddX;
import de.plikoener.adventToCode2022.Day10.Commands.Noop;

import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;
import java.util.HashMap;

public class CPU {
    HashMap<String,Command> knownCommand = new HashMap<>();
    int registerX;
    int clock;
    private final PropertyChangeSupport support;
    Integer signalStrength;

    public CPU() {
        registerX=1;
        clock=0;
        initKnowCommands();
        support = new PropertyChangeSupport(this);
        signalStrength = 0;

    }

    public int getClock() {
        return clock;
    }

    private void initKnowCommands() {
        Noop command1 = new Noop();
        AddX command2 = new AddX(0);
        knownCommand.put(command1.getName(),command1);
        knownCommand.put(command2.getName(),command2);

    }

    public void addClock(int cycles)
    {
        for(int tick=0;tick<cycles;tick++) {
            clock++;
            support.firePropertyChange(Handheld.DRAW_CRT,getClock(),getRegisterX());
            if (lookingCycle()) {
                PlikoenerUtils.debugLog(this.toString(),false);
                Integer newSignalStrength = getSignalStrength();
                support.firePropertyChange(Handheld.SIGNAL_STRENGTH,signalStrength,newSignalStrength);
            }
        }

    }

    public int getRegisterX() {
        return registerX;
    }

    public void setRegisterX(int registerX) {
        this.registerX = registerX;
    }

    public int getSignalStrength()
    {
        if(lookingCycle())
        return clock * registerX;
        else
            return 0;
    }

    @Override
    public String toString() {
        return "CPU{" +
                "registerX=" + registerX +
                ", clock=" + clock +
                '}';
    }

    boolean lookingCycle() {


        boolean firstLookUp = getClock() == Handheld.CYCLE_FACTOR;
        boolean nextLookUp = (getClock()- Handheld.CYCLE_FACTOR) % (Handheld.CYCLE_FACTOR + Handheld.CYCLE_FACTOR) == 0;
        PlikoenerUtils.debugLog((getClock()- Handheld.CYCLE_FACTOR) + " % "+ (Handheld.CYCLE_FACTOR+ Handheld.CYCLE_FACTOR)+"="+ nextLookUp,false);
        return firstLookUp
                || (getClock() > Handheld.CYCLE_FACTOR && nextLookUp);
    }
    public void addPropertyChangeListener(PropertyChangeListener pcl){
        support.addPropertyChangeListener(pcl);
    }
    public void removePropertyChangeListener(PropertyChangeListener pcl){
        support.removePropertyChangeListener(pcl);
    }
}
