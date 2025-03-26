package dev.vitortux.domain.board;

import dev.vitortux.domain.game.GameException;

public class Board {
    private NodeImpl[][] nodes;
    private int mines;

    public Board(int width, int height, int mines) {
        this.nodes = new NodeImpl[width][height];
        this.mines = mines;
        this.init();
    }

    private void init() {
        for (int i = 0; i < nodes.length * nodes[0].length; i++) {
            int row = i / nodes[0].length;
            int col = i % nodes[0].length;
            nodes[row][col] = new NodeImpl();
        }
    }

    public void reveal(int x, int y) throws GameException {
        this.nodes[x][y].reveal();
    }
}
