package dev.vitortux.domain.board;

import dev.vitortux.domain.game.GameException;

public enum NodeType {
    EMPTY {
        @Override
        void reveal() throws GameException {
            // Deve mostrar a quantidade de bombas ao redor, e revelar todas as células ao
            // redor que não sejam bombas.
        }
    },
    FLAG {
        @Override
        void reveal() throws GameException {
            // Deve revelar todas as células ao redor que não sejam bombas.
        }
    },
    BOMB {
        @Override
        void reveal() throws GameException {
            throw new GameException("Boom! Você acionou uma bomba!");
        }
    };

    abstract void reveal() throws GameException;
}
