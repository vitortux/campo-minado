package dev.vitortux.domain.board;

import dev.vitortux.domain.game.GameException;

public class Node {
    private NodeType type;
    private boolean isFlagged;
    private int minesAround;

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

    public void setType(NodeType type) {
        this.type = type;
    }

    public int getMinesAround() {
        return minesAround;
    }

    public void setMinesAround(int minesAround) {
        this.minesAround = minesAround;
    }
}
