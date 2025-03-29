package dev.vitortux.domain.game;

import java.util.Scanner;

import dev.vitortux.domain.board.Board;
import dev.vitortux.domain.board.BoardFactory;

public class Game {
    private static final Scanner SCANNER = new Scanner(System.in);
    private static Game instance;
    private Board board;

    private Game() {
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
                this.board.print();

                System.out.print("Digite a linha: ");
                int x = SCANNER.nextInt();

                System.out.print("Digite a coluna: ");
                int y = SCANNER.nextInt();

                this.board.reveal(x, y);
            } catch (GameException e) {
                System.out.println("Erro: " + e.getMessage());
                loop = false;
            } catch (Exception e) {
                System.out.println(e.getMessage());
                SCANNER.nextLine();
            }
        }
    }

    public void handleFirstPlay() {
        this.board = BoardFactory.EASY.get();

        this.board.print();

        System.out.print("Digite a linha: ");
        int x = SCANNER.nextInt();

        System.out.print("Digite a coluna: ");
        int y = SCANNER.nextInt();

        this.board.placeMines(x, y);
        this.board.setupNodes();
        this.board.reveal(x, y);
    }
}
