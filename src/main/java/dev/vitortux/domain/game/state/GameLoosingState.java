package dev.vitortux.domain.game.state;

import java.util.Scanner;

import dev.vitortux.domain.game.Game;

public class GameLoosingState implements IGameState {
    private final Game game;
    private final Scanner scanner;
    private final String title;

    public GameLoosingState(Game game) {
        this.game = game;
        this.scanner = game.getScanner();
        this.title = game.getResources().load("/text/game_over.txt");
    }

    @Override
    public void run() {
        this.clear();
        System.out.println(title + "\n");
        System.out.println("\tVocê selecionou uma bomba.");
        System.out.print("\n> ");
        scanner.nextLine();
        System.out.println();
    }

    @Override
    public void music() {
        game.getSoundtrack().play("over.wav", true);
    }
}
