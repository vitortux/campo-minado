package dev.vitortux;

import dev.vitortux.domain.board.Board;
import dev.vitortux.domain.board.BoardFactory;

public class Main {
    public static void main(String[] args) {
        Board board = BoardFactory.EASY.get();
        board.placeMines(5, 5);
        board.setupNodes();
        board.print();
    }
}