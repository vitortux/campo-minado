package dev.vitortux.domain.board;

import dev.vitortux.domain.game.GameException;

public class NodeImpl implements Node {
    private boolean isFlagged;
    private String value;

    public NodeImpl() {
        this.isFlagged = false;
    }

    public void toggleFlag() {
        this.isFlagged = !this.isFlagged;
    }

    public void setValue(String value) {
        this.value = value;
    }

    @Override
    public void reveal() throws GameException {
        if (!isFlagged) {
            System.out.println(value);
        }
    }
}
