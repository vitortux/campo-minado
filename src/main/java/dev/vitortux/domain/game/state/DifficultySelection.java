package dev.vitortux.domain.game.state;

import dev.vitortux.domain.game.Game;

public class DifficultySelection implements GameState {

    @Override
    public void onEnter(Game game) {
        game.getSoundtrack().play("menu.wav", true);

        System.out.print("\033[H\033[2J");
        System.out.flush();
    }

    @Override
    public void run(Game game) {
        game.selectDifficulty();
        game.setState(new FirstMove());
    }
}
