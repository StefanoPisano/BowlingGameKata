package me.bowlinggame;

public class Roll {
    private int index;
    private int knocked;

    public Roll(int index, int knocked) {
        this.index = index;
        this.knocked = knocked;
    }

    public int getIndex() {
        return index;
    }

    public int getKnocked() {
        return knocked;
    }
}
