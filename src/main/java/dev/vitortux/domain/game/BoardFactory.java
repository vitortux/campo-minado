package dev.vitortux.domain.game;

public enum BoardFactory {
    EASY(8, 10, 10),
    MEDIUM(14, 18, 40),
    HARD(20, 24, 99);

    private int width;
    private int height;
    private int bombs;

    BoardFactory(int width, int height, int bombs) {
        this.width = width;
        this.height = height;
        this.bombs = bombs;
    }

    public Board create() {
        return new Board(width, height, bombs);
    }
}
