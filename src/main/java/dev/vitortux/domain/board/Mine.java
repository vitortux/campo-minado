package dev.vitortux.domain.board;

import dev.vitortux.domain.game.GameException;

public class Mine implements Node {
    private boolean isFlagged;
    private String value;

    public Mine() {
        this.isFlagged = false;
    }

    public void toggleFlag() {
        this.isFlagged = !this.isFlagged;
    }

    @Override
    public void reveal() throws GameException {
        if (!isFlagged) {
            throw new GameException("BOOM!");
        }
    }
}
