package de.plikoener.adventToCode2022.Day05;

import de.pliconer.utils.AdventToCodeInputLoader;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Stack;

import static de.pliconer.utils.PlikoenerUtils.debugLog;

/**
 * The whole Stack of crates
 * Part of the Solution AdventToCode2022 Day05
 */
public class SupplyStack extends AdventToCodeInputLoader {
    final static boolean DEBUG = false;
    ArrayList<Stack<Crates>> stackOfCrates = new ArrayList<>();

    ArrayList<CraneCommand> craneCommands = new ArrayList<>();
    private String finalMessage;

    public SupplyStack(String fileName) throws IOException {
        super(fileName);
        Stack<String> stackLines = new Stack<>();

        boolean stackLineIsOpen = true;

        for (String inputLine : fileContent
        ) {
            if (stackLineIsOpen && isStackLine(inputLine)) {
                debugLog("load stackLine: "+ inputLine);
                stackLines.push(inputLine);
            } else if (isStackBottomLine(inputLine)) {
                stackLineIsOpen = false;
            } else if (CraneCommand.correctCommand(inputLine)) {
                craneCommands.add(new CraneCommand(inputLine));
            }
        }
        fillStackOfCreates(stackLines);
    }

    public static String[] splitStackLineIntoStackContent(String stackLine) {
        stackLine = stackLine.replaceAll("]\s{4}", "] [_] ");
        stackLine = stackLine.replaceAll("\s{4}", " [_] ");
        stackLine = stackLine.replaceAll("]\s*\\[", "#");

        stackLine = stackLine.replace('[', ' ');
        stackLine = stackLine.replace(']', ' ');
        stackLine = stackLine.trim();
        return stackLine.split("#");


    }
    public static boolean isStackLine(String inputLine) {
        return inputLine.matches("\s*(\\[[A-Z]]\s*)+");

    }

    public static boolean isStackBottomLine(String inputLine) {
        return inputLine.matches("(\s*[0-9]+\s*)+");
    }

    void fillStackOfCreates(Stack<String> stackLines) {
        while (!stackLines.isEmpty()) {
            String[] cratesNames = splitStackLineIntoStackContent(stackLines.pop());
            debugLog("push to Stacks "+ Arrays.toString(cratesNames));
            int numberOfStack = cratesNames.length;

            if (stackOfCrates.size() == 0) {
                initialiseStackOfCreates(numberOfStack);
            }

            for (int stackCounter = 0; stackCounter < numberOfStack; stackCounter++) {

                String createName = cratesNames[stackCounter];

                if (createName.contains("_")) {
                    continue;
                }
                debugLog("put Create "+ createName+" to stack "+ (stackCounter+1));
                Crates item = new Crates(createName);
                Stack<Crates> stack = stackOfCrates.get(stackCounter);
                stack.push(item);
                System.out.println(stackOfCrates.get(stackCounter).size() + " element in Stack " + stackCounter);
            }
        }
    }


    private void initialiseStackOfCreates(int numberOfStack) {

        stackOfCrates = new ArrayList<>();
        for (int stackCounter = 0; stackCounter < numberOfStack; stackCounter++) {

            stackOfCrates.add(new Stack<>());
        }
    }
    public String getMessageAfterExecuteCommands(){
        if(finalMessage == null) {
            executeCommands();
            StringBuilder messageBuilder = new StringBuilder(stackOfCrates.size());
            for (Stack<Crates> stackOfCrate : stackOfCrates) {
                messageBuilder.append(stackOfCrate.peek().getName());
            }
            finalMessage = messageBuilder.toString();
        }

        return finalMessage;

    }

    private void executeCommands() {
        for (CraneCommand command: craneCommands
             ) {
            executeCommand(command);
        }
    }

     void executeCommand(CraneCommand command) {
         debugLog(command.toString(),DEBUG);
        System.out.println(this);
        for(int moveCounter=0;moveCounter<command.getNumberofCrates();moveCounter++)
            stackOfCrates.get(command.getTargetStack() - 1).push(stackOfCrates.get(command.getSourceStack() - 1).pop());
    }

    @Override
    public String toString() {
        StringBuilder output= new StringBuilder();
        for (int stackCounter=0;stackCounter<stackOfCrates.size();stackCounter++)
             {
            Stack<Crates>stack = stackOfCrates.get(stackCounter);
            output.append(stackCounter+1);
            output.append("\t");
            output.append("#".repeat(stack.size()));
            output.append (" ");
            output.append (stack.size());
            output.append(System.getProperty("line.separator"));

        }
        return output.toString();
    }
}
