package dev.vitortux.domain.game;

import dev.vitortux.domain.board.Board;
import dev.vitortux.domain.game.state.DifficultySelection;
import dev.vitortux.domain.game.state.GameState;
import dev.vitortux.domain.input.Input;
import dev.vitortux.domain.input.UserCommand;

public class Game {
    private static Game instance;
    private Board board;
    private Input input;
    private GameState state;
    private boolean running;

    private Game() {
        this.input = new Input();
        this.state = new DifficultySelection();
        this.running = true;
    }

    public static Game getInstance() {
        if (instance == null) {
            instance = new Game();
        }
        return instance;
    }

    public void run() {
        while (running) {
            state.run(this);
        }
    }

    public void selectDifficulty() {
        this.board = input.selectDifficulty();
    }

    public void printBoard() {
        this.board.print();
    }

    public void firstMove(int x, int y) {
        this.board.placeMines(x, y);
        this.board.setupNodes();
        this.board.reveal(x, y);
    }

    public UserCommand readCommand() {
        return this.input.readCommand(this.board);
    }

    public Board getBoard() {
        return this.board;
    }

    public GameState getState() {
        return state;
    }

    public void setState(GameState state) {
        this.state = state;
    }
}
