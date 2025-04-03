package dev.vitortux;

import dev.vitortux.domain.board.Board;
import dev.vitortux.domain.board.BoardFactory;

public class Main {
    public static void main(String[] args) {
        Board board = BoardFactory.MEDIUM.get();
        board.placeMines(5, 5);
        board.setupNodes();
        board.print();
        board.reveal(5, 5);
        board.print();
    }
}