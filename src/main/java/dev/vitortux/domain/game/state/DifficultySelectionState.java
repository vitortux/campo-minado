package dev.vitortux.domain.game.state;

import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import dev.vitortux.domain.board.BoardFactory;
import dev.vitortux.domain.game.Game;

public class DifficultySelectionState implements IGameState {
    private final Game game;
    private final Scanner scanner;
    private final Pattern pattern = Pattern.compile("^play (easy|medium|hard)$");
    private final String title;

    public DifficultySelectionState(Game game) {
        this.game = game;
        this.scanner = game.getScanner();
        this.title = game.getResources().load("/text/game_title.txt");
    }

    @Override
    public void run() {
        this.clear();
        System.out.println(title);
        System.out.println("\t\nDigite \"play [dificuldade]\" para jogar e \"exit\" para sair.\n");
        System.out.println("\t\tExemplo: play medium");

        String difficulty = getInput();
        BoardFactory factory = BoardFactory.valueOf(difficulty);

        game.setState(new DisplayRulesState(game, factory));
    }

    @Override
    public void music() {
        game.getSoundtrack().play("menu.wav", true);
    }

    private String getInput() {
        String input;
        Matcher matcher;

        do {
            System.out.print("\n> ");
            input = scanner.nextLine();
            matcher = pattern.matcher(input);

            if (!matcher.matches()) {
                System.out.println("Entrada inválida! Use: play easy, play medium ou play hard.");
            }
        } while (!matcher.matches());

        return matcher.group(1).toUpperCase();
    }
}
