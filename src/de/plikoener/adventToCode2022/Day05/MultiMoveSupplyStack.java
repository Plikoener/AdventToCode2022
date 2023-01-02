package de.plikoener.adventToCode2022.Day05;

import java.io.IOException;
import java.util.Stack;

public class MultiMoveSupplyStack extends SupplyStack {

    public MultiMoveSupplyStack(String fileName) throws IOException {
        super(fileName);
    }

    void executeCommand(CraneCommand command)
    {
        Stack<Crates> craneStack= new Stack<>();
        for(int popCounter=0;popCounter<command.getNumberofCrates();popCounter++)
        {
            craneStack.push(stackOfCrates.get(command.getSourceStack()-1).pop());
        }
        for(int pushCounter=0;pushCounter<command.getNumberofCrates();pushCounter++)
        {
            stackOfCrates.get(command.targetStack-1).push(craneStack.pop());

        }
        
    }
}
