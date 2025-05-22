package dev.vitortux.domain.node.state;

import dev.vitortux.domain.node.Node;

public class RevealedNodeState implements INodeState {

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
        node.setState(this);
    }

    @Override
    public void print(int mines) {
        System.out.print(" " + mines + " ");
    }
}
