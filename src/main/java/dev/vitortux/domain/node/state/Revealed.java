package dev.vitortux.domain.node.state;

import dev.vitortux.domain.node.Node;

public class Revealed implements NodeState {

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
    public void print(int minesAround) {
        System.out.print(" " + minesAround + " ");
    }
}
