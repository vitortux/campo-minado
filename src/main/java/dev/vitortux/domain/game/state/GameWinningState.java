package dev.vitortux.domain.game.state;

import java.util.Scanner;

import dev.vitortux.domain.game.Game;

public class GameWinningState implements IGameState {
    private final Game game;
    private final Scanner scanner;
    private final String title;

    public GameWinningState(Game game) {
        this.game = game;
        this.scanner = game.getScanner();
        this.title = game.getResources().load("/text/you_win.txt");
    }

    @Override
    public void run() {
        this.clear();
        System.out.println(title + "\n");
        System.out.println("\tParabéns! Você teve paciência o suficiente pra chegar ao fim do jogo sem perder.");
        System.out.print("\n> ");
        scanner.nextLine();
        System.out.println();
    }

    @Override
    public void music() {
        game.getSoundtrack().play("win.wav", true);
    }
}
