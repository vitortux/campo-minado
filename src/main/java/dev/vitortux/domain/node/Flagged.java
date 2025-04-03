package dev.vitortux.domain.node;

public class Flagged implements NodeState {

    @Override
    public void reveal(NodeStrategy node) {
        node.setState(this);
    }

    @Override
    public void flag(NodeStrategy node) {
        node.setState(this);
    }

    @Override
    public void unflag(NodeStrategy node) {
        node.setState(new Closed());
    }

    @Override
    public void print(NodeStrategy node) {
        System.out.print("🚩 ");
    }
}
