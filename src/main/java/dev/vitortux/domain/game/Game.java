package dev.vitortux.domain.game;

import dev.vitortux.domain.board.Board;

public class Game {
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

    /**
     * O ideal aqui é mover este try-catch para o método que loopa o jogo. Quando o
     * jogador selecionar uma bomba, o método de game over pode ser chamado, por
     * exemplo.
     */
    public void reveal(int x, int y) {
        try {
            this.board.reveal(x, y);
        } catch (GameException e) {
            // Chamaria o método de game over.
        } catch (NullPointerException e) {
            System.out.println(e.getMessage());
        }
    }
}
