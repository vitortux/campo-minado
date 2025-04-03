package dev.vitortux.domain.node;

public class Closed implements NodeState {

    @Override
    public void reveal(Node node) {
        node.setState(new Revealed());
    }

    @Override
    public void flag(Node node) {
        node.setState(new Flagged());
    }

    @Override
    public void unflag(Node node) {
        node.setState(this);
    }

    @Override
    public void print(int minesAround) {
        System.out.print("🌳 ");
    }
}
