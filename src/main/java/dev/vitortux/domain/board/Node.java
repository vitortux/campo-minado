package dev.vitortux.domain.board;

import dev.vitortux.domain.game.GameException;

public interface Node {
    void reveal() throws GameException;
}
