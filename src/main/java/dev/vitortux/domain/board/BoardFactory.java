package dev.vitortux.domain.board;

import lombok.Getter;

@Getter
public enum BoardFactory {
    EASY(10, 8, 10),
    MEDIUM(18, 14, 40),
    HARD(24, 20, 99);

    private int width;
    private int height;
    private int mines;

    BoardFactory(int width, int height, int mines) {
        this.width = width;
        this.height = height;
        this.mines = mines;
    }

    public Board get() {
        return new Board(width, height, mines);
    }
}
