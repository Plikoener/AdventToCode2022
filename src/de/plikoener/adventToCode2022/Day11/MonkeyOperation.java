package de.plikoener.adventToCode2022.Day11;

import javax.script.ScriptEngine;
import javax.script.ScriptEngineManager;
import javax.script.ScriptException;

public class MonkeyOperation {
    String operand1;
    String operator;
    String operand2;
    String operationTerm;

    public MonkeyOperation(String operationInputLine) {

        operationTerm = operationInputLine.trim();
        String[] splitResult = operationTerm.split("\s");
        operand1 = splitResult[3];
        operator = splitResult[4];
        operand2 = splitResult[5];
    }

    public static boolean isValidCommand(String operationLine) {
        String regex = "Operation:\snew\s=\s(old|new|\\d+)\s([*+])\s(old|new|\\d+)";


        return operationLine.trim().matches(regex);

    }

    static int parseOperand(String operatorString, int oldValue) {
        if (operatorString.equals("old")) {
            return oldValue;
        } else {
            return Integer.parseInt(operatorString);
        }
    }
    static long parseOperand(String operatorString, long oldValue)
    {
        if (operatorString.equals("old")) {
            return oldValue;
        } else {
            return Long.parseLong(operatorString);
        }

    }

    public int executeWithScriptEngine(int itemValue) {

        String executionTerm = operationTerm.split("=")[1].replaceAll("\s", "");
        executionTerm = executionTerm.replace("old", Integer.toString(itemValue));
        ScriptEngineManager mgr = new ScriptEngineManager();
        ScriptEngine engine = mgr.getEngineByName("JavaScript");
        String expression = executionTerm;
        int result = -1;
        try {
            System.out.println(engine.eval(expression));
            result = (int) engine.get(expression);
        } catch (ScriptException ex) {
            System.out.println("Error occured.");
        }
        return result;
    }

//    public int executeWithJShell(int itemValue) {
//        //sometimes  modify execute with using parts of de.pliconer.utils.Eval
//        String executionTerm = operationTerm.split("=")[1].replaceAll("\s", "");
//        executionTerm = executionTerm.replace("old", Integer.toString(itemValue));
//        JShell jshell = JShell.create();
//
//        int result = -1;
////        try {
////            System.out.println(engine.eval(expression));
////            result = (int) engine.get(expression);
////        } catch (ScriptException ex) {
////            System.out.println("Error occured.");
////        }
//        return result;
//    }

    /**
     * This method is the minimal solution. It only can multiply and add the two values
     *
     * @param itemValue the acutal worry level of the item
     * @return  the result of the calculation
     */
    public int execute(int itemValue) {
        if (operator.equals("*")) {
            int factor1 = parseOperand(operand1, itemValue);
            int factor2 = parseOperand(operand2, itemValue);
//            System.out.println(factor1*factor2);
            //FIXME integer overflow modify from Int to long
            return Math.multiplyExact(factor1 , factor2);
        } else {
            return parseOperand(operand1, itemValue) + parseOperand(operand2, itemValue);
        }

    }
    public long execute(long itemValue)
    {
        if (operator.equals("*")) {
            long factor1 = parseOperand(operand1, itemValue);
            long factor2 = parseOperand(operand2, itemValue);
            return Math.multiplyExact(factor1 , factor2);
        } else {
            return Math.addExact(parseOperand(operand1, itemValue),( parseOperand(operand2, itemValue)));
        }

    }
}
