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

    private void mines(int x, int y) {
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
            nodes[pos[0]][pos[1]] = new Node(NodeType.BOMB);
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

    public void reveal(int x, int y) throws GameException {
        this.nodes[x][y].reveal();
    }
}
