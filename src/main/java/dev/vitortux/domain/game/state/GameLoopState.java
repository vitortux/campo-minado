package dev.vitortux.domain.game.state;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import dev.vitortux.domain.game.Game;
import dev.vitortux.domain.game.GameException;
import dev.vitortux.domain.input.InputType;
import dev.vitortux.domain.input.UserCommand;

public class GameLoopState implements IGameState {
    private final Game game;
    private final Pattern pattern = Pattern.compile("^(reveal|flag) (\\d+)([a-zA-Z])$");

    public GameLoopState(Game game) {
        this.game = game;
    }

    @Override
    public void run() {
        this.clear();

        this.game.getBoard().print();

        UserCommand command = readCommand();

        try {
            command.input().execute(game.getBoard(), command.col(), command.row());

            if (game.getBoard().isCleared()) {
                game.setState(new GameWinningState(game));
            }
        } catch (GameException e) {
            System.out.println(e.getMessage());
            game.setState(new GameLoosingState(game));
        }
    }

    private UserCommand readCommand() {
        boolean valid = false;
        UserCommand command = null;

        do {
            System.out.print("\n> ");
            String input = game.getScanner().nextLine();
            Matcher matcher = pattern.matcher(input);

            if (matcher.matches()) {
                int col = matcher.group(3).toLowerCase().charAt(0) - 'a';
                int row = Integer.parseInt(matcher.group(2)) - 1;

                if (game.getBoard().isValidPosition(col, row)) {
                    String commandStr = matcher.group(1);
                    command = new UserCommand(InputType.valueOf(commandStr.toUpperCase()), col, row);
                    valid = true;
                } else {
                    System.out.println("Coordenadas inválidas! Tente novamente.");
                }
            } else {
                System.out.println("Entrada inválida! Use: reveal [linha][coluna] ou flag [linha][coluna].");
            }
        } while (!valid);

        return command;
    }

    @Override
    public void music() {
    }
}
