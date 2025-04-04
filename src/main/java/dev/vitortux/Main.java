package dev.vitortux;

import dev.vitortux.domain.game.Game;

public class Main {
    public static void main(String[] args) {
        Game game = Game.getInstance();
        game.run();
    }
}