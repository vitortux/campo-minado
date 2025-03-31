package dev.vitortux.domain.board;

import java.util.Random;

public class Board {
    private Node[][] nodes;
    private Random random;
    private int mines;

    public Board(int width, int height, int mines) {
        this.nodes = new Node[width][height];
        this.random = new Random();
        this.mines = mines;
        this.init();
    }

    private void init() {
        for (int i = 0; i < nodes.length * nodes[0].length; i++) {
            int row = i / nodes[0].length;
            int col = i % nodes[0].length;
            nodes[row][col] = new Node(NodeType.EMPTY);
        }
    }

    public void placeMines(int x, int y) {
        int placed = 0;

        while (placed < mines) {
            int row = random.nextInt(nodes.length);
            int col = random.nextInt(nodes[0].length);

            if (!(Math.abs(y - row) <= 1 && Math.abs(x - col) <= 1) && (nodes[x][y].getType() != NodeType.BOMB)) {
                nodes[row][col].setType(NodeType.BOMB);
                placed++;
            }
        }
    }

    public void setupNodes() {
        for (int i = 0; i < nodes.length * nodes[0].length; i++) {
            int row = i / nodes[0].length;
            int col = i % nodes[0].length;
            nodes[row][col].setMinesAround(countMinesAroundNode(row, col));
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

            if (isValidPosition(nextX, nextY) && nodes[nextX][nextY].getType() == NodeType.BOMB) {
                count++;
            }
        }

        return count;
    }

    public void reveal(int x, int y) {
        if (nodes[x][y].isRevealed()) {
            return;
        }

        nodes[x][y].reveal();

        if (nodes[x][y].getMinesAround() > 0) {
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

    public void print() {
        System.out.print("\033[H\033[2J");
        System.out.flush();

        System.out.print("    ");
        for (int col = 0; col < nodes[0].length; col++) {
            System.out.print((col + 1) + "  ");
        }
        System.out.println();

        for (int i = 0; i < nodes.length * nodes[0].length; i++) {
            int row = i / nodes[0].length;
            int col = i % nodes[0].length;

            if (col == 0) {
                System.out.printf("%2c ", (char) ('A' + row));
            }

            nodes[row][col].print();

            if (col == nodes[0].length - 1) {
                System.out.println();
            }
        }
    }

    private boolean isValidPosition(int x, int y) {
        return x >= 0 && x < nodes.length && y >= 0 && y < nodes[0].length;
    }
}
