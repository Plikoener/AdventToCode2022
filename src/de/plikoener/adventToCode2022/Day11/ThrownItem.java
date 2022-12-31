package de.plikoener.adventToCode2022.Day11;

public class ThrownItem extends Item {

    String receiverName;

    int priority;


    public ThrownItem(long value, String receiverName) {
        super(value);
        this.receiverName = receiverName;

    }

    public ThrownItem(long value, String receiverName, int priority) {
        this(value, receiverName);
        this.priority = priority;
    }

    @Override
    public String toString() {
        return "ThrownItem{" +
                "value='" + getValue() + '\'' +
                "receiverName='" + receiverName + '\'' +
                '}';
    }
}
