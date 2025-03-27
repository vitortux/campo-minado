package dev.vitortux.domain.board;

import dev.vitortux.domain.game.GameException;

public class Node {
    private NodeType type;
    private boolean isFlagged;

    public Node(NodeType type) {
        this.type = type;
    }

    public void toggleFlag() {
        this.isFlagged = !this.isFlagged;
    }

    public void print() {
        System.out.print("*");
    }

    public void reveal() throws GameException {
        this.type.reveal(this);
    }
}
