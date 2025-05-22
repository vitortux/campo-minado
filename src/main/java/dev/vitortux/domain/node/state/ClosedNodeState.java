package dev.vitortux.domain.node.state;

import dev.vitortux.domain.node.Node;

public class ClosedNodeState implements INodeState {

    @Override
    public void reveal(Node node) {
        node.setState(new RevealedNodeState());
    }

    @Override
    public void flag(Node node) {
        node.setState(new FlaggedNodeState());
    }

    @Override
    public void unflag(Node node) {
        node.setState(this);
    }

    @Override
    public void print(int mines) {
        System.out.print("🌳 ");
    }
}
