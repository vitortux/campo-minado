package dev.vitortux.domain.game.state;

import dev.vitortux.domain.game.Game;

public interface GameState {
    void run(Game game);
}
