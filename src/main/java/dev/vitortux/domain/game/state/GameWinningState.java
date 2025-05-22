package dev.vitortux.domain.game.state;

import dev.vitortux.domain.game.Game;

public class GameWinningState implements IGameState {
    private final Game game;

    public GameWinningState(Game game) {
        this.game = game;
    }

    @Override
    public void playMusic() {
        game.getSoundtrack().play("win.wav", true);
    }

    @Override
    public void run() {

    }
}
