package dev.vitortux.domain.game;

import java.util.Scanner;

import dev.vitortux.domain.audio.Soundtrack;
import dev.vitortux.domain.board.Board;
import dev.vitortux.domain.game.state.DifficultySelectionState;
import dev.vitortux.domain.game.state.IGameState;
import lombok.Getter;

@Getter
public class Game {
    private static Game instance;
    private Board board;
    private IGameState state;
    private Soundtrack soundtrack;
    private ResourceLoader resources;
    private boolean running;
    private final Scanner scanner = new Scanner(System.in);

    private Game() {
        this.soundtrack = new Soundtrack();
        this.resources = new ResourceLoader();
        this.running = true;
        this.setState(new DifficultySelectionState(this));
    }

    public static Game getInstance() {
        if (instance == null) {
            instance = new Game();
        }
        return instance;
    }

    public void setBoard(Board board) {
        this.board = board;
    }

    public void setState(IGameState state) {
        this.state = state;
        this.state.music();
    }

    public void run() {
        while (running) {
            state.run();
        }
    }

    public static void main(String[] args) {
        Game game = Game.getInstance();
        game.run();
    }
}
