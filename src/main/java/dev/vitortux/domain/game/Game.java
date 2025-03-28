package dev.vitortux.domain.game;

import java.util.Scanner;

import dev.vitortux.domain.board.Board;
import dev.vitortux.domain.board.BoardFactory;

public class Game {
    private static final Scanner SCANNER = new Scanner(System.in);
    private static Game instance;
    private Board board;

    private Game() {
        this.board = BoardFactory.EASY.get();
        this.handleFirstPlay();
    }

    public static Game getInstance() {
        if (instance == null) {
            instance = new Game();
        }
        return instance;
    }

    public void start() {
        boolean loop = true;

        while (loop) {
            try {
                this.print();

                System.out.print("Digite a linha: ");
                int x = SCANNER.nextInt();

                System.out.print("Digite a coluna: ");
                int y = SCANNER.nextInt();

                this.reveal(x, y);
            } catch (GameException e) {
                System.out.println("Erro: " + e.getMessage());
                loop = false;
            } catch (Exception e) {
                System.out.println(e.getMessage());
                SCANNER.nextLine();
            }
        }
    }

    private void handleFirstPlay() {
        this.print();

        System.out.print("Digite a linha: ");
        int x = SCANNER.nextInt();

        System.out.print("Digite a coluna: ");
        int y = SCANNER.nextInt();

        this.placeMines(x, y);
    }

    private void reveal(int x, int y) throws GameException {
        this.board.reveal(x, y);
    }

    private void print() {
        this.board.print();
    }

    private void placeMines(int x, int y) {
        this.board.placeMines(x, y);
    }
}
