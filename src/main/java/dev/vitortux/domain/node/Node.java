package dev.vitortux.domain.node;

public class Node implements NodeStrategy {
    private NodeState state;
    private int minesAround;

    public Node() {
        this.state = new Closed();
    }

    @Override
    public void reveal() {
        this.state.reveal(this);
    }

    public void flag() {
        this.state.flag(this);
    }

    public void unflag() {
        this.state.unflag(this);
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

    public void print(NodeStrategy node) {
        this.state.print(this);
    }
}
