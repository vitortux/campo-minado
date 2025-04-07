package dev.vitortux.domain.game.state;

import dev.vitortux.domain.game.Game;

public class Victory implements GameState {

    @Override
    public void onEnter(Game game) {
        game.getSoundtrack().play("win.wav", true);
    }

    @Override
    public void run(Game game) {
    }
}
