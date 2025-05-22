package dev.vitortux.domain.game.state;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import dev.vitortux.domain.board.Board;
import dev.vitortux.domain.board.Board.BoardBuilder;
import dev.vitortux.domain.board.BoardFactory;
import dev.vitortux.domain.game.Game;

public class FirstMoveState implements IGameState {
    private final Game game;
    private final BoardFactory factory;
    private final Pattern pattern = Pattern.compile("^(reveal) (\\d+)([a-zA-Z])$");

    public FirstMoveState(Game game, BoardFactory factory) {
        this.game = game;
        this.factory = factory;
    }

    @Override
    public void playMusic() {
        game.getSoundtrack().play("running.wav", true);
    }

    @Override
    public void run() {
        this.clear();

        this.printEmptyBoard(factory.getWidth(), factory.getHeight());

        String input;
        Matcher matcher;
        boolean valid = false;

        do {
            System.out.print("\n> ");
            input = game.getScanner().nextLine();
            matcher = pattern.matcher(input);

            if (!matcher.matches()) {
                System.out.println("Entrada inválida! Use: reveal [linha][coluna] para revelar sua primeira célula.");
                continue;
            }

            int col = matcher.group(3).toLowerCase().charAt(0) - 'a';
            int row = Integer.parseInt(matcher.group(2)) - 1;

            if (row < 0 || row >= factory.getHeight() || col < 0 || col >= factory.getWidth()) {
                System.out.println("Coordenadas fora dos limites do tabuleiro.");
                continue;
            }

            Board board = new BoardBuilder()
                    .setWidth(factory.getWidth())
                    .setHeight(factory.getHeight())
                    .setMines(factory.getMines())
                    .setFirstMove(row, col)
                    .build();

            game.setBoard(board);
            game.setState(new GameLoopState(game));
            valid = true;
        } while (!valid);
    }

    private void printEmptyBoard(int width, int height) {
        System.out.print("   ");
        for (int col = 0; col < width; col++) {
            System.out.printf("%2c ", (char) ('A' + col));
        }
        System.out.println();

        for (int row = 0; row < height; row++) {
            System.out.printf("%2d ", row + 1);
            for (int col = 0; col < width; col++) {
                System.out.print("🌳 ");
            }
            System.out.println();
        }
    }
}
