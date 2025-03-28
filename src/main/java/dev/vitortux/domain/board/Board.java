package dev.vitortux.domain.board;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import dev.vitortux.domain.game.GameException;

public class Board {
    private Node[][] nodes;
    private int mines;

    public Board(int width, int height, int mines) {
        this.nodes = new Node[width][height];
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
        List<int[]> positions = new ArrayList<>();

        for (int i = 0; i < nodes.length * nodes[0].length; i++) {
            int row = i / nodes[0].length;
            int col = i % nodes[0].length;

            if (row == y && col == x) {
                continue;
            }

            positions.add(new int[] { row, col });
        }

        Collections.shuffle(positions);

        for (int i = 0; i < mines; i++) {
            int[] pos = positions.get(i);
            nodes[pos[0]][pos[1]].setType(NodeType.BOMB);
        }
    }

    public void print() {
        for (int i = 0; i < nodes.length * nodes[0].length; i++) {
            int row = i / nodes[0].length;
            int col = i % nodes[0].length;
            nodes[row][col].print();

            if (col == nodes[0].length - 1) {
                System.out.println();
            }
        }
    }

    // public void reveal(int x, int y) throws GameException {
    // this.nodes[x][y].reveal();
    // }

    public void reveal(int x, int y) throws GameException {
        nodes[x][y].reveal();

        if (nodes[x][y].getMinesAround() == 0) {
            int[][] offsets = {
                    { -1, -1 }, { -1, 0 }, { -1, 1 }, { 0, -1 }, { 0, 1 }, { 1, -1 }, { 1, 0 }, { 1, 1 }
            };

            for (int[] offset : offsets) {
                int nextY = y + offset[0];
                int nextX = x + offset[1];

                reveal(nextY, nextX);
            }
        }
    }
}
