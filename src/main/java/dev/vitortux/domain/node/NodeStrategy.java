package dev.vitortux.domain.node;

import dev.vitortux.domain.game.GameException;

public interface NodeStrategy {
    void reveal() throws GameException;

    void setState(NodeState state);

    int getMinesAround();

    void setMinesAround(int minesAround);

    void print(NodeStrategy node);

    NodeState getState();
}