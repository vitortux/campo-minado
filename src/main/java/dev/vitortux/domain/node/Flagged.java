package dev.vitortux.domain.node;

public class Flagged implements NodeState {

    @Override
    public void reveal(Node node) {
        node.setState(this);
    }

    @Override
    public void flag(Node node) {
        node.setState(this);
    }

    @Override
    public void unflag(Node node) {
        node.setState(new Closed());
    }

    @Override
    public void print(int minesAround) {
        System.out.print("🚩 ");
    }
}
