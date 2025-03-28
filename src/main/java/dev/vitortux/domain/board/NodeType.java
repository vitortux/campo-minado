package dev.vitortux.domain.board;

import dev.vitortux.domain.game.GameException;

public enum NodeType {
    EMPTY {
        @Override
        void reveal(Node node) throws GameException {
            // TODO: deve setar o número de bombas ao redor.
        }
    },
    BOMB {
        @Override
        void reveal(Node node) throws GameException {
            throw new GameException("BOOM!");
        }
    };

    abstract void reveal(Node node) throws GameException;
}
