package de.plikoener.adventToCode2022.Day10.Commands;

import de.pliconer.utils.PlikoenerUtils;
import de.plikoener.adventToCode2022.Day10.CPU;
import de.plikoener.adventToCode2022.Day10.Command;

public class AddX extends Command {

    public AddX( int value) {
        super("addx", 2);

    }

    @Override
    public void execute(CPU cpu) {
        super.execute(cpu);
        PlikoenerUtils.debugLog("Before execute"+ this, DEBUG);
        cpu.setRegisterX(cpu.getRegisterX()+getValue());
        PlikoenerUtils.debugLog("After execute"+ this, DEBUG);
    }
}

