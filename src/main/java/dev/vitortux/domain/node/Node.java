package dev.vitortux.domain.node;

public class Node {
    private NodeState state;
    private int minesAround;

    public Node() {
        this.state = new Closed();
    }

    public void reveal() {
        this.state.reveal(this);
    }

    public void flag() {
        this.state.flag(this);
    }

    public void unflag() {
        this.state.unflag(this);
    }

    public void print() {
        this.state.print(minesAround);
    }

    public NodeState getState() {
        return state;
    }

    public void setState(NodeState state) {
        this.state = state;
    }

    public int getMinesAround() {
        return minesAround;
    }

    public void setMinesAround(int minesAround) {
        this.minesAround = minesAround;
    }
}
