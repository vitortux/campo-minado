package dev.vitortux.domain.board;

public enum BoardFactory {
    EASY(8, 10, 10),
    MEDIUM(14, 18, 40),
    HARD(20, 24, 99);

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
