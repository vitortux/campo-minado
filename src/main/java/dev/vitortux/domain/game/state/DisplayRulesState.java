package dev.vitortux.domain.game.state;

import java.util.Scanner;

import dev.vitortux.domain.board.BoardFactory;
import dev.vitortux.domain.game.Game;

public class DisplayRulesState implements IGameState {
    private final Game game;
    private final Scanner scanner;
    private final BoardFactory factory;
    private final String rules;

    public DisplayRulesState(Game game, BoardFactory factory) {
        this.game = game;
        this.factory = factory;
        this.scanner = game.getScanner();
        this.rules = game.getResources().load("/text/game_rules.txt");
    }

    @Override
    public void run() {
        this.clear();
        System.out.println(rules);
        System.out.println("\n\t1. O objetivo é descobrir todas as células do tabuleiro sem selecionar uma mina.");
        System.out.println("\t2. Cada célula pode conter uma mina ou um número indicando minas ao redor.");
        System.out.println("\t3. Selecionar uma célula com uma mina termina o jogo.");
        System.out.println("\t4. O jogo termina quando todas as células sem minas forem abertas.");
        System.out.print("\n> ");
        scanner.nextLine();
        System.out.println();

        game.setState(new FirstMoveState(game, factory));

    }

    @Override
    public void music() {

    }
}
