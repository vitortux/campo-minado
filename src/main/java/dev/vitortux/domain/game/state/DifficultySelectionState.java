package dev.vitortux.domain.game.state;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import dev.vitortux.domain.board.BoardFactory;
import dev.vitortux.domain.game.Game;

public class DifficultySelectionState implements IGameState {
    private final Game game;
    private final Pattern pattern = Pattern.compile("^play (easy|medium|hard)$");

    public DifficultySelectionState(Game game) {
        this.game = game;
    }

    @Override
    public void playMusic() {
        game.getSoundtrack().play("menu.wav", true);
    }

    @Override
    public void run() {
        this.clear();

        System.out.println("\tDigite \"play [dificuldade]\" para jogar e \"exit\" para sair.\n");
        System.out.println("\t\tExemplo: play medium");

        String input;
        Matcher matcher;

        do {
            System.out.print("\n> ");
            input = game.getScanner().nextLine();
            matcher = pattern.matcher(input);

            if (!matcher.matches()) {
                System.out.println("Entrada inválida! Use: play easy, play medium ou play hard.");
            }
        } while (!matcher.matches());

        String difficulty = matcher.group(1).toUpperCase();
        BoardFactory factory = BoardFactory.valueOf(difficulty);

        game.setState(new FirstMoveState(game, factory));
    }
}
