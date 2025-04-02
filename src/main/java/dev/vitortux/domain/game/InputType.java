package dev.vitortux.domain.game;

import dev.vitortux.domain.board.Board;

public enum InputType {
    REVEAL {
        @Override
        public void execute(Board board, int row, int col) {
            board.reveal(row, col);
        }
    },
    FLAG {
        @Override
        public void execute(Board board, int row, int col) {
            // board.setFlag(row, col);
        }
    };

    public abstract void execute(Board board, int row, int col);
}
