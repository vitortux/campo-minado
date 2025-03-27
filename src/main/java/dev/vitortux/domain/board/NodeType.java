package dev.vitortux.domain.board;

import dev.vitortux.domain.game.GameException;

public enum NodeType {
    EMPTY {
        @Override
        void reveal(Node node) throws GameException {
            node.print();
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
