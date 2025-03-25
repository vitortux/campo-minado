package dev.vitortux.domain.game;

public enum NodeType {
    EMPTY {
        @Override
        void reveal() {
            // Deve mostrar a quantidade de bombas ao redor, e revelar todas as células ao
            // redor que não sejam bombas.
        }
    },
    FLAG {
        @Override
        void reveal() {
            // Deve revelar todas as células ao redor que não sejam bombas.
        }
    },
    BOMB {
        @Override
        void reveal() {
            // Deve lançar uma exception para encerrar o jogo.
        }
    };

    abstract void reveal();
}
