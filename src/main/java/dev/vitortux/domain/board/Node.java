package dev.vitortux.domain.board;

import dev.vitortux.domain.game.GameException;

public class Node {
    private NodeType type;
    private int minesAround;
    private boolean isRevealed;
    private boolean isFlagged;

    public Node(NodeType type) {
        this.type = type;
        this.isRevealed = false;
    }

    public void print() {
        if (!isRevealed) {
            System.out.print(type == NodeType.EMPTY ? "🌳 " : "💣 ");
        } else {
            System.out.print(" " + minesAround + " ");
        }
    }

    public NodeType getType() {
        return type;
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

    public boolean isRevealed() {
        return isRevealed;
    }

    public boolean isFlagged() {
        return isFlagged;
    }

    public void setFlagged(boolean isFlagged) {
        this.isFlagged = isFlagged;
    }

    public void reveal() throws GameException {
        this.type.reveal(this);
        this.isRevealed = true;
    }
}
