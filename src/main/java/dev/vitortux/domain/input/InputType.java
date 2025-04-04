package dev.vitortux.domain.input;

import dev.vitortux.domain.board.Board;

public enum InputType {
    REVEAL {
        @Override
        public void execute(Board board, int col, int row) {
            board.reveal(col, row);
        }
    },
    FLAG {
        @Override
        public void execute(Board board, int col, int row) {
            board.flag(col, row);
        }
    };

    public abstract void execute(Board board, int col, int row);
}
