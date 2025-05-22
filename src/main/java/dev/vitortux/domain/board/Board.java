package dev.vitortux.domain.board;

import java.util.Random;

import dev.vitortux.domain.node.Mine;
import dev.vitortux.domain.node.Node;
import dev.vitortux.domain.node.state.FlaggedNodeState;
import dev.vitortux.domain.node.state.RevealedNodeState;

public class Board {
    private Node[][] nodes;
    private Random random;
    private int mines;
    private int revealed;

    public Board(int width, int height, int mines) {
        this.nodes = new Node[width][height];
        this.random = new Random();
        this.mines = mines;
        this.revealed = 0;
        this.init();
    }

    private void init() {
        for (int i = 0; i < nodes.length * nodes[0].length; i++) {
            int row = i / nodes[0].length;
            int col = i % nodes[0].length;
            nodes[row][col] = new Node();
        }
    }

    public void placeMines(int x, int y) {
        if (!isValidPosition(x, y)) {
            return;
        }

        int placed = 0;

        while (placed < mines) {
            int row = random.nextInt(nodes.length);
            int col = random.nextInt(nodes[0].length);

            if (!(Math.abs(y - row) <= 1 && Math.abs(x - col) <= 1) && !(nodes[x][y] instanceof Mine)) {
                nodes[row][col] = new Mine();
                placed++;
            }
        }
    }

    public void setupNodes() {
        for (int i = 0; i < nodes.length * nodes[0].length; i++) {
            int row = i / nodes[0].length;
            int col = i % nodes[0].length;
            nodes[row][col].setMines(countMinesAroundNode(row, col));
        }
    }

    private int countMinesAroundNode(int row, int col) {
        int count = 0;

        for (int i = 0; i < 9; i++) {
            int xOffset = i / 3 - 1;
            int yOffset = i % 3 - 1;

            if (xOffset == 0 && yOffset == 0) {
                continue;
            }

            int nextX = row + xOffset;
            int nextY = col + yOffset;

            if (isValidPosition(nextX, nextY) && nodes[nextX][nextY] instanceof Mine) {
                count++;
            }
        }

        return count;
    }

    public void reveal(int x, int y) {
        if (!isValidPosition(x, y)) {
            return;
        }

        Node node = nodes[x][y];

        if (node.getState() instanceof FlaggedNodeState || node.getState() instanceof RevealedNodeState) {
            return;
        }

        node.reveal();
        revealed++;

        if (nodes[x][y].getMines() > 0) {
            return;
        }

        for (int i = 0; i < 8; i++) {
            int xOffset = (i / 3) - 1;
            int yOffset = (i % 3) - 1;

            if (xOffset == 0 && yOffset == 0) {
                continue;
            }

            int nextX = x + xOffset;
            int nextY = y + yOffset;

            if (isValidPosition(nextX, nextY)) {
                reveal(nextX, nextY);
            }
        }
    }

    public void flag(int x, int y) {
        if (!isValidPosition(x, y)) {
            return;
        }

        Node node = nodes[x][y];

        if (node.getState() instanceof FlaggedNodeState) {
            node.unflag();
        } else {
            node.flag();
        }
    }

    public void print() {
        System.out.print("   ");
        for (int col = 0; col < nodes.length; col++) {
            System.out.printf("%2c ", (char) ('A' + col));
        }
        System.out.println();

        for (int i = 0; i < nodes.length * nodes[0].length; i++) {
            int col = i / nodes.length;
            int row = i % nodes.length;

            if (row == 0) {
                System.out.printf("%2d ", col + 1);
            }

            nodes[row][col].print();

            if (row == nodes.length - 1) {
                System.out.println();
            }
        }
    }

    public boolean isValidPosition(int x, int y) {
        return x >= 0 && x < nodes.length && y >= 0 && y < nodes[0].length;
    }

    public boolean isCleared() {
        return revealed == (nodes.length * nodes[0].length - mines);
    }

    public static class BoardBuilder {
        private int width;
        private int height;
        private int mines;
        private int firstMoveX;
        private int firstMoveY;

        public BoardBuilder setWidth(int width) {
            this.width = width;
            return this;
        }

        public BoardBuilder setHeight(int height) {
            this.height = height;
            return this;
        }

        public BoardBuilder setMines(int mines) {
            this.mines = mines;
            return this;
        }

        public BoardBuilder setFirstMove(int x, int y) {
            this.firstMoveX = x;
            this.firstMoveY = y;
            return this;
        }

        public Board build() {
            Board board = new Board(width, height, mines);
            board.placeMines(firstMoveX, firstMoveY);
            board.setupNodes();
            board.reveal(firstMoveX, firstMoveY);
            return board;
        }
    }
}
