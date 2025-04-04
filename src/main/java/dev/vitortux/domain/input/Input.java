package dev.vitortux.domain.input;

import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import dev.vitortux.domain.board.Board;
import dev.vitortux.domain.board.BoardFactory;

public class Input {
    private static final Scanner SCANNER = new Scanner(System.in);
    private static final Pattern PLAY_PATTERN = Pattern.compile("^play (easy|medium|hard)$");
    private static final Pattern COMMAND_PATTERN = Pattern.compile("^(reveal|flag) (\\d+)([a-zA-Z])$");

    public Board selectDifficulty() {
        Matcher matcher;
        String input;

        System.out.println("\tDigite \"play [dificuldade]\" para jogar e \"exit\" para sair.\n");
        System.out.println("\t\tExemplo: play medium");

        do {
            System.out.print("\n> ");
            input = SCANNER.nextLine();
            matcher = PLAY_PATTERN.matcher(input);

            if (!matcher.matches()) {
                System.out.println("Entrada inválida! Use: play easy, play medium ou play hard.");
            }
        } while (!matcher.matches());

        String difficulty = matcher.group(1).toUpperCase();
        return BoardFactory.valueOf(difficulty.toUpperCase()).get();
    }

    public UserCommand readCommand() {
        String input;
        Matcher matcher;

        do {
            System.out.print("\n> ");
            input = SCANNER.nextLine();
            matcher = COMMAND_PATTERN.matcher(input);

            if (!matcher.matches()) {
                System.out.println("Entrada inválida! Use: reveal [linha][coluna] ou flag [linha][coluna].");
            }
        } while (!matcher.matches());

        String command = matcher.group(1);
        int col = matcher.group(3).toLowerCase().charAt(0) - 'a';
        int row = Integer.parseInt(matcher.group(2)) - 1;

        return new UserCommand(InputType.valueOf(command.toUpperCase()), col, row);
    }
}
