package dev.vitortux.domain.game;

public class Game {
    private static Game instance;
    private Board board;

    private Game() {
    }

    public static Game getInstance() {
        if (instance == null) {
            instance = new Game();
        }
        return instance;
    }

    public void reveal(int x, int y) {
        this.board.reveal(x, y);
    }
}
