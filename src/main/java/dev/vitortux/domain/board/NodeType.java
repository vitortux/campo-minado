package dev.vitortux.domain.board;

import dev.vitortux.domain.game.GameException;

public enum NodeType {
    EMPTY {
        @Override
        void reveal(Node node) {
            // Apenas marca como revelado, já que uma célula vazia não tem efeito especial
        }
    },
    BOMB {
        @Override
        void reveal(Node node) throws GameException {
            if (!node.isFlagged()) {
                throw new GameException("BOOM!");
            }
        }
    };

    abstract void reveal(Node node) throws GameException;
}
