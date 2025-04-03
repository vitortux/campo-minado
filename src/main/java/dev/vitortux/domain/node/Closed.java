package dev.vitortux.domain.node;

public class Closed implements NodeState {

    @Override
    public void reveal(NodeStrategy node) {
        node.setState(new Revealed());
    }

    @Override
    public void flag(NodeStrategy node) {
        node.setState(new Flagged());
    }

    @Override
    public void unflag(NodeStrategy node) {
        node.setState(this);
    }

    @Override
    public void print(NodeStrategy node) {
        System.out.print("🌳 ");
    }
}
