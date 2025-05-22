package dev.vitortux.domain.game.state;

import dev.vitortux.domain.game.Game;

public class GameLoosingState implements IGameState {
    private final Game game;

    public GameLoosingState(Game game) {
        this.game = game;
    }

    @Override
    public void playMusic() {
        game.getSoundtrack().play("over.wav", true);
    }

    @Override
    public void run() {

    }
}
