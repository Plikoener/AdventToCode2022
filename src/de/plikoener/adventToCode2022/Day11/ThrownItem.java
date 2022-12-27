package de.plikoener.adventToCode2022.Day11;

public class ThrownItem extends Item {
    public String getReceiverName() {
        return receiverName;
    }

    String receiverName;


    public ThrownItem(int value) {
        super(value);
    }

    public ThrownItem(int value, String receiverName) {
        super(value);
        this.receiverName = receiverName;

    }
}
