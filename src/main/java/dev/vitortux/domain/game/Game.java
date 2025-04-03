package dev.vitortux.domain.game;

import dev.vitortux.domain.board.Board;
import dev.vitortux.domain.input.Input;

public class Game {
    private static Game instance;
    private Board board;
    private Input input;

    private Game() {
        this.input = new Input();
    }

    public static Game getInstance() {
        if (instance == null) {
            instance = new Game();
        }
        return instance;
    }
}
