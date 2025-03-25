package dev.vitortux.domain.game;

public class Board {
    private Node[][] nodes;
    private int bombs;

    public Board(int width, int height, int bombs) {
        this.nodes = new Node[width][height];
        this.bombs = bombs;
        this.init();
    }

    private void init() {
        for (int i = 0; i < nodes.length * nodes[0].length; i++) {
            int row = i / nodes[0].length;
            int col = i % nodes[0].length;
            nodes[row][col] = new Node(NodeType.EMPTY);
        }
    }

    public void reveal(int x, int y) throws NullPointerException {
        this.nodes[x][y].reveal();
    }
}
